<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="member_regist">
<div>
<img id="member_regist_img">
</div>
<div>
<h1>Sign Up</h1>
<form id="member_regist_form">
	 	<div><label for="exampleInputEmail1">Name</label><div><input type="text" id="username"></div></div>
	 	<div><label for="exampleInputEmail1">ID</label><div><input type="text" id="id" ></div></div>
	 	<div><label for="exampleInputEmail1">SSN</label><div><input type="text" id="pw" ></div></div>
	 	<div><label for="exampleInputEmail1">Password</label><div><input type="text" id="ssn" ></div></div>
	 	<div><label for="exampleInputEmail1">E-Mail</label><div><input type="text" id="email"></div></div>
	 	<div><label for="exampleInputEmail1">Phone</label><div><input type="text" id="phone"></div></div>
		<div><label for="exampleInputEmail1">Major</label><div>
		<div id="rd_major">
		<label><input type="radio" name="major" value="computer" checked>Computer</label>
		<label><input type="radio" name="major" value="mgmt">Manage</label>
		<label><input type="radio" name="major" value="math">Math</label>
		<label><input type="radio" name="major" value="eng">English</label></div></div></div>
      	<div><label for="exampleInputEmail1">Subject</label><div>
      	<div id="ck_subject">
        <label><input type="checkbox" name="subject" value="java"> Java </label>
		<label><input type="checkbox" name="subject" value="sql"> SQL </label>
		<label><input type="checkbox" name="subject" value="cpp"> C++ </label>
		<label><input type="checkbox" name="subject" value="phython"> Phython </label>
		<label><input type="checkbox" name="subject" value="delphi"> Delphi </label>
		<label><input type="checkbox" name="subject" value="html"> HTML </label><br/></div></div></div>
		<input type="hidden" name="action" value="regist">
		<input type="hidden" name="directory" value="global">
		<input id="bt_join" type="submit" value="Submit" />
		<input id="bt_cancel" type="reset" value="Cancel" />
	</form>	
</div>
</section>