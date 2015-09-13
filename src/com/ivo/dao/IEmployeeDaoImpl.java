package com.ivo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ivo.domain.Employee;

@Repository
@Qualifier("employeeDao")
public class EmployeeDaoImpl extends HibernateDaoSupport implements IEmployeeDao {

	@Resource
    public void setSessionFacory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee findEmployeeByEmployeeId(String employee_id) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.employee_id=?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee_id);
		Employee employee = null;
		if(list!=null&&list.size()>=0){
			employee= list.get(0);
		}
		return employee;
	}
	
	
	public static void main(String[] args){
		 ApplicationContext context = new
					ClassPathXmlApplicationContext("applicationContext.xml");
		 
		 EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		 SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		 employeeDao.setSessionFactory(sessionFactory);
		 Employee employee = employeeDao.findEmployeeByEmployeeId("C1107005");
		 System.out.println(employee.getName());
	}

}
