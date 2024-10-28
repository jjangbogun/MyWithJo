package com.withJo.lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.withJo.lotto.domain.LottoVo;


public interface LottoService {
	
	List<LottoVo> lottoSelectList(int start, int end, String searchField, String searchKeyword);
	public int lottoTotalCount(String searchField, String searchKeyword);	
	
	public default Set<Integer> lottoNum() {

		Random ran = new Random();
		Set<Integer> lottoNum = new HashSet<>();

		while(true) {

			int ranNum = ran.nextInt(45) + 1;
			lottoNum.add(ranNum);
			if(lottoNum.size() == 6) {
				break;
			}
		}
		
		return lottoNum;
	}
	public int lottoInsertOne(LottoVo lottoVo);
	public LottoVo lottoSelectOne();
//	public int boardUpdateOne(BoardVo boardVo);
//	public int boardDeleteOne(int no);
	
}
