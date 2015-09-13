package com.ivo.service;

import com.ivo.domain.Employee;

public interface IEmployeeService {
	Employee findEmployeeByEmployeeId(String employee_id);
}
