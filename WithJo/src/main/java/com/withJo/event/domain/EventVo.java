package com.withJo.event.domain;

import java.util.Date;

public class EventVo {
	
	private int eventNo;        
	private int eventCategoryNo;      
	private int eventHideShow;      
    private Date eventCreadate;
    private Date eventUpdate;
    
	public EventVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventVo(int eventNo, int eventCategoryNo, int eventHideShow, Date eventCreadate, Date eventUpdate) {
		super();
		this.eventNo = eventNo;
		this.eventCategoryNo = eventCategoryNo;
		this.eventHideShow = eventHideShow;
		this.eventCreadate = eventCreadate;
		this.eventUpdate = eventUpdate;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public int getEventCategoryNo() {
		return eventCategoryNo;
	}

	public void setEventCategoryNo(int eventCategoryNo) {
		this.eventCategoryNo = eventCategoryNo;
	}

	public int getEventHideShow() {
		return eventHideShow;
	}

	public void setEventHideShow(int eventHideShow) {
		this.eventHideShow = eventHideShow;
	}

	public Date getEventCreadate() {
		return eventCreadate;
	}

	public void setEventCreadate(Date eventCreadate) {
		this.eventCreadate = eventCreadate;
	}

	public Date getEventUpdate() {
		return eventUpdate;
	}

	public void setEventUpdate(Date eventUpdate) {
		this.eventUpdate = eventUpdate;
	}

	@Override
	public String toString() {
		return "EventVo [eventNo=" + eventNo + ", eventCategoryNo=" + eventCategoryNo + ", eventHideShow="
				+ eventHideShow + ", eventCreadate=" + eventCreadate + ", eventUpdate=" + eventUpdate + "]";
	}
    
    
    
    

}
