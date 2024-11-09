package com.withJo.reservation.service;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.course.dao.CourseDao;
import com.withJo.member.dao.MemberDao;
import com.withJo.reservation.dao.ReservationDao;

import jakarta.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	public ReservationDao reservationDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private MemberDao memberDao;

	@Transactional
	@Override
	public void getCourseReservation(Map<String, Object> map) {
		// TODO Auto-generated method stub
		reservationDao.getCourseReservation(map);
	}
	
}
