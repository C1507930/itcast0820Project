package com.ivo.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//SpringMVC执行上下文
public class ControllerContext implements Serializable {

	// 当前线程局部变量
	private static ThreadLocal controllerContext = new ThreadLocal();

	// 用来给当前线程局部变量缓存
	private Map<Object, Object> map;

	private static final String REQUEST = "javax.servlet.http.HttpServletRequest";
	private static final String RESPONSE = "javax.servlet.http.HttpServletResponse";
	/*private static final String SESSION = "javax.servlet.http.HttpSession";
	private static final String APPLICATION = "javax.faces.application.Application";*/
	
	//构造器
	public ControllerContext(Map<Object, Object> map) {
		this.map = map;
	}
	
	//用来把SpringMVC执行上下文对象 放到当前线程局部变量中
	public static void setContext(ControllerContext context){
		controllerContext.set(context);
	}
	
	//从当前线程局部变量中获取SpringMVC执行上下文对象
	public static ControllerContext getContext(){
		ControllerContext context = (ControllerContext) controllerContext.get();
		if(context==null){
			context = new ControllerContext(new HashMap<Object,Object>());
			//绑定到当前线程局部变量
			setContext(context);
		}
		
		return context;
	}
	
	public Map<Object,Object> getContextMap(){
		return this.map;
	}
	
	public void setContextMap(Map<Object,Object> map){
		getContext().map = map;
	}
	
	public void put(Object key,Object value){
		this.map.put(key, value);
	}
	public Object get(Object key){
		return this.map.get(key);
	}
	//把request对象先放到map
	public void setRequest(HttpServletRequest request){
		put(REQUEST, request);
	}
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) get(REQUEST);
	}
	
	
	//把response对象先放到map
	public void setResponse(HttpServletResponse response){
		put(RESPONSE,response);
	}
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) get(RESPONSE);
	}
	
	public HttpSession getSession(){
		return this.getRequest().getSession();
	}
	
	public ServletContext getApplication(){
		return this.getRequest().getServletContext();
	}


}
