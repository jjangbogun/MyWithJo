package com.withJo.lotto.domain;

import java.util.Date;

public class LottoVo {
	
	private int lottoNo;        
	private int lottoRound;      
	private int lottoMode;      
	private int memberNo;      
	private int lottoWinning;      
	private int lotto1st;      
	private int lotto2nd;      
	private int lotto3rd;      
    private String lottoSelNo;
    private String lottoStartDate;
    private String lottoEndDate;
    private Date lottoCredate;
    private String memberName;
    
	public LottoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LottoVo(int lottoNo, int lottoRound, int lottoMode, int memberNo, int lottoWinning, int lotto1st,
			int lotto2nd, int lotto3rd, String lottoSelNo, String lottoStartDate, String lottoEndDate,
			Date lottoCredate, String memberName) {
		super();
		this.lottoNo = lottoNo;
		this.lottoRound = lottoRound;
		this.lottoMode = lottoMode;
		this.memberNo = memberNo;
		this.lottoWinning = lottoWinning;
		this.lotto1st = lotto1st;
		this.lotto2nd = lotto2nd;
		this.lotto3rd = lotto3rd;
		this.lottoSelNo = lottoSelNo;
		this.lottoStartDate = lottoStartDate;
		this.lottoEndDate = lottoEndDate;
		this.lottoCredate = lottoCredate;
		this.memberName = memberName;
	}

	public int getLottoNo() {
		return lottoNo;
	}

	public void setLottoNo(int lottoNo) {
		this.lottoNo = lottoNo;
	}

	public int getLottoRound() {
		return lottoRound;
	}

	public void setLottoRound(int lottoRound) {
		this.lottoRound = lottoRound;
	}

	public int getLottoMode() {
		return lottoMode;
	}

	public void setLottoMode(int lottoMode) {
		this.lottoMode = lottoMode;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getLottoWinning() {
		return lottoWinning;
	}

	public void setLottoWinning(int lottoWinning) {
		this.lottoWinning = lottoWinning;
	}

	public int getLotto1st() {
		return lotto1st;
	}

	public void setLotto1st(int lotto1st) {
		this.lotto1st = lotto1st;
	}

	public int getLotto2nd() {
		return lotto2nd;
	}

	public void setLotto2nd(int lotto2nd) {
		this.lotto2nd = lotto2nd;
	}

	public int getLotto3rd() {
		return lotto3rd;
	}

	public void setLotto3rd(int lotto3rd) {
		this.lotto3rd = lotto3rd;
	}

	public String getLottoSelNo() {
		return lottoSelNo;
	}

	public void setLottoSelNo(String lottoSelNo) {
		this.lottoSelNo = lottoSelNo;
	}

	public String getLottoStartDate() {
		return lottoStartDate;
	}

	public void setLottoStartDate(String lottoStartDate) {
		this.lottoStartDate = lottoStartDate;
	}

	public String getLottoEndDate() {
		return lottoEndDate;
	}

	public void setLottoEndDate(String lottoEndDate) {
		this.lottoEndDate = lottoEndDate;
	}

	public Date getLottoCredate() {
		return lottoCredate;
	}

	public void setLottoCredate(Date lottoCredate) {
		this.lottoCredate = lottoCredate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "LottoVo [lottoNo=" + lottoNo + ", lottoRound=" + lottoRound + ", lottoMode=" + lottoMode + ", memberNo="
				+ memberNo + ", lottoWinning=" + lottoWinning + ", lotto1st=" + lotto1st + ", lotto2nd=" + lotto2nd
				+ ", lotto3rd=" + lotto3rd + ", lottoSelNo=" + lottoSelNo + ", lottoStartDate=" + lottoStartDate
				+ ", lottoEndDate=" + lottoEndDate + ", lottoCredate=" + lottoCredate + ", memberName=" + memberName
				+ "]";
	}
    
    
    

}
