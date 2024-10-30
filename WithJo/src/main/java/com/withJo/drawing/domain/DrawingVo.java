package com.withJo.drawing.domain;

import java.util.Date;

public class DrawingVo {
	
	private int drawingNo;           
	private int drawingRound;      
	private int memberNo;      
    private String memberName;
    private String drawingMemberNo;
    private String drawingStartDate;
    private String drawingEndDate;
    private Date drawingCredate;
    
	public DrawingVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrawingVo(int drawingNo, int drawingRound, int memberNo, String memberName, String drawingMemberNo,
			String drawingStartDate, String drawingEndDate, Date drawingCredate) {
		super();
		this.drawingNo = drawingNo;
		this.drawingRound = drawingRound;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.drawingMemberNo = drawingMemberNo;
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
				+ ", memberName=" + memberName + ", drawingMemberNo=" + drawingMemberNo + ", drawingStartDate="
				+ drawingStartDate + ", drawingEndDate=" + drawingEndDate + ", drawingCredate=" + drawingCredate + "]";
	} 


}
