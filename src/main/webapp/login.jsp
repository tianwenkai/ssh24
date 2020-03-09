<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="/ssh24/src/main/webapp/js/jquery-1.12.3.min.js"></script>
</head>
<body>
	<h3>login</h3>
	<form action="login.action" method="post">
		uname<input type="text" name="user.uname" />
		upwd<input type="password" name="user.upwd" />
		<button>login</button>
		<button type="button" id="regBtn">reg</button>
	</form>
</body>
<script>
	$(document).ready(function(){
		$("#regBtn").click(function(){
			location.href="save.jsp";
		});
	});
</script>
</html>
