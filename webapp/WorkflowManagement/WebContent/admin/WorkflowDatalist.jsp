<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList,model.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h1>Welcome to WorkflowData list</h1></center>

<table>
<tr> 
   <th><h3>Workflow Name</h3></th>
   </tr>
</table>


<s:form action="addworkflowdata" method="post">
<table>
		
		<s:iterator value="viewworkflowdata" var="i">
		<tr>
			<td> <s:property value="%{name}"/> </td>
		</tr>
		</s:iterator>
			<s:iterator value="viewworkflowdata" var="i">
		<tr>
			<td> <s:property value="%{value}"/> </td>
		</tr>
		</s:iterator>
		
</table>
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
</s:form>
</body>
</html>
