package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Cust;
import cn.itcast.pojo.CustWithNickname;
import cn.itcast.pojo.QueryVO;
/**
 * @CarlosYYG
 * 
 */
public interface CustService {
	
	//带条件查询客户
	List<CustWithNickname> findAllUser(QueryVO vo);

	//添加客户
	void add(Cust cust);

	//删除客户
	void deleteCust(int cid);

}
