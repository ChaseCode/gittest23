package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @CarlosYYG
 * 页面跳转
 */

@Controller
public class PageController {

	/**
	 * 跳转到login页面
	 * @return
	 */
	@RequestMapping("login")
	public String toLogin(){
		return "login";
	}
	
	
	/**
	 * 跳转到index页面
	 * @return
	 */
	@RequestMapping("index")
	public String toIndex(){
		return "index";
	}
	
}
