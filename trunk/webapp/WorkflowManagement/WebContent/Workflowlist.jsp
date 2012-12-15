<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="mystyle.css">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to Workflow list</h1></center>
 
<table>
<tr> 
    <th><h2>Workflow Type ID</h2></th>
    <th><h2>Workflow Name</h2></th>
    <th><h2>Description</h2></th>
</tr>
<%@ page import="java.util.ArrayList, models.*" %>

<s:iterator value="workflow" var="i">
<tr>
<td><h3>${i.wftypeid}</h3></td>
<td><h3>${i.wfname}</h3> </td>
<td><h3>${i.description}</h3> </td>
</tr>		
</s:iterator>

</table>
</body>
</html>
