<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
	</head>
	<body>
		
		<s:form action="role_edit">
			<s:hidden name="id"></s:hidden>
			<s:textfield name="name"></s:textfield>
			<s:textarea name="description"></s:textarea>
			<s:submit value="提交"></s:submit>
		</s:form>
	
	</body>
</html>
