package com.ivo.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ivo.domain.Employee;
import com.ivo.utils.ControllerContext;
import com.ivo.web.BaseController;

public class BaseInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("拦截");
		if(handler instanceof BaseController){
			//拦截请求，把session中的用户name获取出来
			//Employee employee = (Employee) request.getSession().getAttribute("name");
		}
		
		 //注入Request/Response对象至SpringMVC执行上下文对象中
		if(ControllerContext.getContext().getContextMap().isEmpty()){
			ControllerContext.getContext().setRequest(request);
			ControllerContext.getContext().setResponse(response);
			//System.out.println(ControllerContext.getContext().getRequest().toString());
			
		}
		
		return super.preHandle(request, response, handler);
	}

	
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ControllerContext.getContext().getRequest().getSession().getAttribute("name"));
		super.postHandle(request, response, handler, modelAndView);
	}


	
}
