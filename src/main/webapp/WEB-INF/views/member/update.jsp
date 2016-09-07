<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="text-align: center">	
	<table id="member_detail">
		<tr>
			<td rowspan="6" style="width:30%">
			<img src="${img}/member/${member.profileImg}" alt="W3Schools.com" width="200" height="200"></td>
			<td style="width:20%" class="font_bold bg_color_yellow">ID</td>
			<td style="width:40%">${member.id}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">비밀번호</td>
			<td>*******</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이 름</td>
			<td>${member.name}</td>
		</tr>
		<tr>	
			<td class="font_bold bg_color_yellow">성 별</td>
			<td>${member.gender}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">이메일</td>
			<td>${member.email}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">핸드폰 번호</td>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">전공과목</td>
			<td colspan="2">test</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">수강과목</td>
			<td colspan="2">test</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">생년월일</td>
			<td colspan="2">${member.ssn.substring(0,6)}</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">등록일</td>
			<td colspan="2">${member.regDate}</td>
		</tr>
	</table>
	<br/> 
	<a id="member_content_a_member"><img id="member_content_img_member"/></a>
	<a id="member_content_a_home"><img id="member_content_img_home"/></a>
	</div>