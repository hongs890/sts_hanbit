<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div style="text-align: center">
	<form action="${context }/member.do" method="get">
		<input type="text" name="keyword" placeholder="검색할  ID">
		<input type="hidden" name="action" value="find_by_id">
		<input type="hidden" name="page" value="find_by_id">
		<input type="submit" value="검색">
		<input type="reset" value="취소">
	</form><br/><br/>
	<form action="${context }/member.do" method="get">
		<input type="text" name="keyword" placeholder="검색할  이름">
		<input type="hidden" name="action" value="find_by_name">
		<input type="hidden" name="page" value="list">
		<input type="submit" value="검색">
		<input type="reset" value="취소">
	</form>
	<a href="${context }/member.do"><img src="${img }/member.png" alt="member" style="width:30px" /></a>
	<a href="${context }/global.do"><img src="${img }/home.png" alt="home" style="width:30px" /></a>
	</div>
