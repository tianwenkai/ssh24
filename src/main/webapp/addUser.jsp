<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>addUser</h3>
	<form action="addUser.action" method="post">
		uname:<input name="user.uname" />
		upwd:<input name="user.upwd" />
		role:<select name="role.rid" >
			<c:forEach items="${roleList }" var="role" varStatus="i">
				<option value="${role.rid }" selected="selected">${role.rname }</option>
			</c:forEach>
		</select>
		<button type="submit" id="regBtn">添加</button>
	</form>
</body>
</html>
