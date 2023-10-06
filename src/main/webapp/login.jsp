<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%Map<String,String> errmsg = (Map<String,String>)request.getAttribute("errMsg");%>
	<%if(errmsg != null){%>
		<ul>
			<%for(Map.Entry<String, String> entry : errmsg.entrySet()) {%>
				<li class="errmsg">
					<%=entry.getValue()%>
				</li>
			<%}%>
		<%}%>
	</ul>
	<form action="LoginServlet" method="get">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="mailaddress" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="pass" /></td>
			</tr>
		</table>
		<input type="submit" value="login" />
	</form>
</body>
</html>