package com.withJo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.board.dao.BoardDao;
import com.withJo.board.domain.BoardVo;


@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	public BoardDao boardDao;

	@Override
	public List<BoardVo> boardSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectList(start, end, searchField, searchKeyword);
	}

	@Override
	public int boardTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return boardDao.boardTotalCount(searchField, searchKeyword);
	}
	
	@Override
	public int boardInsertOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.boardInsertOne(boardVo);
	}
	
	@Override
	public BoardVo boardSelectOne(int no) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectOne(no);
	}
	
	@Override
	public int boardUpdateOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.boardUpdateOne(boardVo);
	}
	
	@Override
	public int boardDeleteOne(int no) {
		// TODO Auto-generated method stub
		return boardDao.boardDeleteOne(no);
	}
	

}
