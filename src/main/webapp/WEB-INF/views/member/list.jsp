<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath() %>"/>
<section class="text_center box" style="width:80%">
<ul class="list-group">
  <li class="list-group-item">총학생수 : ${totCount}</li>
</ul>
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
  
  <tbody>
  <c:forEach items="${list}" var="member">
 	 <tr>
      <td>${member.id}</td>
      <td><a class="name">${member.name}</a></td>
      <td>${member.regDate}</td>
      <td>${member.ssn}</td>
      <td>${member.email}</td>
      <td>${member.phone}</td>
      <td><a class="regist"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a>　　/　　<a class="update"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></td>
    </tr>
</c:forEach>
    </tbody>
    </table>
 <nav aria-label="Page navigation">
  <ul class="pagination">
  <c:if test="${startPg - pgSize gt 0 }">
  	<li>
  	<a href="${context}/member/list/${startPg-pgSize}" aria-label="Previous">
  		<span aria-hidden="true">&laquo;</span>
  	</a>
  	</li>
  </c:if>
  <c:forEach begin="${startPg}" end="${lastPg}" step="1" varStatus="i">
  	<c:choose>
  		<c:when test="${i.index == pgNum }">
  			<font color="red">${i.index}</font>
  		</c:when>
  		<c:otherwise>
  			<a href="${context}/member/list/${i.index}">${i.index}</a>
  		</c:otherwise>
  	</c:choose>
  </c:forEach>
 <c:if test="${startPg + pgSize le totPg}">
  <li>
  <a href="${context}/member/list/${startPg-pgSize}" aria-label="Next">
  	<span aria-hidden="true">&laqui;</span>
  </a>
 </li>
</c:if>
</ul>
</nav>
<div align="center">
	<form action="${context}/member/search" method="post">
		<select name="keyField" id="">
			<option value="name" selected>이름</option>
			<option value="mem_id">ID</option>
		</select>
		<input type="text" name="keyword" />
		<input type="hidden" name="pgNum" />
		<input type="submit" name="검 색" />
	</form>
</div>
</section>
