<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
	<form class="navbar-form navbar-left" role="search">
		<div class="form-group">
		<div class="col-lg-12">
		<select style='width:100px;height:30px'>
  			<option value="id">ID</option>
  			<option value="name">Username</option>
  			<option value="gender">Account No</option>
		</select>
     	<input type="text" class="form-control"/>
    	<input type="hidden" name="action" value="find_by_id" />
		<input type="hidden" name="page" value="find_by_id" />
		<button type="submit" class="btn btn-primary">SEARCH</button>
	  	</div>
	  	</div>
	</form>	
</div>