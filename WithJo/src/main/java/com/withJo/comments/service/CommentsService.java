package com.withJo.comments.service;

import java.util.List;

import com.withJo.board.domain.BoardVo;
import com.withJo.comments.domain.CommentsVo;
import com.withJo.notice.domain.NoticeVo;


public interface CommentsService {
	
	List<CommentsVo> commentsSelectList(int boardNo);
	public int commentsInsertOne(CommentsVo commentsVo);
	public int commentsDeleteOne(int commentsNo);
}
