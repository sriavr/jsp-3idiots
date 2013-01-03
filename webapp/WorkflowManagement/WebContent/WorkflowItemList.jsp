<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.* ,action.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to WorkflowItem list</h1></center>
<table>
<tr> 
	<th><h4>WorkflowItem Name</h4></th>
    </tr>
</table>

<s:form action="displayworkflowitem.action" method="post"> 
	<table>
	<tr>
	<s:iterator value="workflowitemlist" var="i">
		<td>
			<s:radio name="radioworkflowitemid" list="#i" listKey="wfitemid" listValue="wfitemname"/>
			</td>
		</s:iterator>
		</tr>
	</table>		
	
	<s:submit name = "submit" id="mysubmit" value="Display" align="right" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Delete" align="left" width="30"/>
</s:form>
</body>
</html>
