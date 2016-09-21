package com.hanbit.web.mappers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;

@Repository
public interface MemberMapper{
	public String regist(MemberDTO mem);
	public MemberDTO findOne(Command command);
	public int insert(Command command);
	public void update(MemberDTO mem);
	public void delete(MemberDTO mem);
	public List<?> list();
	public List<?> findByName(String name);
	public int count();
	public MemberDTO login(MemberDTO param);
	public List<?> findBy(String keyword);
	public Map<?, ?> map();
	public int existId(String id);
	

}
