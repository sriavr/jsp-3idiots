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
<table>
<tr> 
    <th><h3>Workflow Type ID</h3></th>
    <th><h3>Workflow Name</h3></th>
    <th><h3>Description</h3></th>
</tr>
</table>

<s:form action="adminfunctions.action" method="post">
	<table> 
	<s:iterator value="workflow" var="i">	
		<tr>
		<td><h3>${i.wftypeid}</h3></td>
		<td><h3>${i.wfname}</h3> </td>
		<td><h3>${i.description}</h3> </td>
		</tr>		
	</s:iterator>
	</table>
	<s:submit name ="submit" id="mysubmit" value="Create Workflow" align="center" width="30" />
	<s:submit name = "submit" id="mysubmit" value="Add Role" align="center" width="30" />
	<s:submit name = "submit" id="mysubmit" value="Add Member" align="center" width="30" />
	<a href="logout" id="mysubmit">Logout</a>
</s:form>
</body>
</html>
