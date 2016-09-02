<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="admin_header" class="navbar navbar-default" style="height:50px;">
  <div class="container-fluid">
    <div class="navbar-header">
 
    <ul class="nav navbar-nav navbar-left">
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
		<li><a href="#" id="g_regist">Regist</a></li>
		<li><a href="#" id="g_update">Update</a></li>
		<li><a href="#" id="g_delete">Delete</a></li>
		<li><a href="#" id="g_list">List</a></li>
		<li><a href="#" id="g_count">Count</a></li>
		<li><a href="#" id="g_find">Search</a></li>
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
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        
   
        <li><a id="exit"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Logout</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Change Admin Password</a></li>
          </ul>
        </li>
         <img id="header_admin_img">
      </ul>
      
    </div>
  </div>
</nav>
<script type="text/javascript">
$(function(){
	$('#g_regist').click(function(){alert('등록을 위해 회원리스트로 이동합니다.'); controller.move('member','list');});	
	$('#g_update').click(function(){alert('수정을 위해 회원리스트로 이동합니다.'); controller.move('member','list');});	
	$('#g_list').click(function(){controller.move('grade','list');});	
});
</script>
