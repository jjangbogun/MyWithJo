package com.withJo.reservation.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.withJo.reservation.domain.ReservationVo;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SqlSession sqlSession;
	
	String namespace = "com.edu.reservation.";

	@Override
	public void getCourseReservation(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 sqlSession.insert(namespace + "getCourseReservation", map);
	}
}
