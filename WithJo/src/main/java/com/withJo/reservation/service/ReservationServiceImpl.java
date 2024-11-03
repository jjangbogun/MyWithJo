package com.withJo.reservation.service;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withJo.course.dao.CourseDao;
import com.withJo.course.domain.CourseVo;
import com.withJo.member.dao.MemberDao;
import com.withJo.member.domain.MemberVo;
import com.withJo.reservation.dao.ReservationDao;
import com.withJo.reservation.domain.ReservationVo;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	public ReservationDao reservationDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void getCourseReservation(Map<String, Object> map) {
		// TODO Auto-generated method stub
		reservationDao.getCourseReservation(map);
	}
	
}
