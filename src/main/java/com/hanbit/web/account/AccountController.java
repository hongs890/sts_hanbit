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
		logger.info("GO :: {}","main");
		return "admin:account/content.tiles";
	}
	@RequestMapping("/open")
	public String goOpen(){
		logger.info("GO :: {}","open");
		return "user:account/open.tiles";
	}
	@RequestMapping("/transaction")
	public String goTransaction(){
		logger.info("GO :: {}","transaction");
		return "user:account/transaction.tiles";
	}
	@RequestMapping("/update")
	public String goUpdate(){
		logger.info("GO :: {}","update");
		return "admin:account/update.tiles";
	}
	@RequestMapping("/delete")
	public String goDelete(){
		logger.info("GO :: {}","delete");
		return "user:account/open.tiles";
	}
	@RequestMapping("/list")
	public String goList(){
		logger.info("GO :: {}","list");
		return "admin:account/list.tiles";
	}
	@RequestMapping("/detail")
	public String goDetail(){
		logger.info("GO :: {}","detail");
		return "user:account/detail.tiles";
	}
	@RequestMapping("/find")
	public String goFind(){
		logger.info("GO :: {}","find");
		return "admin:account/find.tiles";
	}
	@RequestMapping("/count")
	public String goCount(){
		logger.info("GO :: {}","count");
		return "admin:account/count.tiles";
	}
	

}
