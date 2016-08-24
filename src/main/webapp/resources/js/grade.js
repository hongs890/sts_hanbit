var grade = (function(){
	return {
		init : function(){
			$('#grade_content').addClass('box');
			$('#img_home').css('width','30px');
			$('#grade_content > article')
			.css('width','300px')
			.css('margin','0 auto')
			.css('text-align','left');
			$('#title').css('font-size','35px');
			$('#g_regist').click(function(){
				location.href=app.context()+"/grade/regist";
			});
			$('#g_update').click(function(){
				location.href=app.context()+"/grade/update";
			});
			$('#g_delete').click(function(){
				location.href=app.context()+"/grade/delete";
			});
			$('#g_list').click(function(){
				location.href=app.context()+"/grade/list";
			});
			$('#g_count').click(function(){
				location.href=app.context()+"/grade/count";
			});
			$('#g_find').click(function(){
				location.href=app.context()+"/grade/search";
			});
		}
		};
})();
