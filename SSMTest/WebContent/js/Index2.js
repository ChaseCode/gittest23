var curr = 1;
$(function () {
    load(curr);
})


function load(curr) {
    $.ajax({
        url: "../Json/Index.aspx",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: { "flag": "load", "curr": curr },
        success: function (data) {

            var html = "";
            $.each(data.items, function (i, item) {
                html += " <tr> " +
                        " <td>" + item.userName + "</td> " +
                        " <td>" + item.Chinese + "</td> " +
                        " <td>" + item.Math + "</td> " +
                        " <td>" + item.English + "</td> " +
                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.userName + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.userName + "\");'>删除</a></td> " +
                        " </tr>";
            })
            $("#tbody").html(html);
            laypage({
                cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                pages: Math.ceil(data.cnt / 10), //通过后台拿到的总页数
                skin: "#49afcd",
                curr: curr || 1, //当前页
                jump: function (obj, first) { //触发分页后的回调
                    if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                        curr = obj.curr;
                        load(curr);
                    }
                }
            });

        }
    })
}

function openadd() {
    $("#myModalLabel").text("添加用户");
    $("#userName").attr("readonly", false);
    $("input").val("");
    
    //打开增加页面时清空上次选择遗留的数据
    $('#custType').html("<option value = ''>---请选择---</option>");
	$('#custLinkUser').html("<option value = ''>---请选择---</option>");
	
	//打开增加页面时清空上次前端验证的提示数据
	$('#custNameMsg').html("");
	$('#custTypeMsg').html("");
	$('#custPhoneMsg').html("");
	$('#custAddressMsg').html("");
	$('#custLinkUserMsg').html("");
	
	//异步请求客户类型数据 并挂到select下拉框中
    $.post("findAddCustType",function(data) {
    	//返回json格式的list 进行遍历 并挂到下拉框中
    	if(data != null){
			for(var i = 0; i < data.length; i++){
				var optValue = data[i];
				var option = "<option value = '"+  optValue +"'>"+ optValue +"</option>";
				//通过append方法  追加到下拉框中
				$('#custType').append(option);
			}
		}
    });
    
    //异步请求客户所属用户数据 并挂到select下拉框中
    $.post("findAddUser",function(data) {
    	//返回json格式的list 进行遍历 并挂到下拉框中
    	if(data != null){
			for(var i = 0; i < data.length; i++){
				var optValue = data[i];
				var option = "<option value = '"+  optValue.uid +"'>"+ optValue.nickname +"</option>";
				//通过append方法  追加到下拉框中
				$('#custLinkUser').append(option);
			}
		}
    });
    
    $("#addModal").modal("show");
    $("#add").show();
    $("#edt").hide();
}


//根据id删除客户的方法
function dele(cid) {
	//通过ajax get请求拼接url的方式删除客户
    $.ajax({
        url: "dele?cid=" + cid,
        dataType: "json",
        type: "post",
        success: function (data) {
        	//请求成功刷新页面
            window.location.reload();
        }
    })
}


function add() {
	//打开添加框时清空上次未成功提交遗留的数据
	$('#custNameMsg').html("");
	$('#custTypeMsg').html("");
	$('#custPhoneMsg').html("");
	$('#custAddressMsg').html("");
	$('#custLinkUserMsg').html("");
	
	//非空验证 为空则停止方法 并将提示显示到页面上
    if ($("#custName").val() == "") {
    	$('#custNameMsg').html("<font color = 'red ' size = '2'>请输入客户名称！！</font>");
        return;
    }
    
    if ($("#custType").val() == "") {
    	$('#custTypeMsg').html("<font color = 'red ' size = '2'>请选择客户类型！！</font>");
        return;
    }
    
    if ($("#custPhone").val() == "") {
    	$('#custPhoneMsg').html("<font color = 'red ' size = '2'>请输入客户电话！！</font>");
        return;
    }
    
    if ($("#custAddress").val() == "") {
    	$('#custAddressMsg').html("<font color = 'red ' size = '2'>请输入客户地址！！</font>");
        return;
    }
    
    if ($("#custLinkUser").val() == "") {
    	$('#custLinkUserMsg').html("<font color = 'red ' size = '2'>请选择所属用户！！</font>");
        return;
    }
    
    //获取表单数据
    var formdata = {
        "custName": $("#custName").val(),
        "custType": $("#custType").val(),
        "custPhone": $("#custPhone").val(),
        "custAddress": $("#custAddress").val(),
        "custLinkUser": $("#custLinkUser").val()
    }
    //alert("dddd" +  $("#custLinkUser").val())
    //ajax提交数据
    $.ajax({
        url: "add",
        dataType: "json",
        type: "post",
        data: formdata,
        //contentType:'application/json',
        success: function (data) {
            $("#addModal").modal("hide");
            $("input").val("");
            //提交成功则刷新页面
            window.location.reload();
        }
    })
}


function openedt(userName) {
    $.ajax({
        url: "../Json/Index.aspx",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: { "flag": "getUser", "userName": userName },
        success: function (data) {
            $("#myModalLabel").text("修改成绩");
            $("#userName").val(data.userName);
            $("#userName").attr("readonly", true);
            $("#Chinese").val(data.Chinese);
            $("#Math").val(data.Math);
            $("#English").val(data.English);

            $("#edt").show();
            $("#add").hide();
            $("#addModal").modal("show");
        }
    })
}

function edt() {
    if ($("#userName").val() == "") {
        layer.tips('不能为空', '#userName');
        return;
    }
    if ($("#Chinese").val() == "") {
        layer.tips('不能为空', '#Chinese');
        return;
    }
    if ($("#Math").val() == "") {
        layer.tips('不能为空', '#Math');
        return;
    }
    if ($("#English").val() == "") {
        layer.tips('不能为空', '#English');
        return;
    }
    var formdata = {
        flag: "edt",
        userName: $("#userName").val(),
        Chinese: $("#Chinese").val(),
        Math: $("#Math").val(),
        English: $("#English").val()
    }
    $.ajax({
        url: "../Json/Index.aspx",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: formdata,
        success: function (data) {
            $("#addModal").modal("hide");
            layer.alert(data.msg);
            $("input").val("");
            load(curr);
        }
    })
}


function del(userName) {
    //询问框
    layer.confirm('您确定要删除？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            url: "../Json/Index.aspx",
            timeout: 300000,
            dataType: "json",
            type: "post",
            data: { "flag": "del", "userName": userName },
            success: function (data) {
                layer.alert(data.msg);
                load(curr);
            }
        })
    }, function () {
        //  layer.close();
    });

}