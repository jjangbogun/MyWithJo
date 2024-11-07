package com.withJo.lotto.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.board.domain.BoardVo;
import com.withJo.lotto.domain.LottoVo;
import com.withJo.notice.domain.NoticeVo;


@Repository
public class LottoDaoImpl implements LottoDao{

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.withJo.lotto.";

	@Override
	public List<LottoVo> lottoSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectList(namespace + "lottoSelectList", map);
	}

	@Override
	public int lottoTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchField", searchField);
		map.put("searchKeyword", searchKeyword);
		return sqlSession.selectOne(namespace + "lottoTotalCount", map);
	}
	
	@Override
	public int lottoInsertOne(LottoVo lottoVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "lottoInsertOne", lottoVo);
	}
	
	@Override
	public int lottoInsertOne2(LottoVo lottoVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "lottoInsertOne2", lottoVo);
	}
	
	@Override
	public LottoVo lottoSelectOne() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "lottoSelectOne");
	}
	
	@Override
	public int lottoCountCheck(LottoVo lottoVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "lottoCountCheck", lottoVo);
	}
	
	@Override
	public int lottoInsertEMoney(int emoney, int memberNo, String detail) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("eMoney", emoney);
		map.put("memberNo", memberNo);
		map.put("detail", detail);
		
		return sqlSession.delete(namespace + "lottoInsertEMoney", map);
	}
	
	@Override
	public int lottoDeleteOne(int lottoNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "lottoDeleteOne", lottoNo);
	}
	
}
