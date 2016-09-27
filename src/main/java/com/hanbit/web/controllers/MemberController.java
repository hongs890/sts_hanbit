package com.hanbit.web.controllers;


import java.util.ArrayList;
import java.util.List;

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

import com.hanbit.web.constants.Values;
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.impl.MemberServiceImpl;
import com.hanbit.web.util.Pagination;

@Controller
@SessionAttributes({"user", "js", "css", "img", "context"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired private MemberServiceImpl service;
	@Autowired private Command command;
	@Autowired private MemberDTO member;
	@Autowired private Retval retval;
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
			@PathVariable("keywrod") String keyword, Model model){
		logger.info("== MEMBER CONTROLLER FIND :: KEYWORD :: {} ==",keyword);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	@RequestMapping(value="/count/{option}")
	public Model count(@PathVariable("option")String option, Model model){
		logger.info("== MEMBER CONTROLLER COUNT :: OPTION :: {} ==", option);
		model.addAttribute("count", service.count());
		return model;
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		return "user/header.jsp";
		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Retval signup(@RequestBody MemberDTO param){
		logger.info("== MEMBER CONTROLLER SIGNUP :: ID :: {} ==",param.getId());
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
		logger.info("== MEMBER CONTROLLER CHECKDUP :: ID :: {} ==",id);
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
		return retval;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody MemberDTO login(@RequestParam("id") String id,
			@RequestParam("pw") String pw, HttpSession session) {
		logger.info("== MEMBER CONTROLLER LOGIN :: ID :: {} ==",id);
		member.setId(id);
		member.setPw(pw);
		MemberDTO user = service.login(member);
		if (user.getId().equals("fail")) {
			return user;
		}else{
			session.setAttribute("user", user);
			session.setAttribute("pw", user.getPw());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("phone", user.getPhone());
			return user;
		}

	}
	@RequestMapping(value="/detail")
	public @ResponseBody MemberDTO moveDetail(HttpSession session){	
		logger.info("== MEMBER CONTROLLER DETAIL :: DETAIL :: {} ==","SUCCESS");
		return (MemberDTO) session.getAttribute("user");
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody Retval moveUpdate(@RequestBody MemberDTO param, HttpSession session){
		logger.info("== MEMBER CONTROLLER UPDATE :: UPDATE :: {} ==","SUCCESS");
		MemberDTO temp = (MemberDTO) session.getAttribute("user");
		temp.setPw(param.getPw());
		temp.setEmail(param.getEmail());
		temp.setPhone(param.getPhone());
		service.update(temp);
		retval.setMessage("success");
		return retval;
	}
	@RequestMapping(value="/unregist", method=RequestMethod.POST)
	public @ResponseBody Retval moveUnregist(@RequestParam("pw") String pw, HttpSession session){
		logger.info("== MEMBER CONTROLLER UNREGIST :: UNREGIST :: {} ==","SUCCESS");
		member.setPw(pw);
		if (pw.equals(session.getAttribute("pw"))) {
			retval.setMessage("success");
			service.delete(member);
			session.invalidate();
		}else{
			retval.setMessage("fail");
		}
		return retval;
	}
	@RequestMapping("/logout")
	public String moveLogout(SessionStatus status){
		logger.info("== MEMBER CONTROLLER LOGOUT :: LOGOUT :: {} ==","SUCCESS");
		status.setComplete();
		return "redirect:/";
	}
	@RequestMapping("/list/{pgNum}")
	public String list(@PathVariable String pgNum, Model model){
		logger.info("== MEMBER CONTROLLER LIST :: LIST :: {} ==","SUCCESS");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int[]rows = new int[2];
	//	int pgCount = totCount/PG_SIZE;
		rows = Pagination.getStartRow(service.count(), Integer.parseInt(pgNum), Values.PG_SIZE);
		command.setStart(rows[0]);
		command.setEnd(rows[1]);
		model.addAttribute("list", service.list(command));
		return "admin:member/list.tiles";
	}
	
	
	@RequestMapping("/search")
	public String Search(@RequestParam(value="keyField") String keyField,
			@RequestParam(value="keyword") String keyword, @RequestParam(value="pgNum") String strPgNum, Model model){
		logger.info("== MEMBER CONTROLLER SEARCH :: SEARCH :: {} ==","SUCCESS");
		List <MemberDTO> list = new ArrayList<MemberDTO>();
		service.list(command);
		model.addAttribute("list", list);
		return "admin:member/list.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("GO :: {}","count");
		return "admin:member/count.tiles";
	}
}


