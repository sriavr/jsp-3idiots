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
	<th><h2>Member ID</h2></th>
    <th><h2>Role ID</h2></th>
    <th><h2>First Name</h2></th>
    <th><h2>Last Name</h2></th>
    <th><h2>Email ID</h2></th>
    <th><h2>Phone</h2></th>
    <th><h2>Username</h2></th>
    <th><h2>Address</h2></th>
</tr>
</table>

<s:form action="adminfunctions.action" method="post"> 
	<s:iterator value="memberlist" var="i">
	<table>	
		<tr>
		<td><h2>${i.memberid}</h2></td>
		<td><h2>${i.roleid}</h2></td>
		<td><h2>${i.fname}</h2> </td>
		<td><h2>${i.lname}</h2> </td>
		<td><h2>${i.emailid}</h2> </td>
		<td><h2>${i.phone}</h2> </td>
		<td><h2>${i.username}</h2> </td>
		<td><h2>${i.address}</h2> </td>
		</tr>
	</table>		
	</s:iterator>
	<s:submit name = "submit" id="mysubmit" value="Back" align="center" width="30"/>
</s:form>
</body>
</html>
