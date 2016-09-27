/**
 * 
 */
package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Data
public class MemberDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String id,pw,name,gender,regDate,ssn,profileImg,email,phone,role;
	@Getter @Setter private int majorSeq;
}