package com.withJo.notice.domain;

import java.util.Date;

public class NoticeVo {
	
	private int noticeNo;        
	private int memberNo;      
    private String noticeTitle;
    private String noticeContent;
    private String noticeImg;
    private Date noticeCredate; 
    private Date noticeUpdate; 
    private String memberName;
    
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeVo(int noticeNo, int memberNo, String noticeTitle, String noticeContent, String noticeImg,
			Date noticeCredate, Date noticeUpdate, String memberName) {
		super();
		this.noticeNo = noticeNo;
		this.memberNo = memberNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeImg = noticeImg;
		this.noticeCredate = noticeCredate;
		this.noticeUpdate = noticeUpdate;
		this.memberName = memberName;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeImg() {
		return noticeImg;
	}

	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}

	public Date getNoticeCredate() {
		return noticeCredate;
	}

	public void setNoticeCredate(Date noticeCredate) {
		this.noticeCredate = noticeCredate;
	}

	public Date getNoticeUpdate() {
		return noticeUpdate;
	}

	public void setNoticeUpdate(Date noticeUpdate) {
		this.noticeUpdate = noticeUpdate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", memberNo=" + memberNo + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeImg=" + noticeImg + ", noticeCredate=" + noticeCredate
				+ ", noticeUpdate=" + noticeUpdate + ", memberName=" + memberName + "]";
	}
	

}
