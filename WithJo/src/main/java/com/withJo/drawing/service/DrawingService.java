package com.withJo.drawing.service;

import java.util.List;
import java.util.Map;

import com.withJo.drawing.domain.DrawingVo;


public interface DrawingService {
	
	List<DrawingVo> drawingSelectList(int start, int end, String searchField, String searchKeyword);
	public int drawingTotalCount(String searchField, String searchKeyword);
	public int drawingInsertOne(DrawingVo drawingVo);
	public DrawingVo drawingSelectOne();
	public List<Map<String, Object>> drawingSelect(String startDate, String endDate, int no);
	public int drawingDeleteOne(int drawingNo);
}
