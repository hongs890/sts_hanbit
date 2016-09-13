package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class SubjectDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String id,subjName;
	@Getter @Setter private int subjSeq;

}
