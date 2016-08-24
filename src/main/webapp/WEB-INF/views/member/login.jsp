<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="text-align: center">
		<form action="${context }/member.do" method="post">
			<span class="meta">ID</span><input type="text" name="id"/><br/>
			<span class="meta">비밀번호</span><input type="password" name="pw"/><br/><br/>
			<input type="hidden" name="directory" value="global" />
			<input type="hidden" name="action" value="login" />
			<input type="submit" value="로그인" />
			<input type="reset" value="취소">
		</form> <br/>
	<a id="member_content_a_home"><img id="member_content_img_home"/></a>
</div>
