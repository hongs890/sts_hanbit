package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/main")
	public String goMain(){
		return "admin:grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String goRegist(){
		return "admin:grade/regist.tiles";
	}
	
	@RequestMapping("/update")
	public String goUpdate(){
		return "admin:grade/update.tiles";
	}
	
	@RequestMapping("/delete")
	public String goDelete(){
		return "admin:grade/delete.tiles";
	}
	
	@RequestMapping("/list")
	public String goList(){
		return "admin:grade/list.tiles";
	}
	
	@RequestMapping("/count")
	public String goCount(){
		return "admin:grade/count.tiles";
	}
	
	@RequestMapping("/search")
	public String goSearch(){
		return "admin:grade/search.tiles";
	}

}
