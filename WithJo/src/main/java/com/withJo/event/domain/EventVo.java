package com.withJo.event.domain;

import java.util.Date;

public class EventVo {
	
	private int eventNo;        
	private int eventLotto;      
	private int eventDrawing;      
    private Date eventLottoUpdate;
    private Date eventDrawingUpdate;
    
	public EventVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventVo(int eventNo, int eventLotto, int eventDrawing, Date eventLottoUpdate, Date eventDrawingUpdate) {
		super();
		this.eventNo = eventNo;
		this.eventLotto = eventLotto;
		this.eventDrawing = eventDrawing;
		this.eventLottoUpdate = eventLottoUpdate;
		this.eventDrawingUpdate = eventDrawingUpdate;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public int getEventLotto() {
		return eventLotto;
	}

	public void setEventLotto(int eventLotto) {
		this.eventLotto = eventLotto;
	}

	public int getEventDrawing() {
		return eventDrawing;
	}

	public void setEventDrawing(int eventDrawing) {
		this.eventDrawing = eventDrawing;
	}

	public Date getEventLottoUpdate() {
		return eventLottoUpdate;
	}

	public void setEventLottoUpdate(Date eventLottoUpdate) {
		this.eventLottoUpdate = eventLottoUpdate;
	}

	public Date getEventDrawingUpdate() {
		return eventDrawingUpdate;
	}

	public void setEventDrawingUpdate(Date eventDrawingUpdate) {
		this.eventDrawingUpdate = eventDrawingUpdate;
	}

	@Override
	public String toString() {
		return "EventVo [eventNo=" + eventNo + ", eventLotto=" + eventLotto + ", eventDrawing=" + eventDrawing
				+ ", eventLottoUpdate=" + eventLottoUpdate + ", eventDrawingUpdate=" + eventDrawingUpdate + "]";
	}
    
    
    

}
