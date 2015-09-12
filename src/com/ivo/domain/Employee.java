package com.ivo.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee",catalog="itcast7011")
public class Employee {
	
	private Integer id;
	private Integer employee_id;//员工工号
	private String name;
	private String password;
	private String email;
	private String role;
	private Employee manager_id;//直接主管
	private Set<Employee> employees;//下属
	private Set<FollowUpRequisition> followUpRequisitions;//任务需求单
	
	@Id
	@GenericGenerator(name="generator",strategy="native")
	@GeneratedValue(generator="generator")
	@Column(unique=true,length=20)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="employee_id",nullable=false,length=20)
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	
	@Column(name="name",nullable=false,length=30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password",nullable=false,length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="email",length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="role",length=10)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	public Employee getManager_id() {
		return manager_id;
	}
	
	public void setManager_id(Employee manager_id) {
		this.manager_id = manager_id;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="manager_id")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="employee_id")
	public Set<FollowUpRequisition> getFollowUpRequisitions() {
		return followUpRequisitions;
	}
	public void setFollowUpRequisitions(
			Set<FollowUpRequisition> followUpRequisitions) {
		this.followUpRequisitions = followUpRequisitions;
	}
	
	
	
	
}
