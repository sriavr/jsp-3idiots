<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MemberDetails</title>
</head>
<body>
<table>
<tr><td><b class="current">MemberID</b></td> <td><s:property value="member.memberid"/><td></tr>
<tr><td><b class="current">First Name</b></td>  <td><s:property value="member.fname"/></td></tr>
<tr><td><b class="current">Last Name</b></td> <td><s:property value="member.lname"/></td></tr>
<tr><td><b class="current">Email ID</b></td> <td><s:property value="member.emailid"/><td></tr>
<tr><td><b class="current">Phone</b></td>  <td><s:property value="member.phone"/></td></tr>
<tr><td><b class="current">UserName</b></td> <td><s:property value="member.username"/></td></tr>
<tr><td><b class="current">UserName</b></td> <td><s:property value="member.address"/></td></tr>

</table>
</body>
</html>




