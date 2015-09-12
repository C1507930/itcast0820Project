package com.ivo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="followUpRequisition",catalog="itcast7011")
public class FollowUpRequisition {
	private Long id;//主键ID
	private Integer days;// 验收天数
	private String content;// 任务需求
	private Date expectDate = new Date();// 期望日期
	private String remark;// 备注
	private Employee employee_id;// 任务需求申请人

	private Integer state=0;// 任务需求单状态 0初始录入,1.开始审批,2为审批通过

	@Id
	@GenericGenerator(name="generator",strategy="native")
	@GeneratedValue(generator="generator")
	@Column(unique=true,length=20)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="days",nullable=false,length=10)
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Column(name="content",nullable=false,length=200)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="expectDate",nullable=false,length=50)
	public Date getExpectDate() {
		return expectDate;
	}

	public void setExpectDate(Date expectDate) {
		this.expectDate = expectDate;
	}

	@Column(name="remark",nullable=false,length=200)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	public Employee getemployee_id() {
		return employee_id;
	}

	public void setemployee_id(Employee employee_id) {
		this.employee_id = employee_id;
	}

	@Column(name="state",nullable=false,length=10)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
