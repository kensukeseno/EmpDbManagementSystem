<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="java.util.Map"
	import="jp.co.nagatake.database.dao.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DBアウトプットページ</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script language="javascript">
	// 引数をフォームの送信先にする関数
	function formAttributeUpdate(action,method) {
		document.updateDelteForm.action = action
		document.updateDelteForm.method = method
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td><font color="red"><b>ログインユーザ：<%=session.getAttribute("loginId")%></b></font></td>
			<td><input type="button" value="ログアウト"
				onClick="location.href='LogoutServlet'" /></td>
		</tr>
	</table>

	<form method="get" action="OutputServlet" style="display: inline"
		id="selectForm">
		<span>社員名検索：</span><input type="text" name="name" />
		<input type="submit" value="表示" />
	</form>
	<input type="submit" value="新規作成" onClick="location.href='input.jsp'" />
	<form method="post" style="display: inline" name="updateDelteForm" action="<%=request.getAttribute("url")%>">
		<input type="submit" value="更新" 	onclick="formAttributeUpdate('UpdateSelectServlet','get')" />
		<input type="submit" value="削除" onclick="formAttributeUpdate('DeleteServlet','post')" />
		<%Map<String,String> errMsg = (Map<String,String>)request.getAttribute("errMsg");%>
		<%if(errMsg != null){%>
			<span class="errmsg"><%=errMsg.get("empId")%></span>
		<%}%>
		<%List<Employee> list = (List<Employee>) request.getAttribute("list");%>
		<%if (list != null && !list.isEmpty()) {%>
		<table border=1>
			<tr>
				<th bgcolor="#00bfff" width="25"></th>
				<th bgcolor="#00bfff" width="25">Empid</th>
				<th bgcolor="#00bfff" width="250">Name</th>
				<th bgcolor="#00bfff" width="180">Phone</th>
				<th bgcolor="#00bfff" width="25">Birthday</th>
				<th bgcolor="#00bfff" width="250">Address</th>
				<th bgcolor="#00bfff" width="25">Sectionid</th>
				<th bgcolor="#00bfff" width="25">Positionid</th>
				<th bgcolor="#00bfff" width="100">Basepay</th>
				<th bgcolor="#00bfff" width="100">Allowance</th>
			</tr>
			<%for (Employee employee : list) {%>
			<tr>
				<td width="25"><input type="radio" name="empid"
					value="<%=employee.getEmpid()%>"></td>
				<td width="25"><%=employee.getEmpid()%></td>
				<td width="250"><%=employee.getName()%></td>
				<td width="180"><%=employee.getPhone()%></td>
				<td width="100"><%=employee.getBirthdayView()%></td>
				<td width="250"><%=employee.getAddress()%></td>
				<td width="25"><%=employee.getSectionid()%></td>
				<td width="25"><%=employee.getPositionid()%></td>
				<td width="100"><%=employee.getBasepay()%></td>
				<td width="100"><%=employee.getAllowance()%></td>
			</tr>
			<%}	%>
		</table>
		<%} else {%>
		<p>表示対象データが存在しません。</p>
		<%}	%>
	</form>
</body>
</html>