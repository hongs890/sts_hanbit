<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="member_login">
<div><img id="member_login_img"></div>
<div>
<form id="member_login_form" action="eqweqweq">
<h1>Login</h1><br/>
	<div><label for="exampleInputEmail1">ID</label><div><input type="text" name="id"></div></div>
	<div><label for="exampleInputEmail1">PW</label><div><input type="text" name="pw"></div></div>
		<input type="hidden" name="context">
		<input id="bt_login" type="submit" value="Login" />
		<input id="bt_cancel" type="reset" value="Cancel" />
</form>
</div>
</section>
<script type="text/javascript">
$(function(){
	$('#member_login_form').attr('method','post').attr('action',app.context()+'/member/login')
	$('#member_login_form input[type="hidden"]').attr('value',app.context());
	$('#member_login_form input[type="submit"]').click(function(){('#member_login_form').submit();})
});
</script>