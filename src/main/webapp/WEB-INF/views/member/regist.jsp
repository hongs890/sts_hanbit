<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="member_regist">
	<form id="member_regist_form">
	 	<div><label for="exampleInputEmail1">Name</label><div><input type="text" id="username"></div></div>
	 	<div><label for="exampleInputEmail1">ID</label><div><input type="text" id="id" ></div></div>
	 	<div><label for="exampleInputEmail1">SSN</label><div><input type="text" id="pw" ></div></div>
	 	<div><label for="exampleInputEmail1">Password</label><div><input type="text" id="ssn" ></div></div>
	 	<div><label for="exampleInputEmail1">E-Mail</label><div><input type="text" id="email"></div></div>
	 	<div><label for="exampleInputEmail1">Phon</label><div><input type="text" id="phone"></div></div>
		<div><label for="exampleInputEmail1">전공</label><div>
		<div id="rd_major">
		<label><input type="radio" name="major" value="computer" checked>컴퓨터공학부</label>
		<label><input type="radio" name="major" value="mgmt">경영학부</label>
		<label><input type="radio" name="major" value="math">수학부</label>
		<label><input type="radio" name="major" value="eng">영문학부</label><br/><br/></div></div></div>
      	<div><label for="exampleInputEmail1">수강과목</label><div>
        <div id="ck_subject">
        <label><input type="checkbox" name="subject" value="java"> Java </label>
		<label><input type="checkbox" name="subject" value="sql"> SQL </label>
		<label><input type="checkbox" name="subject" value="cpp"> C++ </label>
		<label><input type="checkbox" name="subject" value="phython"> Phython </label>
		<label><input type="checkbox" name="subject" value="delphi"> Delphi </label>
		<label><input type="checkbox" name="subject" value="html"> HTML </label><br/><br/></div></div></div>
		<input type="hidden" name="action" value="regist">
		<input type="hidden" name="directory" value="global">
		<input id="bt_join" type="submit" value="회원가입" />
		<input id="bt_cancel" type="reset" value="취소" />
	</form>	
	<a id="member_content_a_home"><img id="member_content_img_home"/></a>
</section>
