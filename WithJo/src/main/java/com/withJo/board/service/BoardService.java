package com.withJo.board.service;

import java.util.List;

import com.withJo.board.domain.BoardVo;
import com.withJo.notice.domain.NoticeVo;


public interface BoardService {
	
	List<BoardVo> boardSelectList(int start, int end, String searchField, String searchKeyword);
	public int boardTotalCount(String searchField, String searchKeyword);
	public int boardInsertOne(BoardVo boardVo);
	public BoardVo boardSelectOne(int no);
	public int boardUpdateOne(BoardVo boardVo);
	public int boardDeleteOne(int no);
	
}
