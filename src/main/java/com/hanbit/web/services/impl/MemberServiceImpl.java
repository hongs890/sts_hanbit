package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private SqlSession sqlSession;
	@Autowired private Command command;
	@Autowired private Retval val;
	@Override
	public String regist(MemberDTO member) {
		return (sqlSession.getMapper(MemberMapper.class).insert(member)==-1)?"success":"fail"; 
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
	public String update(MemberDTO member) {
		return String.valueOf(sqlSession.getMapper(MemberMapper.class).update(member));
	}
	@Override
	public String delete(MemberDTO mem) {
		return String.valueOf(sqlSession.getMapper(MemberMapper.class).delete(mem));
	}
	@Override
	public int count() {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.count(val);
		return val.getCount();
	}
	@Override
	public MemberDTO findOne(Command command) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findOne(command);
	}
	@Override
	public List<?> findByName(String findName) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.findByName(findName);
	}

	@Override
	public List<MemberDTO> list(Command command) {
		return sqlSession.getMapper(MemberMapper.class).list(command);
	}
}