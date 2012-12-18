<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to Members list</h1></center>
<table>
<tr> 
	<th><h4>Member ID</h4></th>
    <th><h4>Role ID</h4></th>
    <th><h4>First Name</h4></th>
    <th><h4>Last Name</h4></th>
    <th><h4>Email ID</h4></th>
    <th><h4>Phone</h4></th>
    <th><h4>Username</h4></th>
    <th><h4>Address</h4></th>
</tr>
</table>

<s:form action="adminfunctions.action" method="post"> 
	<table>
	<s:iterator value="memberlist" var="i">
		<tr>
		<td><h4>${i.memberid}</h4></td>
		<td><h4>${i.roleid}</h4></td>
		<td><h4>${i.fname}</h4> </td>
		<td><h4>${i.lname}</h4> </td>
		<td><h4>${i.emailid}</h4> </td>
		<td><h4>${i.phone}</h4> </td>
		<td><h4>${i.username}</h4> </td>
		<td><h4>${i.address}</h4> </td>
		</tr>
	</s:iterator>
	</table>		
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
</s:form>
</body>
</html>
