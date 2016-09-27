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
	public @ResponseBody Retval list(@PathVariable String pgNum,Model model){
		logger.info("LIST pgNum {}",pgNum);
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int[] rows = new int[2];
		int[] pages = new int[3];
		int totCount = service.count();
		pages = Pagination.getPages(totCount, Integer.parseInt(pgNum));
		rows = Pagination.getRows(totCount, Integer.parseInt(pgNum), Values.PG_SIZE); 
		command.setStart(rows[0]);
		command.setEnd(rows[1]);
		logger.info("LIST pgSize {}", Values.PG_SIZE);
		logger.info("LIST totCount {}", totCount);
		logger.info("LIST totPg {}", pages[2]);
		logger.info("LIST pgNum {}", pgNum);
		logger.info("LIST startPg {}", pages[0]);
		logger.info("LIST lastPg {}", pages[1]);	
		model.addAttribute("list", service.list(command));
		model.addAttribute("pgSize", Values.PG_SIZE);
		model.addAttribute("totCount", totCount);
		model.addAttribute("totPg", pages[2]);
		model.addAttribute("pgNum", Integer.parseInt(pgNum));
		model.addAttribute("startPg", pages[0]);
		model.addAttribute("lastPg", pages[1]);
		retval.setMessage("success");
		return retval;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/search")
	public String Search(@RequestParam(value="keyField") String keyField,
			@RequestParam(value="keyword") String keyword, @RequestParam(value="pgNum") String strPgNum, Model model){
		logger.info("== MEMBER CONTROLLER SEARCH :: SEARCH :: {} ==","SUCCESS");
		command.setKeyField(keyField);
		command.setKeyword(keyword);
		List <MemberDTO> list = (List<MemberDTO>) service.find(command);
		int[] pages = Pagination.getPages(list.size(),1);
		int[] rows = Pagination.getRows(list.size(),1,Values.PG_SIZE); 
		model.addAttribute("list", service.find(command));
		model.addAttribute("pgSize", Values.PG_SIZE);
		model.addAttribute("totCount", list.size());
		model.addAttribute("totPg", pages[2]);
		model.addAttribute("pgNum", 1);
		model.addAttribute("startPg", pages[0]);
		model.addAttribute("lastPg", pages[1]);
		return "admin:member/list.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("GO :: {}","count");
		return "admin:member/count.tiles";
	}
}


