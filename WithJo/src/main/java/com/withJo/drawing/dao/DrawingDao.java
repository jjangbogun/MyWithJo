package com.withJo.drawing.dao;

import java.util.List;
import java.util.Map;

import com.withJo.drawing.domain.DrawingVo;


public interface DrawingDao {
	List<DrawingVo> drawingSelectList(int start, int end, String searchField, String searchKeyword);
	public int drawingTotalCount(String searchField, String searchKeyword);
	public abstract int drawingInsertOne(DrawingVo drawingVo);
	public DrawingVo drawingSelectOne();
	List<Map<String, Object>> drawingSelect(String startDate, String endDate, int no);
	public abstract int drawingDeleteOne(int drawingNo);
	public abstract int drawingInsertEMoney(int emoney, int memberNo, String detail);
}
