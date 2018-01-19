package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.CustMapper;
import cn.itcast.pojo.Cust;
import cn.itcast.pojo.CustWithNickname;
import cn.itcast.pojo.QueryVO;
import cn.itcast.service.CustService;
/**
 * @CarlosYYG
 * 
 */
@Service
public class CustServiceImpl implements CustService{

	//注入CustMapper
	@Autowired
	private CustMapper custMapper;
	
	/**
	 * 根据条件查询所有客户及其所属用户
	 * 
	 */
	@Override
	public List<CustWithNickname> findAllUser(QueryVO vo) {
		
		return custMapper.findAllCust(vo);
		
	}

	/**
	 * 添加客户
	 */
	@Override
	public void add(Cust cust) {
		
		custMapper.add(cust);
		
	}

	/**
	 * 删除客户
	 */
	@Override
	public void deleteCust(int cid) {
		
		custMapper.deleteCust(cid);
		
	}

}
