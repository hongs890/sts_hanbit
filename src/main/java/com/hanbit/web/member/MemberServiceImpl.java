package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectBean;
import com.hanbit.web.subject.SubjectDAO;
import com.hanbit.web.subject.SubjectMember;


/**
 * @date  : 2016. 6. 20.
 * @author: 배근홍
 * @file  : StudentServiceImpl.java
 * @story :
 */
public class MemberServiceImpl implements MemberService {
	
	private MemberDAO dao = MemberDAO.getInstance();
	private SubjectDAO subjDao = SubjectDAO.getInstance();
	private AccountService accService = AccountServiceImpl.getInstence();
	private MemberBean session;
	private static MemberServiceImpl instanceImpl = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		session = new MemberBean();
	}

	public MemberBean getSession() {
		return session;
	}
	
	public void logoutSession(MemberBean member) {
		if (member.getId().equals(session.getId()) && member.getPw().equals(session.getPw())) {
			session = null;
		}
	}
	
	public static MemberServiceImpl getInstanceImpl() {
		return instanceImpl;
	}
	
	@Override
	public String regist(MemberBean mem) {
		String msg = "";
		if (dao.insert(mem)==1) {
			msg = dao.findById(mem.getId()).getName();
		}
		return msg;
	}

	

	@Override
	public void update(MemberBean mem) {
		mem.setId(session.getId());
		dao.update(mem);
		session = dao.findById(mem.getId());
	}

	@Override
	public void delete(MemberBean mem) {
		dao.delete(mem);
		session = dao.findById(mem.getId());
	}
	
	
	public int count() {
		return dao.count();
	}
	@Override
	public MemberBean detail(String mem) {
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
	
	public SubjectMember login(MemberBean member) {
		SubjectMember sm = new SubjectMember();
		SubjectBean sb = new SubjectBean();
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