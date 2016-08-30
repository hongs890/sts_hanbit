package com.hanbit.web.util;

import com.hanbit.web.account.AccountServiceImpl;
import com.hanbit.web.grade.GradeServiceImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;
import com.hanbit.web.subject.SubjectServiceImpl;
import com.hanbit.web.subject.SubjectVO;

public class Test {
	public String test(){
		MemberVO m = MemberServiceImpl.getInstance().findById("hong");
		return m.getName();
	}
	public String test2(){
		GradeVO g = GradeServiceImpl.getInstance().findBySeq(1000);
		return g.getId();
	}
	public int test3(){
		int a = AccountServiceImpl.getInstence().count();
		return a;
	}
	public String test4(){
		SubjectVO s = SubjectServiceImpl.getInstance().findById("hong");
		return s.getMajor();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("member test : "+t.test());
		System.out.println("grade test : "+t.test2());
		System.out.println("account test : "+t.test3());
		System.out.println("subject test : "+t.test4());
	}
}
