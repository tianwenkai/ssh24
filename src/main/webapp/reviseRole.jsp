<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>reviseRole</h3>
	<form action="reviseRole.action" method="post">
		role:<select name="role.rid" >
			<c:forEach items="${roleList }" var="role" varStatus="i">
				<option value="${role.rid }" selected="selected">${role.rname }</option>
			</c:forEach>
		</select>
		<button type="submit">更改</button>
		<input type="hidden" name="user.uid" value="${user.uid }"/>
	</form>
</body>
</html>
