package com.withJo.drawing.domain;

import java.util.Date;

public class DrawingVo {
	
	private int drawingNo;           
	private int drawingRound;      
	private int memberNo;      
	private int drawingPersonnel;      
	private int drawingPoint;      
    private String memberName;
    private String drawingMemberNo;
    private String drawingMemberId;
    private String drawingMemberName;
    private String drawingStartDate;
    private String drawingEndDate;
    private Date drawingCredate;
    
	public DrawingVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrawingVo(int drawingNo, int drawingRound, int memberNo, int drawingPersonnel, int drawingPoint,
			String memberName, String drawingMemberNo, String drawingMemberId, String drawingMemberName,
			String drawingStartDate, String drawingEndDate, Date drawingCredate) {
		super();
		this.drawingNo = drawingNo;
		this.drawingRound = drawingRound;
		this.memberNo = memberNo;
		this.drawingPersonnel = drawingPersonnel;
		this.drawingPoint = drawingPoint;
		this.memberName = memberName;
		this.drawingMemberNo = drawingMemberNo;
		this.drawingMemberId = drawingMemberId;
		this.drawingMemberName = drawingMemberName;
		this.drawingStartDate = drawingStartDate;
		this.drawingEndDate = drawingEndDate;
		this.drawingCredate = drawingCredate;
	}

	public int getDrawingNo() {
		return drawingNo;
	}

	public void setDrawingNo(int drawingNo) {
		this.drawingNo = drawingNo;
	}

	public int getDrawingRound() {
		return drawingRound;
	}

	public void setDrawingRound(int drawingRound) {
		this.drawingRound = drawingRound;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getDrawingPersonnel() {
		return drawingPersonnel;
	}

	public void setDrawingPersonnel(int drawingPersonnel) {
		this.drawingPersonnel = drawingPersonnel;
	}

	public int getDrawingPoint() {
		return drawingPoint;
	}

	public void setDrawingPoint(int drawingPoint) {
		this.drawingPoint = drawingPoint;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDrawingMemberNo() {
		return drawingMemberNo;
	}

	public void setDrawingMemberNo(String drawingMemberNo) {
		this.drawingMemberNo = drawingMemberNo;
	}

	public String getDrawingMemberId() {
		return drawingMemberId;
	}

	public void setDrawingMemberId(String drawingMemberId) {
		this.drawingMemberId = drawingMemberId;
	}

	public String getDrawingMemberName() {
		return drawingMemberName;
	}

	public void setDrawingMemberName(String drawingMemberName) {
		this.drawingMemberName = drawingMemberName;
	}

	public String getDrawingStartDate() {
		return drawingStartDate;
	}

	public void setDrawingStartDate(String drawingStartDate) {
		this.drawingStartDate = drawingStartDate;
	}

	public String getDrawingEndDate() {
		return drawingEndDate;
	}

	public void setDrawingEndDate(String drawingEndDate) {
		this.drawingEndDate = drawingEndDate;
	}

	public Date getDrawingCredate() {
		return drawingCredate;
	}

	public void setDrawingCredate(Date drawingCredate) {
		this.drawingCredate = drawingCredate;
	}

	@Override
	public String toString() {
		return "DrawingVo [drawingNo=" + drawingNo + ", drawingRound=" + drawingRound + ", memberNo=" + memberNo
				+ ", drawingPersonnel=" + drawingPersonnel + ", drawingPoint=" + drawingPoint + ", memberName="
				+ memberName + ", drawingMemberNo=" + drawingMemberNo + ", drawingMemberId=" + drawingMemberId
				+ ", drawingMemberName=" + drawingMemberName + ", drawingStartDate=" + drawingStartDate
				+ ", drawingEndDate=" + drawingEndDate + ", drawingCredate=" + drawingCredate + "]";
	}
    
    

}
