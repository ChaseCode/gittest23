package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.User;
/**
 * @CarlosYYG
 * 
 */
public interface UserService {

	public boolean getUser(User user);

	public List<User> findAddUser();
	
}
