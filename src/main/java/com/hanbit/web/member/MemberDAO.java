package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMemberVO;


public interface MemberDAO {
	public int insert(MemberVO mem);
	public int update(MemberVO mem);
	public int delete(MemberVO mem);
	public List<?> list();
	public SubjectMemberVO findById(String pk);
	public List<?> findByName(String name);
	public int count();
	public boolean login(SubjectMemberVO param);

}
