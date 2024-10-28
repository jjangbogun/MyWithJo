package com.withJo.customer.domain;

import java.util.Date;

public class CustomerVo {
	
	private int customerNo;           
	private int memberQNo;      
	private int memberANo;      
    private String memberName;
    private String customerTitle;
    private String customerQue;
    private String customerAns;
    private Date customerQCredate; 
    private Date customerACredate; 
    private String customerCheck;
    
	public CustomerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerVo(int customerNo, int memberQNo, int memberANo, String memberName, String customerTitle,
			String customerQue, String customerAns, Date customerQCredate, Date customerACredate,
			String customerCheck) {
		super();
		this.customerNo = customerNo;
		this.memberQNo = memberQNo;
		this.memberANo = memberANo;
		this.memberName = memberName;
		this.customerTitle = customerTitle;
		this.customerQue = customerQue;
		this.customerAns = customerAns;
		this.customerQCredate = customerQCredate;
		this.customerACredate = customerACredate;
		this.customerCheck = customerCheck;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getMemberQNo() {
		return memberQNo;
	}

	public void setMemberQNo(int memberQNo) {
		this.memberQNo = memberQNo;
	}

	public int getMemberANo() {
		return memberANo;
	}

	public void setMemberANo(int memberANo) {
		this.memberANo = memberANo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCustomerTitle() {
		return customerTitle;
	}

	public void setCustomerTitle(String customerTitle) {
		this.customerTitle = customerTitle;
	}

	public String getCustomerQue() {
		return customerQue;
	}

	public void setCustomerQue(String customerQue) {
		this.customerQue = customerQue;
	}

	public String getCustomerAns() {
		return customerAns;
	}

	public void setCustomerAns(String customerAns) {
		this.customerAns = customerAns;
	}

	public Date getCustomerQCredate() {
		return customerQCredate;
	}

	public void setCustomerQCredate(Date customerQCredate) {
		this.customerQCredate = customerQCredate;
	}

	public Date getCustomerACredate() {
		return customerACredate;
	}

	public void setCustomerACredate(Date customerACredate) {
		this.customerACredate = customerACredate;
	}

	public String getCustomerCheck() {
		return customerCheck;
	}

	public void setCustomerCheck(String customerCheck) {
		this.customerCheck = customerCheck;
	}

	@Override
	public String toString() {
		return "CustomerVo [customerNo=" + customerNo + ", memberQNo=" + memberQNo + ", memberANo=" + memberANo
				+ ", memberName=" + memberName + ", customerTitle=" + customerTitle + ", customerQue=" + customerQue
				+ ", customerAns=" + customerAns + ", customerQCredate=" + customerQCredate + ", customerACredate="
				+ customerACredate + ", customerCheck=" + customerCheck + "]";
	}
    
    

}
