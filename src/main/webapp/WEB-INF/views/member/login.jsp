<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="member_login">
<div>
<img id="member_login_img">
</div>
<div>

<form id="member_login_form">
<h1>Login</h1><br/>
		<div><label for="exampleInputEmail1">ID</label><div><input type="text"></div></div>
		<div><label for="exampleInputEmail1">PW</label><div><input type="text"></div></div>
			<input type="hidden" name="directory" value="global" />
			<input type="hidden" name="action" value="login" />
			<input id="bt_login" type="submit" value="Login" />
			<input id="bt_cancel" type="reset" value="Cancel" />
		</form>
</div>
</section>