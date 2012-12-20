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

<s:form action="modifyrole" method="post">
<table>
	<tr>
	<td><s:textfield label="Role ID" name="roleid" value="%{roleid}"/></td>
	<td><s:textfield label="Workflow Type ID" name="wftypeid" value="%{wftypeid}"/></td>
	<td><s:textfield label="Role Name" name="rolename" value="%{rolename}"/></td>
	<td><s:textfield label="Role Description" name="roledescription" value="%{roledescription}"/></td>
	</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Modify" align="center" width="30"/>
	<a href="logout" id="mysubmit">Logout</a>
</s:form>
</body>
</html>
