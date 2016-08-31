package com.hanbit.web.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.subject.SubjectMemberVO;


@Controller
@SessionAttributes({"user", "js", "css", "img"})
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
	@RequestMapping("/login/execute")
	public String executeLogin(@RequestParam("id") String id,
			@RequestParam("pw") String pw, 
			@RequestParam("context") String context, Model model) {
		String temp ="";
		logger.info("Test executeLogin (id) : {}",id);
		logger.info("Test executeLogin (pw) : {}",pw);
		logger.info("Test executeLogin (context) : {}",context);
		SubjectMemberVO member = new SubjectMemberVO();
		member.setId(id);
		member.setPw(pw);
		if (!service.login(member).getId().equals("fail")) {
			member = service.findById(member.getId());
			temp = "user:user/content.tiles";
			model.addAttribute("user",member);
			model.addAttribute("js",context+"/resources/js");
			model.addAttribute("css",context+"/resources/css");
			model.addAttribute("img",context+"/resources/img");
		}else{
			temp = "public:member/login.tiles";
		}
		return temp;
	}

	@RequestMapping("/main")
	public String goMain() {
		logger.info("MemberController ! goMain..");
		return "user:user/content.tiles";
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


