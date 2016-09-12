package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.mappers.GradeMapper;
import com.hanbit.web.services.GradeService;

@Service
public class GradeServiceImpl implements GradeService{

	
	private GradeMapper dao;
	private static GradeServiceImpl instance = new GradeServiceImpl();
	private GradeServiceImpl() {}
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public String GradeCal(GradeDTO grade) {
		String gradeRank ="";
		int sum = grade.getJava() + grade.getSql() + grade.getHtml() + grade.getJavascript();
		int ave = sum / 4;
		switch (ave/10) {
		case 9:	gradeRank = "A";break;
		case 8:	gradeRank = "B";break;
		case 7:	gradeRank = "C";break;
		case 6:	gradeRank = "D";break;
		case 5:	gradeRank = "F";break;
		}
		return gradeRank;
	}
	
	
	@Override
	public String insert(GradeDTO grade) {
		String insert = "";
		grade.setGrade(this.GradeCal(grade));
		if (dao.insert(grade) == 1) {
			insert ="시험점수 등록이 성공하였습니다";
		}else{
			insert = "실패하였습니다";
		}
		return insert;
	}

	@Override
	public String update(GradeDTO grade) {
		String update = "";
		if (dao.update(grade) == 1) {
			update ="성공";
		}else{
			update ="실패";
		}
		return update;
	}

	@Override
	public String delete(String delete) {
		String result ="";
		if (dao.delete(delete) == 1) {
			result ="삭제 성공";
		}else {
			result ="삭제 실패";
		}
		return result;
	}

	@Override
	public List<?> list() {
		return dao.list();
	}

	@Override
	public List<?> findBy(String id) {
		return dao.findByID(id);
	}

	
	@Override
	public GradeDTO findBySeq(int seq) {
		return dao.findBySeq(seq);
	}

	@Override
	public int count(String findByCount) {
		return dao.count(findByCount);
	}
	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
