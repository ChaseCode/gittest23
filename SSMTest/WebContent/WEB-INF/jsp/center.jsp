<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="${pageContext.request.contextPath}/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="${pageContext.request.contextPath}/css/Common.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/Index2.css" rel="stylesheet" />
</head>
<body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>数据列表</h4>
            <div>
            	<form action="#">
            		 <div class="uinArea" id="uinArea">
						客户名称：
                	 <input type="text" id="cust_username" name="cust_username1" class="inputstyle"  
                	 	value = "${ cust_username1 }"
                	 />
                		客户类型：
               		<select id="cust_type" name="cust_type1" class="inputstyle">
               			<option value = "">---请选择---</option>
               			<c:forEach items = "${typeList}" var = "type" >
               				<option value = "${type}"<c:if test="${cust_type1 == type}">selected</c:if>>${type}</option>
               			</c:forEach>
               		</select>
               		<input type="submit" value="查询" style="width:60px;" class="button_blue"/>
                </div>
            	</form>
            </div>
            <div class="add"><a class="btn btn-success" onclick="openadd();">新增</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                        <thead>
                            <tr>
                                <th>客户名称</th>
                                <th>客户类型</th>
                                <th>客户电话</th>
                                <th>客户地址</th>
                                <th>所属用户角色</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                        	<c:forEach items = "${ custList }" var = "cust">
                        	 <tr>
                                <th>${cust.custName}</th>
                                <th>${cust.custType}</th>
                                <th>${cust.custPhone}</th>
                                <th>${cust.custAddress}</th>
                                <th>${cust.nickname}</th>
                                <th><a href="#" onclick="dele(${cust.cid})">删除</a></th>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>

            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加客户</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" >
                        <div class="control-group">
                            <label class="control-label" for="custName">客户名称</label>
                            <div class="controls">
                                <input name = "custName" type="text" id="custName" placeholder="客户名称"><span id = "custNameMsg"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">客户类型</label>
                            <div class="controls">
                                <!-- <input type="text" id="custType" placeholder="客户类型"> -->
                                <select name = "custType" id = "custType">
                                
                                </select><span id = "custTypeMsg"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Math">客户电话</label>
                            <div class="controls">
                                <input name = "custPhone" type="text" id="custPhone" placeholder="客户电话"><span id = "custPhoneMsg"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">客户地址</label>
                            <div class="controls">
                                <input  name = "custAddress" type="text" id="custAddress" placeholder="客户地址"><span id = "custAddressMsg"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">所属用户角色</label>
                            <div class="controls">
                                <!-- <input type="text" id="custLinkUser" placeholder="所属用户角色"> -->
                                <select name = "custLinkUser" id = "custLinkUser" >
                                </select><span id = "custLinkUserMsg"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button  class="btn btn-primary" id="add" onclick="add()">保存</button>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/Index2.js"></script>
</body>
</html>