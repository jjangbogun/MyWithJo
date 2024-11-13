package com.withJo.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.notice.domain.NoticeVo;


@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.notice.";

	@Override
	public List<NoticeVo> noticeSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectList(namespace + "noticeSelectList", map);
	}

	@Override
	public int noticeTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectOne(namespace + "noticeTotalCount", map);
	}
	
	@Override
	public int noticeInsertOne(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "noticeInsertOne", noticeVo);
	}
	
	@Override
	public NoticeVo noticeSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "noticeSelectOne", no);
	}
	
	@Override
	public int noticeUpdateOne(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "noticeUpdateOne", noticeVo);
	}
	
	@Override
	public int noticeDeleteOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "noticeDeleteOne", no);
	}
}
