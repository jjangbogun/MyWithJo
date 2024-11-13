package com.withJo.drawing.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.drawing.dao.DrawingDao;
import com.withJo.drawing.domain.DrawingVo;


@Service
public class DrawingServiceImpl implements DrawingService{

	@Autowired
	public DrawingDao drawingDao;

	@Override
	public List<DrawingVo> drawingSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return drawingDao.drawingSelectList(start, end, searchField, searchKeyword);
	}

	@Override
	public int drawingTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return drawingDao.drawingTotalCount(searchField, searchKeyword);
	}
	
	@Override
	public int drawingInsertOne(DrawingVo drawingVo) {
		// TODO Auto-generated method stub
		return drawingDao.drawingInsertOne(drawingVo);
	}
	
	@Override
	public DrawingVo drawingSelectOne(int drawingNo) {
		// TODO Auto-generated method stub
		return drawingDao.drawingSelectOne(drawingNo);
	}
	
	@Override
	public List<Map<String, Object>> drawingSelect(String startDate, String endDate, int no) {
		// TODO Auto-generated method stub
		return drawingDao.drawingSelect(startDate, endDate, no);
	}
	
	@Override
	public int drawingDeleteOne(int drawingNo) {
		// TODO Auto-generated method stub
		return drawingDao.drawingDeleteOne(drawingNo);
	}
	
	@Override
	public int drawingInsertEMoney(int emoney, int memberNo, String detail) {
		// TODO Auto-generated method stub
		return drawingDao.drawingInsertEMoney(emoney, memberNo, detail);
	}
}
