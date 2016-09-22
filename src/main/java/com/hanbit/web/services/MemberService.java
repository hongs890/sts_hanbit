/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;

@Component
public interface MemberService extends CommonService{
	public String regist(MemberDTO member);
	public void update(MemberDTO mem);
	public MemberDTO findOne(Command command);
	public MemberDTO login(MemberDTO member);
	public List<?> findByName(String findName);
}
