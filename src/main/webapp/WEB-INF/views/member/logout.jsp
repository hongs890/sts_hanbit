<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="text-align: center">
	<form action="${context }/member.do" method="post">
			정말 로그아웃 하시겠습니까?<br/><br/>
			<input type="hidden" name="directory" value="home">
			<input type="hidden" name="action" value="logout">
			<input type="submit" value="로그아웃"><br/><br/>
	<a href="${context }/member.do"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/global.do"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</form>
	</div>
