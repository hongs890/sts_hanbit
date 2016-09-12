/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;

public interface MemberService extends CommonService{
	public String regist(MemberDTO mem);
	public void update(MemberDTO mem);
	public void delete(MemberDTO mem);
	public MemberDTO findById(String mem);
	public MemberDTO login(MemberDTO member);
	public List<?> findByName(String findName);
}
