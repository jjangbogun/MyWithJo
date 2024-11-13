package com.withJo.comments.dao;

import java.util.List;

import com.withJo.comments.domain.CommentsVo;


public interface CommentsDao {
	List<CommentsVo> commentsSelectList(int boardNo);
	public abstract int commentsInsertOne(CommentsVo commentsVo);
	public abstract int commentsDeleteOne(int commentsNo);
	public abstract int commentsUpdateOne(CommentsVo commentsVo);
}
