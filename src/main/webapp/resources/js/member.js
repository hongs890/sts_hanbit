var member = (function(){
	return {
		init : function(){
			$('#regist').click(function(){location.href=app.context()+"/member/regist"})
			$('#detail').click(function(){location.href=app.context()+"/member/detail"})
			$('#update').click(function(){location.href=app.context()+"/member/update"})
			$('#delete').click(function(){location.href=app.context()+"/member/delete"})
			$('#login').click(function(){location.href=app.context()+"/member/login"})
			$('#logout').click(function(){location.href=app.context()+"/member/logout"})
			$('#list').click(function(){location.href=app.context()+"/member/list"})
			$('#find_by').click(function(){location.href=app.context()+"/member/find_by"})
			$('#count').click(function(){location.href=app.context()+"/member/count"})
			$('#member_content_img_member').attr('src',app.img()+'/member.png').css('width','30px').css('alt','home');
			$('#member_content_img_home').attr('src',app.img()+'/home.png').css('width','30px').css('alt','home');
			$('#member_content_a_member').click(function(){location.href=app.context()+"/member/main"});
			$('#member_content_a_home').click(function(){location.href=app.context()+"/"});
			$('#member_content').addClass('box').css('font-size','20px');
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
		}
	};
})();
