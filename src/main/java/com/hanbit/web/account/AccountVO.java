/**
 * 
 */
package com.hanbit.web.account;
import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class AccountVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int accountNo, money; 
	private String id;
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}