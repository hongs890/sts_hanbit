<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="user_header" class="navbar navbar-default" style="height:50px;">
  <div class="container-fluid">
    <div class="navbar-header">
     <a href="#" id="user_title"><img id="header_brand"></a>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li id="grade" class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Grade Manage <span class="caret"></span></a>
          <ul  class="dropdown-menu">
            <li><a href="#">Recntly Grade</a></li>
            <li><a href="#">Past Grade</a></li>
          </ul>
        </li>
         <li id="account" class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account Manage <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Account Detail</a></li>
            <li><a href="#">Account Create</a></li>
            <li><a href="#">Account Transaction</a></li>
            <li><a href="#">Account Delete</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
<li style="text-align:right; margin-top:14px;">${user.name} Welcome!</li>
 <li><a id="exit"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Logout</a></li>
    <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a id="detail">My Page</a></li>
            <li><a id="delete">Delete Account</a></li>
          </ul>
        </li>
          </ul>
    </div>
  </div>
</nav>