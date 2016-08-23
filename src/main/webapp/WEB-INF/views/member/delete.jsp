<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div style="text-align: center">
		<h1>정말 탈퇴하시겠습니까?</h1><br/>
			<form action="${context}/member.do" method="post">
				비밀번호를 입력해주세요<input type="text" name="pw"><br/>
				<input type="hidden" name="directory" value="home">
				<input type="hidden" name="action" value="delete">
				<input type="submit" value="탈퇴">
				<input type="reset" value="취소">
			</form> 
	<a href="${context }/member.do"><img src="${img}/member.png" alt="member" style="width: 30px" /></a> 
	<a href="${context}/global.do"><img src="${img }/home.png" alt="home" style="width: 30px" /></a>
	</div>
