package com.withJo.member.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;


@Data
public class MemberVo {
	
	@Id
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberBirthDate;
	private int memberGender;
	private String memberPhoneNum;
	private String memberZipCode;
	private String memberAddress;
	private String memberAddressInfo;	
	private Date memberCredate;
	private Date memberUpdate;
	private int memberEMoney;
	private int authority;	
	private int memberCourseReserveNo;	
	private String courseName;
	private String courseTeacher;	
	private Date courseStartDate;
	private Date courseEndDate;
	private String courseStartTime;
	private String courseEndTime;	
	private String courseMainImage;
	private int courseDayOfTheWeek;	

}
