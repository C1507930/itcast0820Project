package com.ivo.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivo.domain.Employee;
import com.ivo.service.IEmployeeService;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

	private IEmployeeService employeeService;

	@Resource
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value="/login.do")
	public String login(@RequestParam String employee_id,HttpServletRequest request){
		Employee user = employeeService.findEmployeeByEmployeeId(employee_id);
		if(user!=null){
			String name = user.getName();
			request.getSession().setAttribute("name", name);
			return "main";
		}else{
			return "redirect:/login/index.do";
		}
	}
	
	@RequestMapping("/index.do")
	public String index(){
		return "../index";
	}
	
}
