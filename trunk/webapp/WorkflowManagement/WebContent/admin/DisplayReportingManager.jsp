<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList,model.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h1>Welcome to Asset Requested Member list</h1></center>

<table>
<tr> 
   <th><h3> Name</h3></th>
   </tr>
</table>


<s:form action="" method="post">
<table>
		<tr>
		<s:iterator value="rminstance" var="i">
			<td>
			<s:radio name="radiorminstance" list="#i" listKey="memberid" listValue="fname"/>
			</td>
		</s:iterator>
		</tr>
</table>
	<s:submit name = "submit" id="mysubmit" value="Approve" align="center" width="30"/>
	<s:submit name = "submit" id="mysubmit" value="Reject" align="center" width="30"/>
</s:form>
</body>
</html>
