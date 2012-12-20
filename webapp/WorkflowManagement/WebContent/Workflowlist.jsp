<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to Workflow list</h1></center>
<s:form action="displayworkflowtype" method="post">
<table>
		<tr>
		<s:iterator value="viewwflist" var="i">
			<td>
			<s:radio name="radiowftypeid" list="#i" listKey="wftypeid" listValue="wfname"/>
			</td>
		</s:iterator>
		</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Display" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
	<a href="logout" id="mysubmit">Logout</a>
</s:form>
</body>
</html>
