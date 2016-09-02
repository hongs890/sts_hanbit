package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.subject.SubjectMemberVO;

@Controller
@SessionAttributes({"user", "js", "css", "img", "context"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option") String option,
			@RequestParam("context")String context, Model model){
		SubjectMemberVO member = service.findById(keyword);
		logger.info("Test (vo.getName) :{}",member.getName());
		logger.info("Test (keyword) : {}",keyword);
		logger.info("Test (option) : {}",option);
		logger.info("Test (context) : {}",context);
		model.addAttribute("member",member);
		model.addAttribute("img", context);
		return "admin:member/detail.tiles";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
			@RequestParam("pw") String pw, 
			@RequestParam("context") String context, Model model) {
		String temp ="";
		logger.info("TO LOGIN ID :: {}",id);
		logger.info("TO LOGIN PW :: {}",pw);
		logger.info("CONTEXT :: {}",context);
		SubjectMemberVO member = new SubjectMemberVO();
		member.setId(id);
		member.setPw(pw);
		if (!service.login(member).getId().equals("fail")) {
			member = service.findById(member.getId());
			temp = "user:user/content.tiles";
			model.addAttribute("user",member);
			model.addAttribute("context",context);
			model.addAttribute("js",context+"/resources/js");
			model.addAttribute("css",context+"/resources/css");
			model.addAttribute("img",context+"/resources/img");
		}else{
			temp = "public:member/login.tiles";
		}
		return temp;
	}
	
	// move//
	@RequestMapping("/main")
	public String goMain() {
		logger.info("GO :: {}","main");
		return "user:user/content.tiles";
	}

	@RequestMapping("/regist")
	public String moveRegist(){
		logger.info("GO :: {}","regist");
		return "public:member/regist.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail(){	
		logger.info("GO :: {}","detail");
		return "user:member/detail.tiles";
	}
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key") String key){	
		logger.info("GO :: {}","a_detail");
		logger.info("KEY :: {}",key);
		return "admin:member/a_detail.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(){
		logger.info("GO :: {}","update");
		return "user:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(){
		logger.info("GO :: {}","delete");
		return "user:member/delete.tiles";
	}
	@RequestMapping("/login")
	public String login(){
		logger.info("GO :: {}","login");
		return "public:member/login.tiles";
	}
	@RequestMapping("/logout")
	public String moveLogout(){
		logger.info("GO :: {}","logout");
		return "admin:member/logout.tiles";
	}
	@RequestMapping("/list")
	public String moveList(){
		logger.info("GO :: {}","list");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find_by")
	public String moveFindBy(){
		logger.info("GO :: {}","find_by");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("GO :: {}","count");
		return "admin:member/count.tiles";
	}
	
	@RequestMapping("/kaup")
	public String moveKaup(){
		logger.info("GO :: {}","kaup");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/rock_sissor_paper")
	public String moveRockSissorPaper(){
		logger.info("GO :: {}","rockSissorPaper");
		return "user:user/rockSissorPaper.tiles";
	}
	@RequestMapping("/lotto")
	public String moveLotto(){
		logger.info("GO :: {}","lotto");
		return "user:user/lotto.tiles";
	}
}


