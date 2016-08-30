package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option") String option,
			@RequestParam("context")String context, Model model){
	
		MemberVO member = service.findById(keyword);
		logger.info("Test (vo.getName) :{}",member.getName());
		logger.info("Test (keyword) : {}",keyword);
		logger.info("Test (option) : {}",option);
		logger.info("Test (context) : {}",context);
		model.addAttribute("member",member);
		model.addAttribute("img", context);
		
		return "admin:member/detail.tiles";
	}
	
	@RequestMapping("/main")
	public String goMain() {
		logger.info("MemberController ! goMain..");
		return "admin:member/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(){
		logger.info("MemberController ! regist()..");
		return "public:member/regist.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail(){
		logger.info("MemberController ! detail()..");
		return "admin:member/detail.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(){
		logger.info("MemberController ! update()..");
		return "admin:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(){
		logger.info("MemberController ! delete()..");
		return "admin:member/delete.tiles";
	}
	@RequestMapping("/login")
	public String moveLogin(){
		logger.info("MemberController ! login()..");
		return "public:member/login.tiles";
	}
	@RequestMapping("/logout")
	public String moveLogout(){
		logger.info("MemberController ! logout()..");
		return "admin:member/logout.tiles";
	}
	@RequestMapping("/list")
	public String moveList(){
		logger.info("MemberController ! list()..");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find_by")
	public String moveFindBy(){
		logger.info("MemberController ! find_by()..");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("MemberController ! count()..");
		return "admin:member/count.tiles";
	}
	
}


