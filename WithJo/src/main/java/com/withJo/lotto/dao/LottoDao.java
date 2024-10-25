package com.withJo.lotto.dao;

import java.util.List;

import com.withJo.board.domain.BoardVo;
import com.withJo.notice.domain.NoticeVo;


public interface LottoDao {
	List<BoardVo> boardSelectList(int start, int end, String searchField, String searchKeyword);
	public int boardTotalCount(String searchField, String searchKeyword);
	public abstract int boardInsertOne(BoardVo boardVo);
	public BoardVo boardSelectOne(int no);
	public abstract int boardUpdateOne(BoardVo boardVo);
	public abstract int boardDeleteOne(int no);
}
