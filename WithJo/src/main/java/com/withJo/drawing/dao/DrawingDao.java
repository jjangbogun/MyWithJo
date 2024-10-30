package com.withJo.drawing.dao;

import java.util.List;

import com.withJo.drawing.domain.DrawingVo;


public interface DrawingDao {
	List<DrawingVo> drawingSelectList(int start, int end, String searchField, String searchKeyword);
	public int drawingTotalCount(String searchField, String searchKeyword);
//	public abstract int drawingInsertOne(DrawingVo drawingVo);
//	public DrawingVo drawingSelectOne(int drawingNo);
//	public abstract int drawingUpdateOne(DrawingVo drawingVo);
//	public abstract int drawingDeleteOne(int drawingNo);
}
