package com.withJo.lotto.dao;

import java.util.List;

import com.withJo.lotto.domain.LottoVo;


public interface LottoDao {
	List<LottoVo> lottoSelectList(int start, int end, String searchField, String searchKeyword);
	public int lottoTotalCount(String searchField, String searchKeyword);
	public abstract int lottoInsertOne(LottoVo lottoVo);
	public abstract int lottoInsertOne2(LottoVo lottoVo);
	public LottoVo lottoSelectOne();
	public int lottoCountCheck(LottoVo lottoVo);
	public abstract int lottoInsertEMoney(int emoney, int memberNo, String detail);
	public abstract int lottoDeleteOne(int lottoNo);
}
