/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.util.CommonService;

@Component
public interface MemberService{
	public String regist(MemberDTO member);
	public String update(MemberDTO member);
	public MemberDTO findOne(Command command);
	public MemberDTO login(MemberDTO member);
	public String delete(MemberDTO member);
	public List<MemberDTO> list(Command command);
	public List<?> find(Command command);
	public int count();
}
