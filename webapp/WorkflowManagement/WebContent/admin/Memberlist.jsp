<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList,model.*,action.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h1>Welcome to Members list</h1></center>
<table>
<tr> 
	<th><h4>First Name</h4></th>
    </tr>
</table>

<s:form action="displaymember.action" method="post"> 
	<table>
	<tr>
	<s:iterator value="memberlist" var="i">
		<td>
			<s:radio name="radiomemberid" list="#i" listKey="memberid" listValue="fname"/>
			</td>
		</s:iterator>
		</tr>
	</table>		
	
	<s:submit name = "submit" id="mysubmit" value="Display" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
</s:form>
</body>
</html>
