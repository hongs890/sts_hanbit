package com.hanbit.web.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;

@Repository
public interface MemberMapper{
	public int insert(MemberDTO member);
	public MemberDTO login(MemberDTO param);
	public MemberDTO findOne(Command command);
	public int update(MemberDTO member);
	public int delete(MemberDTO member);
	public List<MemberDTO> list(Command command);
	public List<?> findByName(String name);
	public Integer count(Retval val);
	public List<?> findBy(String keyword);
}
