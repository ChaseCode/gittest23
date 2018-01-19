package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.User;
/**
 * @CarlosYYG
 * 
 */
public interface UserMapper {

	//登录验证 
	public int loginCheck(User user);

	//查询所有用户nickname
	public List<User> findAddUser();
	
}
