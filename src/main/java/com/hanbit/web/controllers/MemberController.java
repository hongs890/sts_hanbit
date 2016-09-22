package com.hanbit.web.controllers;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;

@Controller
@SessionAttributes({"user", "js", "css", "img", "context"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl service;
	@Autowired Command command;
	@Autowired MemberDTO member;
	@Autowired Retval retval;
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
			@PathVariable("keywrod") String keyword, Model model){
		logger.info("TO SEARCH KEYWORD IS {}",keyword);
		logger.info("TO SEARCH OPTION IS {}",option);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	@RequestMapping(value="/count/{option}")
	public Model count(@PathVariable("option")String option, Model model){
		logger.info("TO COUNT CONDITION IS :{}", option);
		model.addAttribute("count", service.count());
		return model;
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("THIS PATH IS {}","LOGINED_HEADER");
		return "user/header.jsp";
		
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody MemberDTO login(@RequestParam("id") String id,
			@RequestParam("pw") String pw, HttpSession session) {
		logger.info("TO LOGIN ID :: {}",id);
		logger.info("TO LOGIN PW :: {}",pw);
		member.setId(id);
		member.setPw(pw);
		member = service.login(member);
		if (member.getId().equals("fail")) {
			logger.info("LOGIN FAIL","!!!!!");
			return member;
		}else{
			logger.info("LOGIN SUCCESS","!!!!!");
			session.setAttribute("user", member);
			member = service.findOne(command);
			return member;
		}

	}
	
	// move//
	@RequestMapping("/main")
	public String goMain() {
		logger.info("GO :: {}","main");
		return "user:user/content.tiles";
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Retval signup(@RequestBody MemberDTO param){
		logger.info("SIGN UP :: {}","EXECUTE");
		retval.setMessage("success");
		param.setGender("MALE");
		param.setRegDate("2016-09-11");
		param.setProfileImg("default.jpg");
		param.setRole("STUDENT");
		param.setMajorSeq(1001);
		service.regist(param);
		return retval;
	}
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval checkDup(@PathVariable String id){
		command.setKeyword(id);
		command.setOption("mem_id");
		if (service.findOne(command) != null) {
			retval.setFlag("TRUE");
			retval.setMessage("입력하신 ID는 이미 존재합니다.");
			
		} else {
			retval.setFlag("FALSE");
			retval.setMessage("입력하신 ID는 사용 가능합니다.");
			retval.setTemp(id);
		}
		logger.info("FLAG :: {}",retval.getFlag());
		logger.info("MESSAGE :: {}",retval.getMessage());
		return retval;
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
	public String moveLogout(SessionStatus status){
		logger.info("GO :: {}","logout");
		status.setComplete();
		logger.info("SESSION :: {}","CLEAR");
		return "redirect:/";
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


