<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <section id="member_login">
	<img id="member_login_img">
		<form id="member_login_form">
		<div><label for="exampleInputEmail1">ID</label><div><input type="text"></div></div>
		<div><label for="exampleInputEmail1">Password</label><div><input type="text"></div></div>
			<input type="hidden" name="directory" value="global" />
			<input type="hidden" name="action" value="login" />
			<input id="bt_login" type="submit" value="로그인" />
			<input id="bt_cancel" type="reset" value="취소" />
		</form>
</section>


