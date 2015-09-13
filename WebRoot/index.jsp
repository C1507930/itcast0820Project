<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'index.jsp' starting page</title>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$name = $("#name");
			$name.css({"width":"150px",
					   "height":"30px",
					   "color":"red",
					   "background":"#e1e1e1",
					   "font-size":"20px",
					   "border":"1px solid #f1f1f1"
					});
		});
	</script>
  </head>
  
  <body>
  	<form action="<%=basePath %>login/login.do" method="post">
  		<table>
		  	<tr>
			  	<td>工号：</td>
			    <td><input type="text" id="name" name="employee_id"/></td>
		  	</tr>
		  	<tr>
			    <td colspan="2"><input type="submit" id="submit" value="登录"/></td>
		  	</tr>
  		</table>
  	</form>
  </body>
</html>
