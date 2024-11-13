package com.withJo.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.customer.dao.CustomerDao;
import com.withJo.customer.domain.CustomerVo;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerDao customerDao;

	@Override
	public List<CustomerVo> customerSelectList(int start, int end, String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return customerDao.customerSelectList(start, end, searchField, searchKeyword);
	}

	@Override
	public int customerTotalCount(String searchField, String searchKeyword) {
		// TODO Auto-generated method stub
		return customerDao.customerTotalCount(searchField, searchKeyword);
	}
	
	@Override
	public int customerInsertOne(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		return customerDao.customerInsertOne(customerVo);
	}
	
	@Override
	public CustomerVo customerSelectOne(int customerNo) {
		// TODO Auto-generated method stub
		return customerDao.customerSelectOne(customerNo);
	}
	
	@Override
	public int customerUpdateOne(CustomerVo customerVo) {
		// TODO Auto-generated method stub
		return customerDao.customerUpdateOne(customerVo);
	}
	
	@Override
	public int customerDeleteOne(int customerNo) {
		// TODO Auto-generated method stub
		return customerDao.customerDeleteOne(customerNo);
	}
}
