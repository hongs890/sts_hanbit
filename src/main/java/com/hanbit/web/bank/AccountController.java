package com.hanbit.web.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@RequestMapping("/main")
	public String goMain(){
		return "account/content.tiles";
	}
	@RequestMapping("/regist")
	public String goRegist(){
		return "account/regist.tiles";
	}
	@RequestMapping("/deposit")
	public String goDeposit(){
		return "account/deposit.tiles";
	}
	@RequestMapping("/withdraw")
	public String goWithdraw(){
		return "account/withdraw.tiles";
	}
	@RequestMapping("/update")
	public String goUpdate(){
		return "account/update.tiles";
	}
	@RequestMapping("/delete")
	public String goDelete(){
		return "account/delete.tiles";
	}
	@RequestMapping("/list")
	public String goList(){
		return "account/list.tiles";
	}
	@RequestMapping("/find_by_account")
	public String goFindByAccount(){
		return "account/search.tiles";
	}
	@RequestMapping("/count")
	public String goCount(){
		return "account/count.tiles";
	}
	

}
