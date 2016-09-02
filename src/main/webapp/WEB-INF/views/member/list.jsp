<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="text_center">
<table id="subject_detail">
		<tr>
			<td rowspan="4" style="width:30%">
			<img src="${img}/member/hong.jpg" alt="W3Schools.com" width="200" height="200"></td>
			<td style="width:20%" class="font_bold bg_color_yellow">Name</td>
			<td style="width:20%" class="font_bold bg_color_yellow">홍길동</td>
		</tr>
		<tr><td class="font_bold bg_color_yellow">Major</td>
			<td class="font_bold bg_color_yellow">Computer</td>
		</tr>
	</table>
<h1>Member Detail</h1>  
<table id="member_list_table">
     <tr>
      <th>ID</th>
      <th>NAME</th>
      <th>REGIST DATE</th>
      <th>BIRTH</th>
      <th>Email</th>
      <th>PHONE</th>
      <th>GRADE<br/>REGIST/UPDATE </th>
    </tr>
  <tr>
      <td>hong</td>
      <td><a class="name">홍길동</a></td>
      <td>2016-01-01</td>
      <td>1989-02-22</td>
      <td>hongs890@gmail.com</td>
      <td>010-7143-0222</td>
      <td><a class="regist"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a>　　/　　<a class="update"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></td>
    </tr>
    </table>
    <nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</section>

<script type="text/javascript">
$(function(){
	$('#member_list_table .name').click(function(){controller.moveWithKey('member','a_detail','hong');});
	$('#member_list_table .regist').click(function(){controller.moveWithKey('grade','regist','hong');});
	$('#member_list_table .update').click(function(){controller.moveWithKey('grade','update','hong');});
});
</script>
