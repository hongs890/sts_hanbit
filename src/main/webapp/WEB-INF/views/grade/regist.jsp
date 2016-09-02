<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="grade_regist">
<div>
<img id="grade_regist_img">
</div>
<div>

<form id="grade_regist_form">
<table id="subject_detail">
		<tr>
			<td rowspan="4" style="width:30%">
			<img src="${img}/member/hong.jpg" alt="W3Schools.com" width="200" height="200"></td>
			<td style="width:20%" class="font_bold bg_color_yellow">Name</td>
			<td style="width:20%" class="font_bold bg_color_yellow">홍길동</td>
		</tr>
		<tr><td class="font_bold bg_color_yellow">Gender</td>
			<td class="font_bold bg_color_yellow">남</td>
		</tr>
		<tr>
		<td class="font_bold bg_color_yellow">Major</td>
			<td class="font_bold bg_color_yellow">Computer</td>
		</tr>
		<tr>	
		<td class="font_bold bg_color_yellow">Level</td>
		<td class="font_bold bg_color_yellow">3</td>
		</tr>
	</table><br/>
	 	<div><label for="exampleInputEmail1">Java</label><div><input type="text" id="id"></div></div>
      	<div><label for="exampleInputEmail1">Javascript</label><div><input type="text" id="javascript"></div></div>
		<div><label for="exampleInputEmail1">SQL</label><div><input type="text" id="SQL"></div></div>
		<div><label for="exampleInputEmail1">HTML</label><div><input type="text" id="HTML"></div></div>
		<input type="hidden" name="action" value="regist">
		<input type="hidden" name="page" value="login">
		<input id="bt_join" type="submit" value="Submit" />
		<input id="bt_cancel" type="reset" value="Cancel" />
	</form>	
</div>
</section>
