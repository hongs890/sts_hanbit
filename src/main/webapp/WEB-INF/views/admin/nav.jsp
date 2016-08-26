<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="admin_nav" class="nav nav-tabs">
  <li role="presentation" class="dropdown">
  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Member Manage <span class="caret"></span></a>
   <ul id="member_mgmt" class="dropdown-menu">
		<li><a id = "list">List</a></li>
		<li><a id = "find_by">Search</a></li>
		<li><a id = "count">Count</a></li>
    </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Grade Manage<span class="caret"></span></a>
     <ul id="grade_mgmt" class="dropdown-menu">
		<li><a href="#" id="g_regist">등록</a></li>
		<li><a href="#" id="g_update">수정</a></li>
		<li><a href="#" id="g_delete">삭제</a></li>
		<li><a href="#" id="g_list">목록</a></li>
		<li><a href="#" id="g_count">카운트</a></li>
		<li><a href="#" id="g_find">검색</a></li>
    </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Account Manage <span class="caret"></span></a>
   <ul id="account_mgmt" class="dropdown-menu">
		<li><a id ="open">Open Account</a></li>
		<li><a id ="list">Show list</a></li>
		<li><a id ="find">Search</a></li>
		<li><a id ="count">Count</a></li>
    </ul>
  </li>
</ul>