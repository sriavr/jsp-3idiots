<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList,model.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h1>Display selected Workflow</h1></center>
<s:form action="modifyworkflowtype" method="post">
<table>
	<tr>
	<td><s:textfield label="Workflow Type ID" name="wftypeid" value="%{wftypeid}"/></td>
	<td><s:textfield label="Workflow Name" name="wfname" value="%{wfname}"/></td>
	<td><s:textfield label="Description" name="description" value="%{description}"/></td>
	</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Modify" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Delete" align="center" width="30"/>
	<a href="logout" id="mysubmit">Logout</a>
</s:form>
</body>
</html>
