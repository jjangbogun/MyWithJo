package com.withJo.lotto.dao;

import java.util.List;

import com.withJo.board.domain.BoardVo;
import com.withJo.lotto.domain.LottoVo;
import com.withJo.notice.domain.NoticeVo;


public interface LottoDao {
	List<LottoVo> lottoSelectList(int start, int end, String searchField, String searchKeyword);
	public int lottoTotalCount(String searchField, String searchKeyword);
	public abstract int lottoInsertOne(LottoVo lottoVo);
	public abstract int lottoInsertOne2(LottoVo lottoVo);
	public LottoVo lottoSelectOne();
	public int lottoCountCheck(LottoVo lottoVo);
//	public abstract int boardUpdateOne(BoardVo boardVo);
	public abstract int lottoDeleteOne(int lottoNo);
}
