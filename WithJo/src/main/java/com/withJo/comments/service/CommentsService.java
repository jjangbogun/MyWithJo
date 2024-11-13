package com.withJo.comments.service;

import java.util.List;

import com.withJo.comments.domain.CommentsVo;


public interface CommentsService {
	
	List<CommentsVo> commentsSelectList(int boardNo);
	public int commentsInsertOne(CommentsVo commentsVo);
	public int commentsDeleteOne(int commentsNo);
	public int commentsUpdateOne(CommentsVo commentsVo);
}
