<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/views/global/top.jsp" />
	<a href="#" id="atag">홈으로</a>
</body>
<script src="${js}/application.js"></script>
<script type="text/javascript">
	$(function(){
		application.init("${context}");
		application.go_home();
	}); 
</script>
</html>
