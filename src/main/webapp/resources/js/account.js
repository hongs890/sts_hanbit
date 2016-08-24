var account = (function(){
	return {
		init : function(){
			$('#a_regist').click(function(){location.href=app.context()+"/account/regist"})
			$('#a_deposit').click(function(){location.href=app.context()+"/account/deposit"})
			$('#a_withdraw').click(function(){location.href=app.context()+"/account/withdraw"})
			$('#a_update').click(function(){location.href=app.context()+"/account/update"})
			$('#a_delete').click(function(){location.href=app.context()+"/account/delete"})
			$('#a_list').click(function(){location.href=app.context()+"/account/list"})
			$('#a_find_by_account').click(function(){location.href=app.context()+"/account/find_by_account"})
			$('#a_count').click(function(){location.href=app.context()+"/account/count"})
		}
	};
})();
