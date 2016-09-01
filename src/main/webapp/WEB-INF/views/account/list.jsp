<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
<div class="panel panel-default">
  <div class="panel-heading">Account List</div>
  <div class="panel-body">
  </div>
<table id="member_list" class="table">
	<tr>
	    <td>ID</td>
	    <td>Username</td>
	    <td>Account No</td>
	    <td>Balance</td>
	</tr>
	<c:forEach var="member" items="${list}">
	<tr>
	    <td>${account.id}</td>
	    <td>${account.name}</td>
	    <td>${account.accountNo}</td>
	    <td>${account.money}</td>
	</tr>
	</c:forEach>
</table>
</div>


	<a id="member_content_a_member"><img id="member_content_img_member"/></a>
	<a id="member_content_a_home"><img id="member_content_img_home"/></a>
</div>

