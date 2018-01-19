package cn.itcast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
/**
 * @CarlosYYG
 * 登录验证
 * 
 */

@Controller
public class UserController {
	
	//注入UserService
	@Autowired
	private UserService userService;

	/**
	 * 登录验证 并通过session回显登录的用户名
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("loginCheck")
	@ResponseBody
	public String loginToIndex(User user,HttpSession session){
		
		boolean success = userService.getUser(user);
		
		//登录成功  返回200
		if(success){
			session.setAttribute("username", user.getUsername());
			return "200";
		}
		
		//登录失败  随便返回一个字符串
		return "1000";
		
	}
	
}
