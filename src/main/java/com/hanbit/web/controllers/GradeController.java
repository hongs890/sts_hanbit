package com.hanbit.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/main")
	public String goMain(){
		logger.info("GO :: {}","main");
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String goRegist(@RequestParam("key") String key){
		logger.info("GO :: {}","regist");
		logger.info("KEY :: {}",key);
		return "admin:grade/regist.tiles";
	}
	
	@RequestMapping("/update")
	public String goUpdate(@RequestParam("key") String key){
		logger.info("GO :: {}","update");
		logger.info("KEY :: {}",key);
		return "admin:grade/update.tiles";
	}
	
	@RequestMapping("/delete")
	public String goDelete(){
		logger.info("GO :: {}","delete");
		return "admin:grade/delete.tiles";
	}
	
	@RequestMapping("/detail")
	public String goDetail(){
		logger.info("GO :: {}","detail");
		return "user:grade/detail.tiles";
	}
	
	@RequestMapping("/count")
	public String goCount(){
		logger.info("GO :: {}","count");
		return "admin:grade/count.tiles";
	}
	
	@RequestMapping("/find")
	public String goFind(){
		logger.info("GO :: {}","find");
		return "user:grade/find.tiles";
	}
	@RequestMapping("/list")
	public String goList(){
		logger.info("GO :: {}","list");
		return "admin:grade/list.tiles";
	}

}
