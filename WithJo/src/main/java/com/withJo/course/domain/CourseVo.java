package com.withJo.course.domain;

import java.util.Date;

public class CourseVo {

	private int courseNo;
	private int categoryNo;
	private String courseName;
	private String courseTeacher;
	private int courseCost;
	private int courseCurrentPeople;
	private int courseMaxPeople;
	private int courseGenderCheck;
	private int courseAgeLimit;
	private Date courseStartDate;
	private Date courseEndDate;
	private String courseStartTime;
	private String courseEndTime;
	private Date courseRecStart;
	private Date courseRecEnd;
	private String courseInfo;
	private String CourseMainImage;
	private int courseDayOfTheWeek;
	
	public CourseVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseVo(int courseNo, int categoryNo, String courseName, String courseTeacher, int courseCost,
			int courseCurrentPeople, int courseMaxPeople, int courseGenderCheck, int courseAgeLimit,
			Date courseStartDate, Date courseEndDate, String courseStartTime, String courseEndTime, Date courseRecStart,
			Date courseRecEnd, String courseInfo, String courseMainImage, int courseDayOfTheWeek) {
		super();
		this.courseNo = courseNo;
		this.categoryNo = categoryNo;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.courseCost = courseCost;
		this.courseCurrentPeople = courseCurrentPeople;
		this.courseMaxPeople = courseMaxPeople;
		this.courseGenderCheck = courseGenderCheck;
		this.courseAgeLimit = courseAgeLimit;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseStartTime = courseStartTime;
		this.courseEndTime = courseEndTime;
		this.courseRecStart = courseRecStart;
		this.courseRecEnd = courseRecEnd;
		this.courseInfo = courseInfo;
		CourseMainImage = courseMainImage;
		this.courseDayOfTheWeek = courseDayOfTheWeek;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public int getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(int courseCost) {
		this.courseCost = courseCost;
	}

	public int getCourseCurrentPeople() {
		return courseCurrentPeople;
	}

	public void setCourseCurrentPeople(int courseCurrentPeople) {
		this.courseCurrentPeople = courseCurrentPeople;
	}

	public int getCourseMaxPeople() {
		return courseMaxPeople;
	}

	public void setCourseMaxPeople(int courseMaxPeople) {
		this.courseMaxPeople = courseMaxPeople;
	}

	public int getCourseGenderCheck() {
		return courseGenderCheck;
	}

	public void setCourseGenderCheck(int courseGenderCheck) {
		this.courseGenderCheck = courseGenderCheck;
	}

	public int getCourseAgeLimit() {
		return courseAgeLimit;
	}

	public void setCourseAgeLimit(int courseAgeLimit) {
		this.courseAgeLimit = courseAgeLimit;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public Date getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public String getCourseStartTime() {
		return courseStartTime;
	}

	public void setCourseStartTime(String courseStartTime) {
		this.courseStartTime = courseStartTime;
	}

	public String getCourseEndTime() {
		return courseEndTime;
	}

	public void setCourseEndTime(String courseEndTime) {
		this.courseEndTime = courseEndTime;
	}

	public Date getCourseRecStart() {
		return courseRecStart;
	}

	public void setCourseRecStart(Date courseRecStart) {
		this.courseRecStart = courseRecStart;
	}

	public Date getCourseRecEnd() {
		return courseRecEnd;
	}

	public void setCourseRecEnd(Date courseRecEnd) {
		this.courseRecEnd = courseRecEnd;
	}

	public String getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getCourseMainImage() {
		return CourseMainImage;
	}

	public void setCourseMainImage(String courseMainImage) {
		CourseMainImage = courseMainImage;
	}

	public int getCourseDayOfTheWeek() {
		return courseDayOfTheWeek;
	}

	public void setCourseDayOfTheWeek(int courseDayOfTheWeek) {
		this.courseDayOfTheWeek = courseDayOfTheWeek;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CourseVo [courseNo=");
		builder.append(courseNo);
		builder.append(", categoryNo=");
		builder.append(categoryNo);
		builder.append(", courseName=");
		builder.append(courseName);
		builder.append(", courseTeacher=");
		builder.append(courseTeacher);
		builder.append(", courseCost=");
		builder.append(courseCost);
		builder.append(", courseCurrentPeople=");
		builder.append(courseCurrentPeople);
		builder.append(", courseMaxPeople=");
		builder.append(courseMaxPeople);
		builder.append(", courseGenderCheck=");
		builder.append(courseGenderCheck);
		builder.append(", courseAgeLimit=");
		builder.append(courseAgeLimit);
		builder.append(", courseStartDate=");
		builder.append(courseStartDate);
		builder.append(", courseEndDate=");
		builder.append(courseEndDate);
		builder.append(", courseStartTime=");
		builder.append(courseStartTime);
		builder.append(", courseEndTime=");
		builder.append(courseEndTime);
		builder.append(", courseRecStart=");
		builder.append(courseRecStart);
		builder.append(", courseRecEnd=");
		builder.append(courseRecEnd);
		builder.append(", courseInfo=");
		builder.append(courseInfo);
		builder.append(", CourseMainImage=");
		builder.append(CourseMainImage);
		builder.append(", courseDayOfTheWeek=");
		builder.append(courseDayOfTheWeek);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}