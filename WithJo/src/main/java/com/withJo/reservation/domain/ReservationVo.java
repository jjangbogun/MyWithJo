package com.withJo.reservation.domain;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ReservationVo {
	
	@Id
	private int memberCourseReserveNo;
	private int courseNo;
	private int memberNo;
	private int categoryNo;
}
