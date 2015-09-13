package com.ivo.dao;

import com.ivo.domain.Employee;

public interface IEmployeeDao {
	Employee findEmployeeByEmployeeId(String employee_id);
}
