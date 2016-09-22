/*
===================== META_GROUP =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 
@ UPDATE DATE : 
@ DESC : 메타데이터
=================================================
*/
var app = (function(){
	var init = function(context){member.init();session.init(context);user.init();grade.init();navi.init();admin.init();onCreate();};
	var context = function(){return session.getContextPath();};
	var js = function(){return sessionStorage.getItem('js');};
	var css = function() {return sessionStorage.getItem('css');};
	var img = function() {return sessionStorage.getItem('img');};
	var setContentView = function(){
		$('#header_brand').attr('src',app.img()+'/mark.png').css('height','50px').css('width','50px').css('alt','Brand');
		$('#header_admin_img').attr('src',app.img()+'/admin.png').css('height','50px').css('width','50px');
		$('#footer').addClass('footer');
		$('#global_content').addClass('media').addClass('text_center').css('font-size','30px');
		$('#global_content > div').css('float','left').css('width','50%');
		$('#global_content > div > div').css('float','right').css('width','50%');
		$('#global_content_img').attr('src',app.img()+'/main.png').addClass('media-object').css('height','70%').css('width','100%').css('margin-top','5%');
		$('#global_content h2').addClass('media-heading').css('font-size','50px').css('margin-top','200px').css('margin-left','50px').text('HANBIT ACADEMY');
		$('#global_content h4').text('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, ');
		$('#global_content a').addClass('cursor_pointer');
		$('#global_content_a_regist').addClass('btn').addClass('btn-warning').text('Sign Up').click(function(){member.pub_regist()});
		$('#global_content_a_login').addClass('btn').addClass('btn-warning').text('Login').click(function(){member.pub_login_form()});
		$('#global_content_a_admin').addClass('btn').addClass('btn-warning').text('Admin').click(function(){admin.check()});};
	var onCreate = function() {
		setContentView();
		$('#title').click(function(){controller.home();});
		$('#a_member').click(function(){controller.move('member','main');});
		$('#a_grade').click(function(){controller.move('grade','main');});
		$('#a_account').click(function(){controller.move('account','main');});
		$('#a_map').click(function(){controller.move('public','contact');});
		$('#a_free_board').click(function(){controller.move('public','free_board');});
		$('#a_school').click(function(){controller.move('public','school_info');});}
	return {init:init, context : context,css : css,js : js,img : img,onCreate : onCreate}})();
var util = (function(){
	return{
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		},
		pwChecker : function(value){
			var pw_regex =  /^[a-zA-Z0-9]{4,10}$/;
			return pw_regex.test(value)?"yes":"no";
		}
}
})();
var session = (function(){
	var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img/default');
		};
	var getContextPath = function(){return sessionStorage.getItem('context')};
	return{init:init, getContextPath:getContextPath}
})();

var controller = (function(){
	var _page, _directory, _key;
	var setPage = function(page){this._page = page;};
	var setDirectory = function(directory){this._directory = directory;};
	var setKey = function(key){this._key = key;};
	var getPage = function(){return this._page};
	var getDirectory = function(){return this._directory};
	var getKey = function(){return this._key};
	return{setPage : setPage,setDirectory : setDirectory,getPage : getPage,getDirectory : getDirectory, setKey : setKey, getKey : getKey,
		moveWithKey : function(directory,page,key){
			setDirectory(directory);setPage(page);setKey(key);
			location.href=app.context()+'/'+getDirectory()+'/'+getPage()+'?key='+getKey();
		},
		move : function(directory,page){
			setDirectory(directory);setPage(page);
			location.href=app.context()+'/'+getDirectory()+'/'+getPage();
		},
		home : function() {location.href=app.context()+'/';}
	};
})();
var navi = (function(){
	var init = function(){onCreate();};
	var setContentView = function (){
		$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bgcolor_676767').css('margin','0').css('padding','0');
		$('#nav li').addClass('float_left');
		$('#nav li a').addClass('text_center').addClass('remove_underline').addClass('_white').addClass('display_block').css('padding','14px 16px');
		$('#nav li a:hover:not(.active)').addClass('bgcolor_white').css('font-weight','bold');
	};
	var onCreate = function (){
		setContentView();
	};
	return{init:init};
})();
/*
===================== MAJOR_JS =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 
@ UPDATE DATE : 
@ DESC : 전공
=================================================
*/
var major = (function(){})();
/*
===================== MEMBER_JS =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 
@ UPDATE DATE : 
@ DESC : 회원 (가입,로그인)
=================================================
*/
var login_form = '<section id="member_login">'
	+'<div><img id="member_login_img"></div>'
	+'<div>'
	+'<form id="member_login_form">'
	+'<h1>Login</h1><br/>'
	+'<div><label for="exampleInputEmail1">ID</label><div><input type="text" id="id" name="id"></div></div>'
	+'<div><label for="exampleInputEmail1">PW</label><div><input type="text" id="pw" name="pw"></div></div>'
	+'<input type="hidden" name="context">'
	+'<input id="bt_login" type="submit" value="Login" />'
	+'<input id="bt_cancel" type="reset" value="Cancel" />'
	+'</form>'
	+'</div>'
	+'</section>';
var sign_up_form = '<section id="member_regist">'
	+'<div>'
	+'<img id="member_regist_img">'
	+'</div>'
	+'<div>'
	+'<h1>Sign Up</h1>'
	+'<form id="member_regist_form">'
	+'<div><label for="exampleInputEmail1">ID</label><div id="id_box"><input type="text" id="id" placeholder=" "><input type="button" id="check_dup" value="중복확인"></div></div>'
	+'<div><label for="exampleInputEmail1">Password</label><div><input type="text" id="pw" ></div></div>'
	+'<div><label for="exampleInputEmail1">Check Password</label><div><input type="text" id="check_pw" ><label id="check_pw_text"></label></div></div>'
	+'<div><label for="exampleInputEmail1">Name</label><div><input type="text" id="username"></div></div>'
	+'<div><label for="exampleInputEmail1">SSN</label><div><input type="text" id="ssn" ></div></div>'
	+'<div><label for="exampleInputEmail1">E-Mail</label><div><input type="text" id="email"></div></div>'
	+'<div><label for="exampleInputEmail1">Phone</label><div><input type="text" id="phone"></div></div>'
	+'<div><label for="exampleInputEmail1">Major</label><div>'
	+'<div id="rd_major">'
	+'<label><input type="radio" name="major" value="computer" checked>Computer</label>'
	+'<label><input type="radio" name="major" value="mgmt">Manage</label>'
	+'<label><input type="radio" name="major" value="math">Math</label>'
	+'<label><input type="radio" name="major" value="eng">English</label></div></div></div>'
	+'<div><label for="exampleInputEmail1">Subject</label><div>'
	+'<div id="ck_subject">'
	+'<label><input type="checkbox" name="subject" value="java"> Java </label>'
	+'<label><input type="checkbox" name="subject" value="sql"> SQL </label>'
	+'<label><input type="checkbox" name="subject" value="cpp"> C++ </label>'
	+'<label><input type="checkbox" name="subject" value="phython"> Phython </label>'
	+'<label><input type="checkbox" name="subject" value="delphi"> Delphi </label>'
	+'<label><input type="checkbox" name="subject" value="html"> HTML </label><br/></div></div></div>'
	+'<input id="bt_join" type="submit" value="Submit" />'
	+'<input id="bt_cancel" type="reset" value="Cancel" />'
	+'</form>'
	+'</div>'
	+'</section>';
var member = (function(){
	var _ssn, _name, _gender, _age;
	var setAge = function(age){this._age=age;}
	var setGender = function(gender){this._gender=gender;}
	var setSsn = function(ssn){this._ssn=ssn;}
	var setName = function(name){this._name=name;}
	var getAge = function(){return this._age;}
	var getGender = function(){return this._gender;}
	var getSsn = function(){return this._ssn;}
	var getName = function(){return this._name;}
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member_content').addClass('text_center').css('font-size','20px');
		$('#member_content > article').css('width','300px').addClass('center').addClass('text_left');
		$('#member_content a').css('font-size','15px').addClass('cursor_pointer');
		$('#member_content > h1').text('Member Management');
		$('#member_content_ol > li:first > a').text('Sign Up').addClass('remove_underline');
		$('#member_content_ol > li:nth(1) > a').text('My Page').addClass('remove_underline');
		$('#member_content_ol > li:nth(2) > a').text('Update').addClass('remove_underline');
		$('#member_content_ol > li:nth(3) > a').text('Delete account').addClass('remove_underline');
		$('#member_content_ol > li:nth(4) > a').text('Login').addClass('remove_underline');
		$('#member_content_ol > li:nth(5) > a').text('Logout').addClass('remove_underline');
		$('#member_content_ol > li:nth(6) > a').text('List').addClass('remove_underline');
		$('#member_content_ol > li:nth(7) > a').text('Search').addClass('remove_underline');
		$('#member_content_ol > li:nth(8) > a').text('Count').addClass('remove_underline');
		$('#member_regist').addClass('media').addClass('text_center').css('font-size','30px');
		$('#member_regist > div').css('float','left').css('width','50%');
		$('#member_regist > div > div').css('float','right').css('width','50%');
		$('#member_regist_img').attr('src',app.img()+'/main.png').addClass('media-object').css('height','70%').css('width','100%').css('margin-top','5%');
		$('#member_regist span').addClass('float_left').addClass('text_left').css('width','200px');
		$('#member_regist #bt_join').addClass('btn').addClass('btn-warning');
		$('#member_regist #bt_cancel').addClass('btn').addClass('btn-warning');
		$('#member_regist #check_dup').addClass('btn').addClass('btn-warning');
		$('#member_regist_form').addClass('form-horizontal').css('margin-top','5%').css('margin-right','20%');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#rd_major > label').css('font-size','20px');
		$('#ck_subject > label').css('font-size','15px');
		$('#member_login').addClass('media').addClass('text_center').css('font-size','30px');
		$('#member_login > div').css('float','left').css('width','50%');
		$('#member_login > div > div').css('float','right').css('width','50%');
		$('#member_login_img').attr('src',app.img()+'/main.png').addClass('media-object').css('height','70%').css('width','100%').css('margin-top','5%');
		$('#member_login #bt_login').addClass('btn').addClass('btn-warning');
		$('#member_login #bt_cancel').addClass('btn').addClass('btn-warning');
		$('#member_login_form').addClass('form-horizontal').css('margin-top','25%').css('margin-left','20%').css('margin-right','30%');
		$('#member_login_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_login_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_login_form > div > div').addClass('col-sm-10');
		$('#member_login_form > div > div > input').addClass('form-control');
		$('#member_find_form').attr('action',app.context()+'/member/search')
		$('#member_find_form input[type="hidden"]').attr('name','context').attr('value',app.img());
		$('#member_login_form input[type="hidden"]').attr('value',app.context());
	};
	var onCreate = function(){
		setContentView();
		$('#regist').click(function(){controller.move('member','regist');})
		$('#detail').click(function(){controller.move('member','detail');})
		$('#update').click(function(){controller.move('member','update');})
		$('#delete').click(function(){controller.move('member','delete');})
		$('#login').click(function(){controller.move('member','login');})
		$('#logout').click(function(){controller.move('member','logout');})
		$('#list').click(function(){controller.move('member','list');})
		$('#find_by').click(function(){controller.move('member','find_by');})
		$('#count').click(function(){controller.move('member','count');})
		$('#member_content_a_member').click(function(){controller.move('member','main')});
		$('#member_content_a_home').click(function(){controller.home()});
		$('#member_find_form input[type="submit"]').click(function(){('#member_find_form').submit();})
		$('#member_list_table .name').click(function(){controller.moveWithKey('member','a_detail','hong');});
		$('#member_list_table .regist').click(function(){controller.moveWithKey('grade','regist','hong');});
		$('#member_list_table .update').click(function(){controller.moveWithKey('grade','update','hong');});
	
	};
	return{
		init:init, setAge : setAge,setGender : setGender,setSsn : setSsn,setName : setName,getAge : getAge,getGender : getGender,getSsn : getSsn,getName : getName,
		spec : function(){
			setName(document.querySelector('#name').value);
			setSsn(document.querySelector('#ssn').value);
			var now = new Date().getFullYear();
			var ssnArr = getSsn().split("-");
		    var ageResult1 =ssnArr[0];
		    var genderResult = ssnArr[1].toString().substring(0, 1);
		    var ageResult0 = 0;
		     switch (genderResult) {
		         case "1": case "5":
		        	 setAge(now-(1899+(ageResult1 /10000)));
		             setGender("남");
		             break;
		         case "3": case "7":
		        	setAge(now-(1999+(ageResult1 /10000)));
		            setGender("남");
		         break;
		         case "2": case "6":
		        	 setAge(now-(1899+(ageResult1 /10000)));
		             setGender("여");
		         break;
		         case "4": case "8":
		             setAge(now-(1999+(ageResult1 /10000)));
		             setGender("여");
		         break;
		    }
		     document.querySelector('#result_name').innerHTML =getName();
		     document.querySelector('#result_gender').innerHTML = getGender();
		     document.querySelector('#result_age').innerHTML = Math.floor(getAge());
		},
		pub_login_form : function(){
			$('#pub_article').html(login_form);
			member.init();
			$('#bt_login').click(function(e){
				e.preventDefault();
				$.ajax({
					url : app.context()+'/member/login',
					type : 'POST',
					data : {'id':$('#id').val(),'pw':$('#pw').val()},
					dataType : 'json',
					success : function(data){
						member.init();
						if (data.id === 'fail') {
							alert('ID나 비밀번호가 일치하지 않습니다.');
						}else{
							$('#pub_article').html(student_main);
							$('#pub_header').empty().load(app.context()+'/member/logined/header');
							$('#pub_header').on('click','#exit',function(){location.href = app.context()+'/member/logout';});
						}
					},
				error : function(xhr,status,msg){
				alert('로그인 실패 이유 : '+msg);
				}
			});
		});
	},
		pub_regist : function(){
			$('#pub_article').html(sign_up_form);
			member.init();
			$('#check_dup').click(function(){
				if (util.pwChecker($('#id').val()) === 'yes') {
					alert('정규식 성공');
					$.ajax({
						url : app.context()+'/member/check_dup/'+$('#id').val(),
						success : function(data){
							if (data.flag === "TRUE") {
								$('#id_box').html('<input type="text" id="id" placeholder="'+data.message+'"><input type="button" id="check_dup" value="다시조회">');
								member.init();
							} else {
								$('#id_box').html('<input type="text" id="id" value="'+data.temp+'"><input type="button" id="check_dup" value="그대로사용">');
								member.init();
								$('#bt_join').click(function(e){
									e.preventDefault();
										var join_info = {
										'id' : $('#id').val(),
										'pw' : $('#pw').val(),
										'name' : $('#username').val(),
										'ssn' : $('#ssn').val(),
										'email' : $('#email').val(),
										'phone' : $('#phone').val()
									/*	$('#radio').val();
										$('#ck_subject').val();*/
									};
									
									$.ajax({
										url : app.context()+'/member/signup',
										type : 'post',
										contentType : 'application/json',
										data : JSON.stringify(join_info),
										dataType : 'json',
										success : function(data){
											if (data.message === "success") {
												alert('회원가입이 완료되었습니다.');
												member.pub_login_form();
											}else{
												alert('회원가입시 알 수 없는 에러가 발생했습니다.');
											}
										},
										error : function(x,s,m){
											alert('회원가입시 에러 발생');
										}
									});
								});
							}
						},
						error : function(x,s,m){
							alert('id 중복체크시 발생한 에러 : ' + m);
						}
					});
				}else{
					alert('정규식 실패');
					$('#id').val('').focuson();
				}
			});
			
			
			$('#check_pw').keyup(function(){
			if ($('#check_pw').val().length >= $('#pw').val().length) {
				if ($('#pw').val() !== $('#check_pw').val()) {
				$('#check_pw_text').html('<font size="2px" color="red">비밀번호가 일치하지 않습니다</font>');
				}else{
				$('#check_pw_text').html('<font size="2px" color="blue">비밀번호가 일치합니다</font>');
				}
			}
			});
			
	
		}
	};
})();
/*
===================== STUDENT_JS =====================
@ AUTHOR : hongs890@gmail.com
@ CREATE DATE : 2016-9-8
@ UPDATE DATE : 2016-9-20
@ DESC : 학생
=================================================
*/
var student_main = 
	'<link rel="stylesheet" type="text/css" href="'+app.css()+'/normalize.css">'
	+'<link rel="stylesheet" type="text/css" href="'+app.css()+'/owl.css">'
	+'<link rel="stylesheet" type="text/css" href="'+app.css()+'/animate.css">'
	+'<link rel="stylesheet" type="text/css" href="'+app.css()+'/cardio.css">'
	+'<link rel="stylesheet" type="text/css" href="'+app.css()+'/et-icons.css">'
	+'<section id="user_content" class="section section-padded">'
	+'<div class="container">'
	+'<video autoplay="" loop="" class="fillWidth fadeIn wow collapse in" data-wow-delay="0.5s" poster="https://s3-us-west-2.amazonaws.com/coverr/poster/Traffic-blurred2.jpg" id="video-background">'
	+'<source src="https://s3-us-west-2.amazonaws.com/coverr/mp4/Traffic-blurred2.mp4" type="video/mp4">Your browser does not support the video tag. I suggest you upgrade your browser.'
	+'</video>'
	+'<div class="row text-center title">'
	+'<h2 class="light muted">Services</h2>'
	+'<h4 class="light muted">Achieve the best results with our wide variety of training options!</h4>'
	+'</div>'
	+'<div class="row services">'
	+'<div class="col-md-4">'
	+'<div id="kaup" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+app.img()+'/icons/kaup.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">KAUP</h4>'
	+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id="rockSissorPaper" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+app.img()+'/icons/rock.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">ROCK SISSOR PAPER</h4>'
	+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id ="lotto" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+app.img()+'/icons/lotto.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">LOTTO DRAWING</h4>'
	+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id="major_subject_1" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+app.img()+'/icons/java.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">JAVA</h4>'
	+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
	+'<input type="hidden" name="major_subject_1" value="java">'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id="major_subject_2" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+app.img()+'/icons/javascript.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">JAVA SCRIPT</h4>'
	+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
	+'<input type="hidden" name="major_subject_2" value="javascript">'
	+'</div>'
	+'</div>'
	+'<div class="col-md-4">'
	+'<div id="major_subject_3" class="service">'
	+'<div class="icon-holder">'
	+'<img src="'+app.img()+'/icons/sql.png" alt="" class="icon">'
	+'</div>'
	+'<h4 class="heading">SQL</h4>'
	+'<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>'
	+'<input type="hidden" name="major_subject_3" value="sql">'
	+'</div>'
	+'</div>'
	+'</div>'
	+'</div>'
	+'<div class="cut cut-bottom"></div>'
	+'</section>';
var user = (function(){
	var init = function() {onCreate();};
	var setContentView = function(){
		$('#member_content_img_member').attr('src',app.img()+'/member.png').css('width','30px').css('alt','home');
		$('#member_content_img_home').attr('src',app.img()+'/home.png').css('width','30px').css('alt','home');
		$('#user_header #exit').addClass('cursor_pointer');
		$('#user_content #kaup').addClass('cursor_pointer').click(function(){controller.move('member','kaup');});
		$('#user_content #rockSissorPaper').addClass('cursor_pointer').click(function(){controller.move('member','rock_sissor_paper');});
		$('#user_content #lotto').addClass('cursor_pointer').click(function(){controller.move('member','lotto');});
		 var key =$('#user_content #major_subject_1 input[type="hidden"]').val();
		$('#user_content #major_subject_1').addClass('cursor_pointer').click(function(){controller.moveWithKey('subject','detail',key);});
		$('#user_content #major_subject_2').addClass('cursor_pointer').click(function(){controller.moveWithKey('subject','detail',key);});
		$('#user_content #major_subject_3').addClass('cursor_pointer').click(function(){controller.moveWithKey('subject','detail',key);}); 
	};
	var onCreate = function(){
		setContentView();
		$('#user_title').click(function(){controller.move('member','main');});
		$('#user_header #account ul li:eq(0) a').click(function(){controller.move('account','detail')});
		$('#user_header #account ul li:eq(1) a').click(function(){controller.move('account','open')});
		$('#user_header #account ul li:eq(2) a').click(function(){controller.move('account','transaction')});
		$('#user_header #account ul li:eq(3) a').click(function(){controller.move('account','delete')});
		$('#user_header #grade ul li:eq(0) a').click(function(){controller.move('grade','detail')});
		$('#user_header #grade ul li:eq(1) a').click(function(){controller.move('grade','find')});
		$('#bt_bom').click(function(){controller.move('','bom');});
		$('#bt_dom').click(function(){controller.move('','dom');});
		$('#bt_kaup').click(function(){controller.move('','kaup');});
		$('#bt_account').click(function(){controller.move('','account');});
		$('#a_regist').click(function(){controller.move('account','regist');})
		$('#a_deposit').click(function(){controller.move('account','deposit');})
		$('#a_withdraw').click(function(){controller.move('account','withdraw');})
		$('#a_update').click(function(){controller.move('account','update');})
		$('#a_delete').click(function(){controller.move('account','delete');})
		$('#a_list').click(function(){controller.move('account','list');})
		$('#a_find_by_account').click(function(){controller.move('account','find_by_account');})
		$('#a_count').click(function(){controller.move('account','count');})
		$('#user_header #exit').on('click',function(){controller.home()});
	};
	return{init : init};
})();
/*
============ ADMIN_JS ==========
@AUTHOR : hongs890@gmail.com
@CREATE DATE : 
@UPDATE DATE : 
@DESC : 관리자
==================================
*/
var admin = (function() {
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){ this._pass = pass;};
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#admin_content h1').addClass('text_center').addClass('_white');
		$('#admin_content p').addClass('text_center').addClass('_white');
		$('#admin_content img').css('margin-left','25%').css('margin-top','25%');
		$('#admin_content #memberMgmt').attr('src',app.img()+'/membermgmt.png').css('width','50%');
		$('#admin_content #gradeMgmt').attr('src',app.img()+'/grademgmt.png').css('width','50%');
		$('#admin_content #accountMgmt').attr('src',app.img()+'/bankmgmt.png').css('width','50%');
		$('#account_open').addClass('media').addClass('text_center');
		$('#account_open  form').css('margin-top','150px');
		$('#account_open > div').addClass('media-left');
		$('#account_open > div > div').addClass('media-body');
		$('#account_open_img').attr('src',app.img()+'/account.jpg').addClass('media-object').css('height','400px').css('width','500px').css('margin-top','100px').css('margin-left','100px').css('margin-right','140px');
		$('#admin_header #exit').addClass('cursor_pointer');
	};
	var onCreate = function(){
		setContentView();
		$('#admin_nav #member_mgmt #list').click(function(){controller.move('member','list')});
		$('#admin_nav #member_mgmt #find_by').click(function(){controller.move('member','find_by')});
		$('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count') });
		$('#admin_nav #account_mgmt #list').click(function(){controller.move('account','list') });
		$('#admin_nav #account_mgmt #open').click(function(){controller.move('account','open') });
		$('#admin_nav #account_mgmt #delete').click(function(){controller.move('account','delete')});
		$('#admin_nav #account_mgmt #find').click(function(){controller.move('account','find') });
		$('#admin_nav #account_mgmt #count').click(function(){controller.move('account','count')});
		$('#admin_header #exit').click(function(){controller.home()});
		$('#admin_header #a_main').click(function(){controller.move('admin','main')});
		$('#g_regist').click(function(){alert('등록을 위해 회원리스트로 이동합니다.'); controller.move('member','list');});	
		$('#g_update').click(function(){alert('수정을 위해 회원리스트로 이동합니다.'); controller.move('member','list');});	
		$('#g_list').click(function(){controller.move('grade','list');});	
		$('#a_open').click(function(){controller.move('account','open');});	
		$('#a_list').click(function(){controller.move('account','list');});	
		$('#a_find').click(function(){controller.move('account','find');});	
		$('#a_count').click(function(){controller.move('account','count');});
	
	};
	return{	
		getPass : getPass,setPass : setPass, init : init,
		check : function(){	
			setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {	alert('관리자만 접근할 수 있는 페이지입니다.');} 
			else {var password = prompt('관리자 비밀번호를 입력해주세요');
			if (password == 1) {controller.move('admin','main');}
			else{alert('잘못된 비밀번호를 입력하셨습니다');}
			}}};
})();

/*
=========== SUBJECT_JS =========
@AUTHOR : hongs890@gmail.com
@CREATE DATE : 
@UPDATE DATE : 
@DESC : 과목
=============================
*/
var subject = (function(){})();
/*
=========== EXAM_JS =====
@AUTHOR : hongs890@gmail.com
@CREATE DATE : 
@UPDATE DATE : 
@DESC : 시험
============================
*/
var exam = (function(){})();
/*
======== GRADE_JS ======
@AUTHOR : hongs890@gmail.com
@CREATE DATE : 
@UPDATE DATE : 
@DESC : 성적
============================
*/

var grade = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#grade_content').addClass('text_center');
		$('#img_home').css('width','30px');
		$('#grade_content > article').css('width','300px').css('margin','0 auto').css('text-align','left');
		$('#title').css('font-size','35px');
		$('#grade_regist').addClass('media').addClass('text_center').css('font-size','30px');
		$('#grade_regist > div').css('float','left').css('width','50%');
		$('#grade_regist > div > div').css('float','right').css('width','50%');
		$('#grade_regist_img').attr('src',app.img()+'/grade.jpg').addClass('media-object').css('height','50%').css('width','70%').css('margin-left','15%').css('margin-top','5%');
		$('#grade_regist span').addClass('float_left').addClass('text_left').css('width','200px');
		$('#grade_regist #bt_join').addClass('btn').addClass('btn-warning');
		$('#grade_regist #bt_cancel').addClass('btn').addClass('btn-warning');
		$('#grade_regist_form').addClass('form-horizontal').css('margin-top','7%').css('margin-right','20%');
		$('#grade_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#grade_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#grade_regist_form > div > div').addClass('col-sm-10');
		$('#grade_regist_form > div > div > input').addClass('form-control');
		$('#grade_update').addClass('media').addClass('text_center').css('font-size','30px');
		$('#grade_update > div').css('float','left').css('width','50%');
		$('#grade_update > div > div').css('float','right').css('width','50%');
		$('#grade_update_img').attr('src',app.img()+'/grade.jpg').addClass('media-object').css('height','50%').css('width','70%').css('margin-left','15%').css('margin-top','5%');
		$('#grade_update span').addClass('float_left').addClass('text_left').css('width','200px');
		$('#grade_update #bt_join').addClass('btn').addClass('btn-warning');
		$('#grade_update #bt_cancel').addClass('btn').addClass('btn-warning');
		$('#grade_update_form').addClass('form-horizontal').css('margin-top','7%').css('margin-right','20%');
		$('#grade_update_form > div').addClass('form-group').addClass('form-group-lg');
		$('#grade_update_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#grade_update_form > div > div').addClass('col-sm-10');
		$('#grade_update_form > div > div > input').addClass('form-control');
	
	};
	var onCreate = function(){
		setContentView();
		$('#g_regist').click(function(){controller.move('grade','regist');});
		$('#g_update').click(function(){controller.move('grade','update');});
		$('#g_delete').click(function(){controller.move('grade','delete');});
		$('#g_list').click(function(){controller.move('grade','list');});
		$('#g_count').click(function(){controller.move('grade','count');});
		$('#g_find').click(function(){controller.move('grade','a_find');});
	};
	return {init : init};
})();

/*
========== QNA_JS ========
@AUTHOR : hongs890@gmail.com
@CREATE DATE : 
@UPDATE DATE : 
@DESC : QNA
=============================
*/
var qna = (function(){})();
/*
========= NOTICE_JS ======
@AUTHOR : hongs890@gmail.com
@CREATE DATE : 
@UPDATE DATE : 
@DESC : 공지사항
=============================
*/
var notice = (function(){})();




