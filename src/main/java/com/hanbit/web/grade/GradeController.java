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
		return "grade/content.tiles";
	}
	@RequestMapping("/regist")
	public String goRegist(){
		return "grade/regist.tiles";
	}
	
	@RequestMapping("/update")
	public String goUpdate(){
		return "grade/update.tiles";
	}
	
	@RequestMapping("/delete")
	public String goDelete(){
		return "grade/delete.tiles";
	}
	
	@RequestMapping("/list")
	public String goList(){
		return "grade/list.tiles";
	}
	
	@RequestMapping("/count")
	public String goCount(){
		return "grade/count.tiles";
	}
	
	@RequestMapping("/search")
	public String goSearch(){
		return "grade/search.tiles";
	}

}
