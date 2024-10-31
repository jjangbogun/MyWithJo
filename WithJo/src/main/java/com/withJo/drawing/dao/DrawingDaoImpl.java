package com.withJo.drawing.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.board.domain.BoardVo;
import com.withJo.customer.domain.CustomerVo;
import com.withJo.drawing.domain.DrawingVo;
import com.withJo.notice.domain.NoticeVo;


@Repository
public class DrawingDaoImpl implements DrawingDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.drawing.";

	@Override
	public List<DrawingVo> drawingSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectList(namespace + "drawingSelectList", map);
	}

	@Override
	public int drawingTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectOne(namespace + "drawingTotalCount", map);
	}
//	
//	@Override
//	public int customerInsertOne(CustomerVo customerVo) {
//		// TODO Auto-generated method stub
//		return sqlSession.insert(namespace + "customerInsertOne", customerVo);
//	}
//	
	@Override
	public DrawingVo drawingSelectOne() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "drawingSelectOne");
	}
	
	@Override
	public List<Map<String, Object>> drawingSelect(String date, int no) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("date", date);
		map.put("no", no);
		return sqlSession.selectList(namespace + "drawingSelect", map);
	}
//	
//	@Override
//	public int customerDeleteOne(int customerNo) {
//		// TODO Auto-generated method stub
//		return sqlSession.delete(namespace + "customerDeleteOne", customerNo);
//	}
}
