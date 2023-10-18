<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="java.util.Map"
	import="com.ken.empDbManagementSys.database.dao.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee data</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script language="javascript">
	// Set param to action value of form
	function formAttributeUpdate(action,method) {
		document.updateDelteForm.action = action
		document.updateDelteForm.method = method
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td><font color="red"><b>Login user：<%=session.getAttribute("loginId")%></b></font></td>
			<td><input type="button" value="Logout"
				onClick="location.href='LogoutServlet'" /></td>
		</tr>
	</table>

	<form method="get" action="OutputServlet" style="display: inline"
		id="selectForm">
		<span>Search by name：</span><input type="text" name="name" />
		<input type="submit" value="Go" />
	</form>
	<input type="submit" value="New entry" onClick="location.href='input.jsp'" />
	<form method="post" style="display: inline" name="updateDelteForm" action="<%=request.getAttribute("url")%>">
		<input type="submit" value="Update" 	onclick="formAttributeUpdate('UpdateSelectServlet','get')" />
		<input type="submit" value="Delete" onclick="formAttributeUpdate('DeleteServlet','post')" />
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
				<th bgcolor="#00bfff" width="50">Name</th>
				<th bgcolor="#00bfff" width="180">Phone</th>
				<th bgcolor="#00bfff" width="25">Birthday</th>
				<th bgcolor="#00bfff" width="100">Address</th>
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
				<td width="50"><%=employee.getName()%></td>
				<td width="180"><%=employee.getPhone()%></td>
				<td width="100"><%=employee.getBirthdayView()%></td>
				<td width="100"><%=employee.getAddress()%></td>
				<td width="25"><%=employee.getSectionid()%></td>
				<td width="25"><%=employee.getPositionid()%></td>
				<td width="100"><%=employee.getBasepay()%></td>
				<td width="100"><%=employee.getAllowance()%></td>
			</tr>
			<%}	%>
		</table>
		<%} else {%>
		<p>No data found</p>
		<%}	%>
	</form>
</body>
</html>