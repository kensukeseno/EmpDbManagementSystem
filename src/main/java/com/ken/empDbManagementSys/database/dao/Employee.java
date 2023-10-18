package com.ken.empDbManagementSys.database.dao;

import java.util.Date;

import com.ken.empDbManagementSys.util.DateUtil;

/**
 * Employeeエンティティ
 * @author matsumoto
 *
 */
public class Employee {
	private int empid;
	private String name;
	private String phone;
	private Date birthday;
	private String address;
	private int sectionid;
	private int positionid;
	private int basepay;
	private int allowance;
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getBirthdayView() {
		String birthday = DateUtil.parseString(this.birthday, "yyyy-MM-dd");
		if(birthday == null){
			return "";
		}
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSectionid() {
		return sectionid;
	}
	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
	public int getBasepay() {
		return basepay;
	}
	public void setBasepay(int basepay) {
		this.basepay = basepay;
	}
}
