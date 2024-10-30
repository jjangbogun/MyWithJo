package com.withJo.drawing.service;

import java.util.List;

import com.withJo.drawing.domain.DrawingVo;


public interface DrawingService {
	
	List<DrawingVo> drawingSelectList(int start, int end, String searchField, String searchKeyword);
	public int drawingTotalCount(String searchField, String searchKeyword);
//	public int drawingInsertOne(DrawingVo drawingVo);
//	public DrawingVo drawingSelectOne(int drawingNo);
//	public int drawingUpdateOne(DrawingVo drawingVo);
//	public int drawingDeleteOne(int drawingNo);
}
