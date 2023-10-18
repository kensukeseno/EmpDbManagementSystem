package com.ken.empDbManagementSys.form;

import com.ken.empDbManagementSys.database.dao.Employee;
import com.ken.empDbManagementSys.util.DateUtil;
import com.ken.empDbManagementSys.util.IntegerUtil;

public class EmployeeConverter {
	public static Employee formToRepository(EmployeeForm form) {
		Employee emp = new Employee();
		emp.setEmpid(IntegerUtil.parseInt(form.getEmpid()));
		emp.setName(form.getName());
		emp.setPhone(form.getPhone());
		emp.setBirthday(DateUtil.parseDate(form.getBirthday(),DateUtil.DATE_FORMAT));
		emp.setAddress(form.getAddress());
		emp.setSectionid(IntegerUtil.parseInt(form.getSectionid()));
		emp.setPositionid(IntegerUtil.parseInt(form.getPositionid()));
		emp.setBasepay(IntegerUtil.parseInt(form.getBasepay()));
		emp.setAllowance(IntegerUtil.parseInt(form.getAllowance()));
		return emp;
	}
	public static EmployeeForm repositoryToForm(Employee employee) {
		EmployeeForm form = new EmployeeForm();
		form.setEmpid(String.valueOf(employee.getEmpid()));
		form.setName(employee.getName());
		form.setPhone(employee.getPhone());
		form.setBirthday(DateUtil.parseString(employee.getBirthday(),DateUtil.DATE_FORMAT));
		form.setAddress(employee.getAddress());
		form.setSectionid(String.valueOf(employee.getSectionid()));
		form.setPositionid(String.valueOf(employee.getPositionid()));
		form.setBasepay(String.valueOf(employee.getBasepay()));
		form.setAllowance(String.valueOf(employee.getAllowance()));
		return form;
	}	
}
