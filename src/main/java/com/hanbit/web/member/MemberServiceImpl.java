package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.account.AccountService;
import com.hanbit.web.account.AccountServiceImpl;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.subject.SubjectVO;


@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDAOImpl dao;
	private SubjectDAOImpl subjDao = SubjectDAOImpl.getInstance();
	private AccountService accService = AccountServiceImpl.getInstence();
	private MemberVO session;
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}

	public MemberVO getSession() {
		return session;
	}
	
	public void logoutSession(MemberVO member) {
		if (member.getId().equals(session.getId()) && member.getPw().equals(session.getPw())) {
			session = null;
		}
	}
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public String regist(MemberVO mem) {
		String msg = "";
		if (dao.insert(mem)==1) {
			msg = dao.findById(mem.getId()).getName();
		}
		return msg;
	}

	

	@Override
	public void update(MemberVO mem) {
		mem.setId(session.getId());
		dao.update(mem);
		session = dao.findById(mem.getId());
	}

	@Override
	public void delete(MemberVO mem) {
		dao.delete(mem);
		session = dao.findById(mem.getId());
	}
	
	
	public int count() {
		return dao.count();
	}
	@Override
	public MemberVO findById(String mem) {
		return dao.findById(mem);
	}
	public List<?> list() {
		return dao.list();
	}
	public List<?> findByName(String findName) {
		return dao.findByName(findName);
	}
	@Override
	public List<?> findBy(String keyword) {
		return null;
	}
	@Override
	public Map<?, ?> map() {
		return null;
	}
	
	public SubjectMemberVO login(MemberVO member) {
		SubjectMemberVO sm = new SubjectMemberVO();
		SubjectVO sb = new SubjectVO();
			if (dao.login(member)) {
				session = dao.findById(member.getId());
				accService.map();
				sb = subjDao.findById(member.getId());
				sm.setEmail(session.getEmail());
				sm.setId(session.getId());
				sm.setImg(session.getProfileImg());
				sm.setMajor(sb.getMajor());
				sm.setName(session.getName());
				sm.setPhone(session.getPhone());
				sm.setPw(session.getPw());
				sm.setReg(session.getRegDate());
				sm.setSsn(session.getSsn());
				sm.setSubjects(sb.getSubjects());
				sm.setGender(session.getGender());
			}else{
				sm.setId("fail");
			}
		return sm;
	}
	public String myAccount() {
		return session.toString();
	}
}