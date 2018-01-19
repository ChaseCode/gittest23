package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
/**
 * @CarlosYYG
 * 一对一关联查询 使用增强类的方式 
 * 
 */
@Service
public class UserServiceImpl implements UserService{

	//注入UserMapper
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 登录验证
	 * 如果查询到数据则返回true 查询不到则返回false
	 * 
	 */
	@Override
	public boolean getUser(User user){
		
		int count = userMapper.loginCheck(user);
		
		//3元运算符
		return count > 0 ? true : false ;
	}

	/**
	 * 查询所属用户
	 * 
	 */
	@Override
	public List<User> findAddUser() {
		return userMapper.findAddUser();
	}
	
}
