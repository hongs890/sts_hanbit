<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="text-align: center">
<table id="member_list">
	<tr>
	    <td>ID</td>
	    <td>이름</td>
	    <td>등록일</td>
	    <td>생년월일</td>
	    <td>E-mail</td>
	    <td>전화번호</td>
	</tr>
	<c:forEach var="member" items="${list}">
	<tr>
	    <td>${member.id}</td>
	    <td><a href="${context}/member.do?action=find_by_id&page=find_by_id&keyword=${member.id}">${member.name}</a></td>
	    <td>${member.regDate}</td>
	    <td>${member.ssn}</td>
	    <td>${member.email}</td>
	    <td>${member.phone}</td>
	</tr>
	</c:forEach>
</table>
		<a id="member_content_a_member"><img id="member_content_img_member"/></a>
	<a id="member_content_a_home"><img id="member_content_img_home"/></a>
</div>

