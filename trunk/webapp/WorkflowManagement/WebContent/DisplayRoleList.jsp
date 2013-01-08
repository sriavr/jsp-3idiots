<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role List</title>
</head>
<body> 

<table>
<tr>
<td id="label">RoleID</td>
<td id="label"> Role Name</td>
<td id="label"> Description</td>
</tr>

<s:iterator value="wfTypeDetails.associatedRoles" var="i">
<tr>
				<td><s:property value="%{#i.roleid}" /></td>
				<td><s:property value="%{#i.rolename}" /></td>
				<td><s:property value="%{#i.roledescription}" /></td>
</tr>
</s:iterator>
</table>
</body>
</html>