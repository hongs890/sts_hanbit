<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" style="height:50px;">
  <div class="container-fluid">
    <div class="navbar-header">
   <a href="#" id="title"><img id="header_brand"></a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
       <li><a id="a_free_board">Free Board</a></li>
        <li><a id="a_school">Intro</a></li>
         <li><a href="#">Map</a></li>
         <li><a id="test">Test</a></li>
        <li class="dropdown">
          </ul>
    </div>
  </div>
</nav>
<script type="text/javascript">
$(function(){
	$('#test').click(function(){controller.move('public','slider')});
	
});
</script>