package com.ivo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ivo.dao.IEmployeeDao;
import com.ivo.domain.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDao;

	@Resource
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee findEmployeeByEmployeeId(String employee_id) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.findEmployeeByEmployeeId(employee_id);
		return employee;
	}

}
