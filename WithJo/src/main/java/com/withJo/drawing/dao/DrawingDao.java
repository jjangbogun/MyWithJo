package com.withJo.drawing.dao;

import java.util.List;

import com.withJo.customer.domain.CustomerVo;


public interface DrawingDao {
	List<CustomerVo> customerSelectList(int start, int end, String searchField, String searchKeyword);
	public int customerTotalCount(String searchField, String searchKeyword);
	public abstract int customerInsertOne(CustomerVo customerVo);
	public CustomerVo customerSelectOne(int customerNo);
	public abstract int customerUpdateOne(CustomerVo customerVo);
	public abstract int customerDeleteOne(int customerNo);
}
