package com.banking.bean;

public class AccountBean {
	
	private int accno;
	private String ifsc;
	private int amount;
	private String accname;
	private String mode;
	
	public AccountBean(int accno, String ifsc, int amount, String accname, String mode) {
		super();
		this.accno = accno;
		this.ifsc = ifsc;
		this.amount = amount;
		this.accname = accname;
		this.mode = mode;
	}

	
	
	public AccountBean() {
		
	}



	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}



	@Override
	public String toString() {
		return "AccountBean [accno=" + accno + ", ifsc=" + ifsc + ", amount=" + amount + ", accname=" + accname
				+ ", mode=" + mode + "]";
	}
	
	
}
