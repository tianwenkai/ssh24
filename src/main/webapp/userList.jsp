<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="/ssh24/src/main/webapp/js/jquery-1.12.3.min.js"></script>
</head>
<body>
	<!-- 权限判断 -->
	<h3>revisePwd</h3>
	<c:if test="${loginUser.role.rid==2 }">
		<form action="revisePwd.action" method="post">
			oldpwd:<input type="text" id ="id" name="oldpwd" />
			newpwd:<input type="text" name="user.upwd" />
			<button type="submit">update</button>
			<input type="hidden" name="user.uid" value="${loginUser.uid }"/>
		</form>
	</c:if>
	<c:if test="${loginUser.role.rid==1 }">
	<h3>list</h3>
	<button type="button" onclick="location.href='addUserFrom.action'">添加用户</button>
	<table border="1" style="width:800px">
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>角色</th>
			<th>重置密码</th>
			<th>修改权限</th>
		</tr>
		<c:forEach items="${userList }" var="user" varStatus="i">
			<tr>
				<th>${(pageBean.nowPage-1)*pageBean.pageRow+i.count }</th>
				<th>${user.uname }</th>
				<th>${user.role.rname }</th>
				<th><button type="button" onclick="location.href='resetPwd.action?user.uid=${user.uid}'">重置密码</button></th>
				<th><button type="button" onclick="location.href='reviseRoleFrom.action?user.uid=${user.uid}&user.role.rid=${user.role.rid}'">修改权限</button></th>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="4">
			<a href="list.action?pageBean.nowPage=1">首页</a>
			<a href="list.action?pageBean.nowPage=${pageBean.nowPage==1?1:pageBean.nowPage-1 }">上一页</a>
			<a href="list.action?pageBean.nowPage=${pageBean.nowPage==pageBean.countPage?pageBean.countPage:pageBean.nowPage+1 }">下一页</a>
			<a href="list.action?pageBean.nowPage=${pageBean.countPage }">末页</a>
			</th>
		</tr>
	</table>
	</c:if>
</body>
<script type="text/javascript">

	$("id").blur(function(){
		alert("原密码不正确！") 
		if($("#id").val()==${loginUser.upwd}){
            alert("原密码不正确！") 
        }
	});

</script>
</html>