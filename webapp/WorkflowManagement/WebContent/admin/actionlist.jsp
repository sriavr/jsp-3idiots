<%@ page contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.ArrayList,model.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h1>Welcome to Action list</h1></center>

<table>
<tr> 
   <th><h3>Action Name</h3></th>
   </tr>
</table>


<s:form action="displayaction" method="post">
<table>
		<tr>
		<s:iterator value="actionlist" var="i">
			<td>
			<s:radio name="radioactionid" list="#i" listKey="actionid" listValue="actionname"/>
			</td>
		</s:iterator>
		</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Display" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Delete" align="center" width="30"/>
</s:form>
</body>
</html>
