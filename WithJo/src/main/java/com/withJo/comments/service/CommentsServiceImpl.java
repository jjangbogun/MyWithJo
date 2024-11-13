package com.withJo.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.comments.dao.CommentsDao;
import com.withJo.comments.domain.CommentsVo;


@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	public CommentsDao commentsDao;

	@Override
	public List<CommentsVo> commentsSelectList(int boardNo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsSelectList(boardNo);
	}
	
	@Override
	public int commentsInsertOne(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsInsertOne(commentsVo);
	}
	
	@Override
	public int commentsDeleteOne(int commentsNo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsDeleteOne(commentsNo);
	}
	
	@Override
	public int commentsUpdateOne(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return commentsDao.commentsUpdateOne(commentsVo);
	}

}
