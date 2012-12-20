<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to Roles list</h1></center>
<table>
<tr> 
    <th><h3>Role ID</h3></th>
    <th><h3>Workflow Type ID</h3></th>
    <th><h3>Role Name</h3></th>
    <th><h3>Description</h3></th>
</tr>
</table>

<s:form action="displayrole" method="post">
<table>
		<tr>
		<s:iterator value="viewrolelist" var="i">
			<td>
			<s:radio name="radioroleid" list="#i" listKey="roleid" listValue="rolename"/>
			</td>
		</s:iterator>
		</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Display" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
</s:form>
</body>
</html>
