package com.withJo.drawing.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.board.domain.BoardVo;
import com.withJo.customer.domain.CustomerVo;
import com.withJo.notice.domain.NoticeVo;


@Repository
public class DrawingDaoImpl implements DrawingDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.customer.";

	@Override
	public List<CustomerVo> customerSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectList(namespace + "customerSelectList", map);
	}

	@Override
	public int customerTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectOne(namespace + "customerTotalCount", map);
	}
	
	@Override
	public int customerInsertOne(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "customerInsertOne", customerVo);
	}
	
	@Override
	public CustomerVo customerSelectOne(int customerNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "customerSelectOne", customerNo);
	}
	
	@Override
	public int customerUpdateOne(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "customerUpdateOne", customerVo);
	}
	
	@Override
	public int customerDeleteOne(int customerNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "customerDeleteOne", customerNo);
	}
}
