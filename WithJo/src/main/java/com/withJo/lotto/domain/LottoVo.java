package com.withJo.lotto.domain;

import java.util.Date;

public class LottoVo {
	
	private int winningLottoNo;        
	private int winningLottoRound;      
    private String winningLottoSelNo;
    private String winningLottoStartDate;
    private String winningLottoEndDate;
    private Date winningLottoCredate;
    
	public LottoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LottoVo(int winningLottoNo, int winningLottoRound, String winningLottoSelNo, String winningLottoStartDate,
			String winningLottoEndDate, Date winningLottoCredate) {
		super();
		this.winningLottoNo = winningLottoNo;
		this.winningLottoRound = winningLottoRound;
		this.winningLottoSelNo = winningLottoSelNo;
		this.winningLottoStartDate = winningLottoStartDate;
		this.winningLottoEndDate = winningLottoEndDate;
		this.winningLottoCredate = winningLottoCredate;
	}

	public int getWinningLottoNo() {
		return winningLottoNo;
	}

	public void setWinningLottoNo(int winningLottoNo) {
		this.winningLottoNo = winningLottoNo;
	}

	public int getWinningLottoRound() {
		return winningLottoRound;
	}

	public void setWinningLottoRound(int winningLottoRound) {
		this.winningLottoRound = winningLottoRound;
	}

	public String getWinningLottoSelNo() {
		return winningLottoSelNo;
	}

	public void setWinningLottoSelNo(String winningLottoSelNo) {
		this.winningLottoSelNo = winningLottoSelNo;
	}

	public String getWinningLottoStartDate() {
		return winningLottoStartDate;
	}

	public void setWinningLottoStartDate(String winningLottoStartDate) {
		this.winningLottoStartDate = winningLottoStartDate;
	}

	public String getWinningLottoEndDate() {
		return winningLottoEndDate;
	}

	public void setWinningLottoEndDate(String winningLottoEndDate) {
		this.winningLottoEndDate = winningLottoEndDate;
	}

	public Date getWinningLottoCredate() {
		return winningLottoCredate;
	}

	public void setWinningLottoCredate(Date winningLottoCredate) {
		this.winningLottoCredate = winningLottoCredate;
	}

	@Override
	public String toString() {
		return "LottoVo [winningLottoNo=" + winningLottoNo + ", winningLottoRound=" + winningLottoRound
				+ ", winningLottoSelNo=" + winningLottoSelNo + ", winningLottoStartDate=" + winningLottoStartDate
				+ ", winningLottoEndDate=" + winningLottoEndDate + ", winningLottoCredate=" + winningLottoCredate + "]";
	} 
    
    

    
}
