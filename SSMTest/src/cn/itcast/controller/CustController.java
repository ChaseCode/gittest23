package cn.itcast.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.pojo.Cust;
import cn.itcast.pojo.CustWithNickname;
import cn.itcast.pojo.QueryVO;
import cn.itcast.pojo.User;
import cn.itcast.service.CustService;
import cn.itcast.service.UserService;

/**
 * @CarlosYYG
 * 
 */

@Controller
public class CustController {
	
	/**
	 *  注入custService 和  userService
	 */
	@Autowired
	private CustService custService;
	
	@Autowired
	private UserService userService;
	
	@Value("${custTypeString}")
	private String custTypeString;
	
	/**
	 * 登录成功后请求index页面请求center  
	 * 客户搜索功能与登陆后页面的请求一样 参数用包装类vo
	 * model回显数据
	 *
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("center")
	public String toCenter(QueryVO vo,Model model) throws Exception{
		
		//登录成功后的请求数据并没有带查询条件 需进行判断并进行乱码处理
		if(vo.getCust_username1() != null && vo.getCust_username1() != ""){
			//解决get请求乱码  如已配置tomcat则不需要加
			//vo.setCust_username1(new String(vo.getCust_username1().getBytes("ISO8859-1"),"UTF-8"));
			//将搜索条件回显到页面
			model.addAttribute("cust_username1", vo.getCust_username1());
		}
		if(vo.getCust_type1() != null && vo.getCust_type1() != ""){
			//解决get请求乱码  如已配置tomcat则不需要加
			//vo.setCust_type1(new String(vo.getCust_type1().getBytes("ISO8859-1"),"UTF-8"));
			//将搜索条件回显到页面
			model.addAttribute("cust_type1", vo.getCust_type1());
		}
		
		//带条件查询客户列表
		List<CustWithNickname> custList = custService.findAllUser(vo);
		
		//搜索条件下拉框数据回显（用户类型）
		List<String> custType = new ArrayList<>();
		
		//根据","切割外部资源文件中引入的字符串 并遍历添加到集合中
		String[] custTypeArr = custTypeString.split(",");
		
		for (String string : custTypeArr) {
			custType.add(string);
		}
		
		//用户数据回显
		model.addAttribute("custList", custList);
		
		//用户类型数据回显
		model.addAttribute("typeList", custType);
		
		return "center";
	}
	
	
	/**
	 * 添加客户
	 * @param cust
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add( Cust cust){
		
		//调用添加客户的方法
		custService.add(cust);
		
		//添加成功返回200
		return "200";
	}
	
	
	/**
	 * 以JSON回显下拉框用户类型
	 * 
	 * @return
	 */
	@RequestMapping("findAddCustType")
	@ResponseBody
	public List<String> findAddMeg(){
		
		//搜索条件下拉框数据回显（用户类型）
		List<String> custType = new ArrayList<>();
		
		//根据","切割外部资源文件中引入的字符串 并遍历添加到集合中
		String[] custTypeArr = custTypeString.split(",");
		
		for (String string : custTypeArr) {
			custType.add(string);
		}
		
		return custType;
	}
	
	
	/**
	 * 以JSON回显添加框中的所属用户角色的下拉框数据
	 * 
	 * @return
	 */
	@RequestMapping("findAddUser")
	@ResponseBody
	public List<User> findAddUser(){
		
		List<User> list = userService.findAddUser();
		
		return list;
	}
	
	
	/**
	 * 根据ID删除客户
	 * @param cid
	 * @return
	 */
	@RequestMapping("dele")
	@ResponseBody
	public String deleteCust(Integer cid){
		
		custService.deleteCust(cid);
		
		return "200";
	}
}
