package com.withJo.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withJo.course.service.CourseService;
import com.withJo.reservation.service.ReservationService;

@RequestMapping("/reservation")
@RestController
public class ReservationController {
	
	private Logger log = LoggerFactory.getLogger(ReservationController.class);
	private final String logTitleMsg = "CourseContoller";
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> getcourseReservation(@RequestBody HashMap<String, Object> map){
		
		
		reservationService.getCourseReservation(map);
		
		return ResponseEntity.ok("수강신청성공");
	}

}
