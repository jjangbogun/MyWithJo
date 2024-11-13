package com.withJo.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.board.domain.BoardVo;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.board.";

	@Override
	public List<BoardVo> boardSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectList(namespace + "boardSelectList", map);
	}

	@Override
	public int boardTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectOne(namespace + "boardTotalCount", map);
	}
	
	@Override
	public int boardInsertOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "boardInsertOne", boardVo);
	}
	
	@Override
	public BoardVo boardSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "boardSelectOne", no);
	}
	
	@Override
	public int boardUpdateOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "boardUpdateOne", boardVo);
	}
	
	@Override
	public int boardDeleteOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "boardDeleteOne", no);
	}
	
}
