package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class GradeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String id,pw,name,subjName,gender,regDate,ssn,email,profileImg,role,phone,grade,term;
	@Getter @Setter private int gradeSeq,subjSeq,examSeq,score;
}