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
		return "admin:account/content.tiles";
	}
	@RequestMapping("/regist")
	public String goRegist(){
		return "admin:account/regist.tiles";
	}
	@RequestMapping("/deposit")
	public String goDeposit(){
		return "admin:account/deposit.tiles";
	}
	@RequestMapping("/withdraw")
	public String goWithdraw(){
		return "admin:account/withdraw.tiles";
	}
	@RequestMapping("/update")
	public String goUpdate(){
		return "admin:account/update.tiles";
	}
	@RequestMapping("/delete")
	public String goDelete(){
		return "admin:account/delete.tiles";
	}
	@RequestMapping("/list")
	public String goList(){
		return "admin:account/list.tiles";
	}
	@RequestMapping("/find_by_account")
	public String goFindByAccount(){
		return "admin:account/search.tiles";
	}
	@RequestMapping("/count")
	public String goCount(){
		return "admin:account/count.tiles";
	}
	

}
