package com.withJo.board.domain;

import java.util.Date;

public class BoardVo {
	
	private int boardNo;        
	private int memberNo;      
    private String boardTitle;
    private String boardContent;
    private String boardImg;
    private Date boardCredate; 
    private Date boardUpdate; 
    private String memberName;
    
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int boardNo, int memberNo, String boardTitle, String boardContent, String boardImg,
			Date boardCredate, Date boardUpdate, String memberName) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardImg = boardImg;
		this.boardCredate = boardCredate;
		this.boardUpdate = boardUpdate;
		this.memberName = memberName;
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

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardImg() {
		return boardImg;
	}

	public void setBoardImg(String boardImg) {
		this.boardImg = boardImg;
	}

	public Date getBoardCredate() {
		return boardCredate;
	}

	public void setBoardCredate(Date boardCredate) {
		this.boardCredate = boardCredate;
	}

	public Date getBoardUpdate() {
		return boardUpdate;
	}

	public void setBoardUpdate(Date boardUpdate) {
		this.boardUpdate = boardUpdate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardImg=" + boardImg + ", boardCredate=" + boardCredate
				+ ", boardUpdate=" + boardUpdate + ", memberName=" + memberName + "]";
	}   

    
}
