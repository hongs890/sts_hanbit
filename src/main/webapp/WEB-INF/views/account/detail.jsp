<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css" href="${css}/table1.css"> 
	<link rel="stylesheet" type="text/css" href="${css}/table2.css">  
	<div class="box">
<section class="text_center">
<table id="subject_detail">
		<tr>
			<td rowspan="4" style="width:30%">
			<img src="${img}/member/hong.jpg" alt="W3Schools.com" width="200" height="200"></td>
			<td style="width:20%" class="font_bold bg_color_yellow">홍길동</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">신한은행</td>
		</tr>
		<tr>
			<td class="font_bold bg_color_yellow">110-429-156739</td>
		</tr>
		<tr>	
			<td class="font_bold bg_color_yellow">601,000</td>
		</tr>
	</table><br/><br/><br/>
<h1>Account Detail</h1>  
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>Date</th>
      <th>Deposit</th>
      <th>Withdraw</th>
      <th>Balance</th>
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0">
  <tbody>
    <tr>
      <td>2016-05-01</td>
      <td>5,000 </td>
      <td>3,000</td>
      <td>2,000</td>
    </tr>
    <tr>
      <td>2016-06-04</td>
      <td>0</td>
      <td>1,000</td>
      <td>1,000</td>
    </tr>
    <tr>
      <td>2016-06-05</td>
      <td>1,000,000</td>
      <td>0</td>
      <td>1,001,000</td>
    </tr>
    <tr>
      <td>2016-06-08</td>
      <td>500,000</td>
      <td>0</td>
      <td>1,501,000</td>
    </tr>
        <tr>
      <td>2016-06-08</td>
      <td>0</td>
      <td>100,000</td>
      <td>1,401,000</td>
    </tr>
        <tr>
      <td>2016-06-08</td>
      <td>0</td>
      <td>500,000</td>
      <td>901,000</td>
    </tr>
        <tr>
      <td>2016-06-24</td>
      <td>0</td>
      <td>100,000</td>
      <td>801,000</td>
    </tr>
       <tr>
      <td>2016-07-24</td>
      <td>0</td>
      <td>100,000</td>
      <td>701,000</td>
    </tr>
       <tr>
      <td>2016-07-24</td>
      <td>0</td>
      <td>100,000</td>
      <td>601,000</td>
    </tr>
  </tbody>
</table>
</div>
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

</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="${js}/table.js"></script>

