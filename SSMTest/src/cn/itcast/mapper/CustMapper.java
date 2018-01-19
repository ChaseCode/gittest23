package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.Cust;
import cn.itcast.pojo.CustWithNickname;
import cn.itcast.pojo.QueryVO;
/**
 * @CarlosYYG
 * 
 */
public interface CustMapper {
	
	//根据条件查询用户
	public List<CustWithNickname> findAllCust(QueryVO vo);

	//添加用户
	public void add(Cust cust);

	//删除用户
	public void deleteCust(int cid);
	
}
