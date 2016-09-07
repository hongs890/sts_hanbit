<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box_left">
<div class="month">
  <ul>
    <li class="prev">❮</li>
    <li class="next">❯</li>
    <li style="text-align:center">
      August<br>
      <span style="font-size:18px">2016</span>
    </li>
  </ul>
</div>

<ul class="weekdays">
  <li>Mo</li>
  <li>Tu</li>
  <li>We</li>
  <li>Th</li>
  <li>Fr</li>
  <li>Sa</li>
  <li>Su</li>
</ul>

<ul class="days">
  <li>1</li>
  <li>2</li>
  <li>3</li>
  <li>4</li>
  <li>5</li>
  <li>6</li>
  <li>7</li>
  <li>8</li>
  <li>9</li>
  <li><span class="active">10</span></li>
  <li>11</li>
  <li>12</li>
  <li>13</li>
  <li>14</li>
  <li>15</li>
  <li>16</li>
  <li>17</li>
  <li>18</li>
  <li>19</li>
  <li>20</li>
  <li>21</li>
  <li>22</li>
  <li>23</li>
  <li>24</li>
  <li>25</li>
  <li>26</li>
  <li>27</li>
  <li>28</li>
  <li>29</li>
  <li>30</li>
  <li>31</li>
</ul>
</div>
<div class="box">
	<form class="navbar-form navbar-center" role="search">
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
		<input  type="submit" class="btn btn-primary" value="search" />
	  	</div>
	  	</div>
	</form>	
</div>