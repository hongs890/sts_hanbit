package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private SqlSession sqlSession;
	@Autowired private Command command;
	@Override
	public String regist(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String msg = "";
		if (mapper.insert(command)==1) {
			msg = mapper.findOne(command).getId();
		}
		return msg;
	}
	@Override
	public int count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.count();
	}
	@Override
	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command);
	}
	@Override
	public List<?> list() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.list();
	}
	@Override
	public List<?> findByName(String findName) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findByName(findName);
	}
	@Override
	public List<?> findBy(String keyword) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return null;
	}
	@Override
	public Map<?, ?> map() {
		return null;
	}
	
	@Override
	public MemberDTO login(MemberDTO member) {
		MemberDTO mem = new MemberDTO();
		command.setOption("mem_id");
		command.setKeyword(member.getId());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		if (member.getId() != null && member.getPw() != null && mapper.findOne(command) != null) {
			mem = mapper.findOne(command);
			if (member.getPw().equals(mem.getPw())) {
				return mem;
			}else{
				System.out.println("fail 1번");
				mem.setId("fail");
			}
		}else{
			System.out.println("fail 2번");
			mem.setId("fail");
		}
		return mem;
	}
	@Override
	public void update(MemberDTO mem) {

	}
}