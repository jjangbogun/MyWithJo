package com.withJo.comments.domain;

import java.util.Date;

public class CommentsVo {
	
	private int commentsNo;        
	private int boardNo;      
	private int memberNo;      
	private String memberName;
    private String commentsContent;
    private Date commentsCredate; 
    private Date commentsUpdate;
    private String formattedCDate;
    private String formattedUDate;
    
	public CommentsVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentsVo(int commentsNo, int boardNo, int memberNo, String memberName, String commentsContent,
			Date commentsCredate, Date commentsUpdate, String formattedCDate, String formattedUDate) {
		super();
		this.commentsNo = commentsNo;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.commentsContent = commentsContent;
		this.commentsCredate = commentsCredate;
		this.commentsUpdate = commentsUpdate;
		this.formattedCDate = formattedCDate;
		this.formattedUDate = formattedUDate;
	}

	public int getCommentsNo() {
		return commentsNo;
	}

	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public String getCommentsContent() {
		return commentsContent;
	}

	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}

	public Date getCommentsCredate() {
		return commentsCredate;
	}

	public void setCommentsCredate(Date commentsCredate) {
		this.commentsCredate = commentsCredate;
	}

	public Date getCommentsUpdate() {
		return commentsUpdate;
	}

	public void setCommentsUpdate(Date commentsUpdate) {
		this.commentsUpdate = commentsUpdate;
	}

	public String getFormattedCDate() {
		return formattedCDate;
	}

	public void setFormattedCDate(String formattedCDate) {
		this.formattedCDate = formattedCDate;
	}

	public String getFormattedUDate() {
		return formattedUDate;
	}

	public void setFormattedUDate(String formattedUDate) {
		this.formattedUDate = formattedUDate;
	}

	@Override
	public String toString() {
		return "CommentsVo [commentsNo=" + commentsNo + ", boardNo=" + boardNo + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", commentsContent=" + commentsContent + ", commentsCredate="
				+ commentsCredate + ", commentsUpdate=" + commentsUpdate + ", formattedCDate=" + formattedCDate
				+ ", formattedUDate=" + formattedUDate + "]";
	}
    
    
    
    

}
