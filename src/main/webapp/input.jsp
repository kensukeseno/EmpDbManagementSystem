<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ken.empDbManagementSys.database.dao.Employee"
	import="java.util.Map" import="java.util.HashMap"
	import="com.ken.empDbManagementSys.form.EmployeeForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Input</title>
</head>
<table>
	<tr>
		<td><font color="red"><b>Login：<%=session.getAttribute("loginId")%></b></font></td>
		<td><input type="button" value="Logout"
			onClick="location.href='LogoutServlet'" /></td>
	</tr>
</table>
<body>
	<%Map<String, String> errMsg = (Map<String, String>) request.getAttribute("errMsg");%>
	<%errMsg = errMsg != null ? errMsg : new HashMap<String, String>();%>
	<%EmployeeForm form = (EmployeeForm) request.getAttribute("employeeForm");%>
	<%form = form != null ? form : new EmployeeForm();%>
	<form method="post" action="InputServlet">
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="<%=form.getName() != null ? form.getName() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("name")  != null ? errMsg.get("name") : ""%></td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone"
					value="<%=form.getPhone() != null ? form.getPhone() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("phone")  != null ? errMsg.get("phone") : ""%></td>
			</tr>
			<tr>
				<td>birthday</td>
				<td><input type="text" name="birthday"
					value="<%=form.getBirthday() != null ? form.getBirthday() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("birthday")  != null ? errMsg.get("birthday") : ""%></td>
			</tr>
			<tr>
				<td>address</td>
				<td><input type="text" name="address"
					value="<%=form.getAddress() != null ? form.getAddress() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("address")  != null ? errMsg.get("address") : ""%></td>
			</tr>
			<tr>
				<td>sectionid</td>
				<td><input type="text" name="sectionid"
					value="<%=form.getSectionid() != null ? form.getSectionid() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("sectionid")  != null ? errMsg.get("sectionid") : ""%></td>
			</tr>
			<tr>
				<td>positionid</td>
				<td><input type="text" name="positionid"
					value="<%=form.getPositionid() != null ? form.getPositionid() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("positionid")  != null ? errMsg.get("positionid") : ""%></td>
			</tr>
			<tr>
				<td>basepay</td>
				<td><input type="text" name="basepay"
					value="<%=form.getBasepay() != null ? form.getBasepay() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("basepay")  != null ? errMsg.get("basepay") : ""%></td>
			</tr>
			<tr>
				<td>allowance</td>
				<td><input type="text" name="allowance"
					value="<%=form.getAllowance() != null ? form.getAllowance() : ""%>"></td>
				<td class="errmsg"><%=errMsg.get("allowance")  != null ? errMsg.get("allowance") : ""%></td>
			</tr>
		</table>
		<input type="submit" value="Send"> <input type="button"
			value="Back" onClick="location.href='OutputServlet'" />
	</form>
</body>
</html>