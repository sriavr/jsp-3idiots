<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Workflow Instances list</h1></center>

<table>
<tr> 
   <th><h3></h3></th>
</tr>
</table>


<s:form action="viewworkflowinstance.action" method="post">
<table>
		<tr>
		<s:iterator value="viewrolelist" var="i">
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="ownerid"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="ownername"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="wfname"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="wfitemcategory"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="wfitemname"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="creationdatetime"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="state"/>
			</td>
			<td>
			<s:radio name="radioinstanceid" list="#i" listKey="wfinstanceid" listValue="statedescription"/>
			</td>
		</s:iterator>
		</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Approve" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Reject" align="center" width="30"/>
</s:form>
</body>
</html>
