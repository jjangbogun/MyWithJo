package com.withJo.lotto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.board.dao.BoardDao;
import com.withJo.board.domain.BoardVo;
import com.withJo.lotto.dao.LottoDao;
import com.withJo.lotto.domain.LottoVo;
import com.withJo.notice.dao.NoticeDao;
import com.withJo.notice.domain.NoticeVo;


@Service
public class LottoServiceImpl implements LottoService{

	@Autowired
	public LottoDao lottoDao;

	@Override
	public List<LottoVo> lottoSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return lottoDao.lottoSelectList(start, end, searchField, searchKeyword);
	}

	@Override
	public int lottoTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return lottoDao.lottoTotalCount(searchField, searchKeyword);
	}
	
	@Override
	public int lottoInsertOne(LottoVo lottoVo) {
		// TODO Auto-generated method stub
		return lottoDao.lottoInsertOne(lottoVo);
	}
	
	@Override
	public LottoVo lottoSelectOne() {
		// TODO Auto-generated method stub
		return lottoDao.lottoSelectOne();
	}
	
	@Override
	public int lottoInsertOne2(LottoVo lottoVo) {
		// TODO Auto-generated method stub
		return lottoDao.lottoInsertOne2(lottoVo);
	}
	
	@Override
	public int lottoCountCheck(LottoVo lottoVo) {
		// TODO Auto-generated method stub
		return lottoDao.lottoCountCheck(lottoVo);
	}
//	
//	@Override
//	public int boardUpdateOne(BoardVo boardVo) {
//		// TODO Auto-generated method stub
//		return boardDao.boardUpdateOne(boardVo);
//	}
//	
//	@Override
//	public int boardDeleteOne(int no) {
//		// TODO Auto-generated method stub
//		return boardDao.boardDeleteOne(no);
//	}
	

}
