package com.hanbit.web.account;

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
		logger.info("AccountController ! goMain..");
		return "admin:account/content.tiles";
	}
	@RequestMapping("/open")
	public String goOpen(){
		logger.info("AccountController ! goOpen..");
		return "admin:account/open.tiles";
	}
	@RequestMapping("/deposit")
	public String goDeposit(){
		logger.info("AccountController ! goDeposit..");
		return "admin:account/deposit.tiles";
	}
	@RequestMapping("/withdraw")
	public String goWithdraw(){
		logger.info("AccountController ! goWithdraw..");
		return "admin:account/withdraw.tiles";
	}
	@RequestMapping("/update")
	public String goUpdate(){
		logger.info("AccountController ! goUpdate..");
		return "admin:account/update.tiles";
	}
	@RequestMapping("/delete")
	public String goDelete(){
		logger.info("AccountController ! goDelete..");
		return "admin:account/delete.tiles";
	}
	@RequestMapping("/list")
	public String goList(){
		logger.info("AccountController ! goList..");
		return "admin:account/list.tiles";
	}
	@RequestMapping("/find")
	public String goFind(){
		logger.info("AccountController ! goFind..");
		return "admin:account/find.tiles";
	}
	@RequestMapping("/count")
	public String goCount(){
		logger.info("AccountController ! goCount..");
		return "admin:account/count.tiles";
	}
	

}
