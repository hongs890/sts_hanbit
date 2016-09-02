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
<script type="text/javascript">
$(function(){
	$('#grade_regist').addClass('media').addClass('text_center').css('font-size','30px');
	$('#grade_regist > div').css('float','left').css('width','50%');
	$('#grade_regist > div > div').css('float','right').css('width','50%');
	$('#grade_regist_img').attr('src',app.img()+'/grade.jpg').addClass('media-object').css('height','50%').css('width','70%').css('margin-left','15%').css('margin-top','5%');
	$('#grade_regist span').addClass('float_left').addClass('text_left').css('width','200px');
	$('#grade_regist #bt_join').addClass('btn').addClass('btn-warning');
	$('#grade_regist #bt_cancel').addClass('btn').addClass('btn-warning');
	$('#grade_regist_form').addClass('form-horizontal').css('margin-top','7%').css('margin-right','20%');
	$('#grade_regist_form > div').addClass('form-group').addClass('form-group-lg');
	$('#grade_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
	$('#grade_regist_form > div > div').addClass('col-sm-10');
	$('#grade_regist_form > div > div > input').addClass('form-control');
});
</script>

