package com.withJo.reservation.dao;

import java.util.Map;

import com.withJo.reservation.domain.ReservationVo;

public interface ReservationDao {

	public void getCourseReservation(Map<String, Object> map);
}
