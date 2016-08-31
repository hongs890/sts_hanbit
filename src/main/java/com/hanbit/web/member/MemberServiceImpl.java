package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.subject.SubjectMemberVO;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDAOImpl dao;
	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
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
	}
	@Override
	public void delete(MemberVO mem) {
	}
	@Override
	public int count() {
		return dao.count();
	}
	@Override
	public SubjectMemberVO findById(String mem) {
		return dao.findById(mem);
	}
	@Override
	public List<?> list() {
		return dao.list();
	}
	@Override
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
	@Override
	public SubjectMemberVO login(SubjectMemberVO member) {
		SubjectMemberVO bean = new SubjectMemberVO();
			if (dao.login(member)) {
				bean = dao.findById(member.getId());
			}else{
				bean.setId("fail");
			}
		return bean;
	}
}