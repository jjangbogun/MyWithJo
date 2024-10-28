package com.withJo.comments.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.board.domain.BoardVo;
import com.withJo.comments.domain.CommentsVo;



@Repository
public class CommentsDaoImpl implements CommentsDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.comments.";

	@Override
	public List<CommentsVo> commentsSelectList(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "commentsSelectList", boardNo);
	}

	@Override
	public int commentsInsertOne(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "commentsInsertOne", commentsVo);
	}
	
	@Override
	public int commentsDeleteOne(int commentsNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "commentsDeleteOne", commentsNo);
	}
	
}
