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

<s:form action="adminfunctions.action" method="post">
	<table>	 
	<s:iterator value="rolelist" var="i">
		<tr>
		<td><h3>${i.roleid}</h3></td>
		<td><h3>${i.wftypeid}</h3></td>
		<td><h3>${i.rolename}</h3> </td>
		<td><h3>${i.description}</h3> </td>
		</tr>		
	</s:iterator>
	</table>
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
</s:form>
</body>
</html>
