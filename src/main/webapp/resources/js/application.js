var app = (function(){
	var init = function(context){
		session.init(context);
		member.init();
		user.init();
		account.init();
		kaup.init();
		grade.init();
		navi.init();
		admin.init();
		onCreate();
		
	};
	var context = function(){return session.getContextPath();};
	var js = function(){return sessionStorage.getItem('js');};
	var css = function() {return sessionStorage.getItem('css');};
	var img = function() {return sessionStorage.getItem('img');};
	var setContentView = function(){
		$('#header_brand').attr('src',app.img()+'/mark.png').css('height','50px').css('width','50px').css('alt','Brand');
		$('#header_admin_img').attr('src',app.img()+'/admin.png').css('height','50px').css('width','50px');
		$('#footer').addClass('footer');
		$('#global_content').addClass('media').addClass('text_center').css('font-size','30px');
		$('#global_content > div').addClass('media-left');
		$('#global_content > div > div').addClass('media-body');
		$('#global_content_img').attr('src',app.img()+'/main.png').addClass('media-object').css('height','400px').css('width','500px').css('margin-top','150px').css('margin-left','100px');
		$('#global_content h2').addClass('media-heading').css('font-size','50px').css('margin-top','200px').css('margin-left','50px').text('HANBIT ACADEMY');
		$('#global_content h4').text('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, ');
		$('#global_content a').addClass('cursor_pointer');
		$('#global_content_a_regist').addClass('btn').addClass('btn-warning').text('Sign Up').click(function(){controller.move('member','regist')});
		$('#global_content_a_login').addClass('btn').addClass('btn-warning').text('Login').click(function(){controller.move('member','login')});
		$('#global_content_a_admin').addClass('btn').addClass('btn-warning').text('Admin').click(function(){admin.check()});};
	var onCreate = function() {
		setContentView();
		$('#title').click(function(){controller.home();});
		$('#a_member').click(function(){controller.move('member','main');});
		$('#a_grade').click(function(){controller.move('grade','main');});
		$('#a_account').click(function(){controller.move('account','main');});
		$('#a_school').click(function(){controller.move('global','school_info');});}
	return {init:init, context : context,css : css,js : js,img : img,onCreate : onCreate}})();
var admin = (function() {
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){ this._pass = pass;};
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#admin_content h1').addClass('text_center');
		$('#admin_content p').addClass('text_center');
		$('#admin_content #memberMgmt').attr('src',app.img()+'/membermgmt.png').css('width','500px');
		$('#admin_content #gradeMgmt').attr('src',app.img()+'/grademgmt.png').css('width','500px');
		$('#admin_content #accountMgmt').attr('src',app.img()+'/bankmgmt.png').css('width','500px');
		$('#account_open').addClass('media').addClass('text_center');
		$('#account_open  form').css('margin-top','150px');
		$('#account_open > div').addClass('media-left');
		$('#account_open > div > div').addClass('media-body');
		$('#account_open_img').attr('src',app.img()+'/account.jpg').addClass('media-object').css('height','400px').css('width','500px').css('margin-top','100px').css('margin-left','100px').css('margin-right','140px');
	
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
			
			}
		}
	};
})();

var user = (function(){
	var init = function() {onCreate();};
	var setContentView = function(){
		$('#member_content_img_member').attr('src',app.img()+'/member.png').css('width','30px').css('alt','home');
		$('#member_content_img_home').attr('src',app.img()+'/home.png').css('width','30px').css('alt','home');
		
	};
	var onCreate = function(){
		setContentView();
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
	};
	return{init : init};
})();
var account = (function(){
	var _account_no, _money;
	var setAccountNo = function(account_no){this._account_no = account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		$('#bt_spec_show').click(member.spec());
		$('#bt_make_account').click(this.spec());
		$('#bt_deposit').click(this.deposit());
		$('#bt_withdraw').click(this.withdraw());	
		
		
	};
	return{
		setAccountNo : setAccountNo,getAccountNo : getAccountNo,setMoney : setMoney,getMoney : getMoney,
		init : function(){
			
		},
		spec : function(){
			setAccountNo(Math.floor(Math.random() * 899999) + 100000);
			document.querySelector('#result_account').innerHTML = getAccountNo();
			setMoney(0);
		},
		deposit : function(){
			if(!util.isNumber(getAccountNo())){	alert('먼저 통장 개설이 되어야 입금이 가능합니다.');}
			else{	var money = Number(document.querySelector('#money').value);
				setMoney(getMoney() + money);
				document.querySelector('#rest_money').innerHTML = getMoney();
			}
		},
		withdraw : function(){
			if(!util.isNumber(getAccountNo())){	alert('먼저 통장 개설이 되어야 출금이 가능합니다.');
			}else{
				var money = Number(document.querySelector('#money').value);
				setMoney(getMoney() - money);
				document.querySelector('#rest_money').innerHTML = getMoney();
			}
		}
	};
})();

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
		$('#member_regist > div').addClass('media-left');
		$('#member_regist > div > div').addClass('media-body');
		$('#member_regist_img').attr('src',app.img()+'/main.png').addClass('media-object').css('height','400px').css('width','500px').css('margin-top','150px').css('margin-left','100px').css('margin-right','200px');
		$('#member_regist span').addClass('float_left').addClass('text_left').css('width','200px');
		$('#member_regist #bt_join').addClass('btn').addClass('btn-warning');
		$('#member_regist #bt_cancel').addClass('btn').addClass('btn-warning');
		$('#member_regist_form').addClass('form-horizontal').css('margin-top','60px');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#rd_major > label').css('font-size','20px');
		$('#ck_subject > label').css('font-size','15px');
		$('#member_login').addClass('media').addClass('text_center').css('font-size','30px');
		$('#member_login > div').addClass('media-left');
		$('#member_login > div > div').addClass('media-body');
		$('#member_login_img').attr('src',app.img()+'/main.png').addClass('media-object').css('height','400px').css('width','500px').css('margin-top','150px').css('margin-left','100px');
		$('#member_login #bt_login').addClass('btn').addClass('btn-warning');
		$('#member_login #bt_cancel').addClass('btn').addClass('btn-warning');
		$('#member_login_form').addClass('form-horizontal').css('margin-top','180px').css('margin-left','300px');
		$('#member_login_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_login_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_login_form > div > div').addClass('col-sm-10');
		$('#member_login_form > div > div > input').addClass('form-control');
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
		}
	};
})();

var kaup = (function(){
	var _name, _result, _height, _weight;
	setName = function(name){this._name = name;}
	setResult = function(result){this._result = result;}
	setHeight = function(height){this._height = height;}
	setWeight = function(weight){this._weight = weight;}
	getName = function(){return this._name;}
	getResult = function(){return this._result;}
	getHeight = function(){return this._height;}
	getWeight = function(){return this._weight;}
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		$('#bt_kaup_calc').click(this.calc);
	};
	return{
		init : init,
		setName : setName,
		setResult : setResult,
		setHeight : setHeight,
		setWeight : setWeight,
		getName : getName,
		getResult : getResult,
		getHeight : getHeight,
		getWeight : getWeight,
		calc : function(){
			setName(document.querySelector('#name').value);
			setHeight(document.querySelector('#height').value);
			setWeight(document.querySelector('#weight').value);
			var kaup = getWeight() / (getHeight() / 100) / (getHeight() / 100);
			if (kaup < 18.5) {
		         setResult("저체중");
		    } else if (kaup >= 18.5 && kaup < 23) {
		    	 setResult("정상체중");
		    } else if (kaup >= 23 && kaup < 25) {
		    	setResult("위험체중");
		    } else if (kaup >= 25 && kaup < 30) {
		    	setResult("비만 1단계");
		    } else if (kaup >= 30 && kaup < 40) {
		    	setResult("비만 2단계");
		    }
		     if (kaup >= 40) {
		    	 setResult("비만 3단계");
		    }
		     document.querySelector('#result').innerHTML=getName() +"은 BMI지수는 "+Math.floor(kaup)+"이고," +getResult() +"이다.";
		}
	};
})();



var grade = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#grade_content').addClass('text_center');
		$('#img_home').css('width','30px');
		$('#grade_content > article').css('width','300px').css('margin','0 auto').css('text-align','left');
		$('#title').css('font-size','35px');
	};
	var onCreate = function(){
		
		setContentView();
		$('#g_regist').click(function(){controller.move('grade','regist');});
		$('#g_update').click(function(){controller.move('grade','update');});
		$('#g_delete').click(function(){controller.move('grade','delete');});
		$('#g_list').click(function(){controller.move('grade','list');});
		$('#g_count').click(function(){controller.move('grade','count');});
		$('#g_find').click(function(){controller.move('grade','search');});
	};
	return {init : init};
})();
var session = (function(){
	var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
		};
	var getContextPath = function(){return sessionStorage.getItem('context')};
	return{init:init, getContextPath:getContextPath}})();
var controller = (function(){
	var _page, _directory;
	var setPage = function(page){this._page = page;};
	var setDirectory = function(directory){this._directory = directory;};
	var getPage = function(){return this._page};
	var getDirectory = function(){return this._directory};
	return{setPage : setPage,setDirectory : setDirectory,getPage : getPage,getDirectory : getDirectory,
		move : function(directory,page){
			setDirectory(directory);setPage(page);
			location.href=app.context()+'/'+getDirectory()+'/'+getPage();
		},
		home : function() {location.href=app.context()+'/';}
	};
})();
var util = (function(){
	return{isNumber : function(value){
		return typeof value === 'number' && isFinite(value);
	}
}
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
