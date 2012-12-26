<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Display selected Action</h1></center>
<s:form action="modifyaction" method="post">
<table>
	<tr>
	<td><s:textfield label="Action ID" name="actionid" value="%{actioid}"/></td>
	<td><s:textfield label="Workflow Type ID" name="wftypeid" value="%{wftypeid}"/></td>
	<td><s:textfield label="Action Name" name="actionname" value="%{actionname}"/></td>
	<td><s:textfield label="Action Description" name="actiondescription" value="%{actiondescription}"/></td>
	</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Modify" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Delete" align="center" width="30"/>
	
</s:form>
</body>
</html>
