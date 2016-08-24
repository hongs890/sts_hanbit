<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="text-align: center">
	<form action="${context }/member.do" method="post">
			정말 로그아웃 하시겠습니까?<br/><br/>
			<input type="hidden" name="directory" value="home">
			<input type="hidden" name="action" value="logout">
			<input type="submit" value="로그아웃"><br/><br/>
		<a id="member_content_a_member"><img id="member_content_img_member"/></a>
	<a id="member_content_a_home"><img id="member_content_img_home"/></a>
	</form>
	</div>
