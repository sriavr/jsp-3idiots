<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MemberList</title>
</head>
<body>
 
<table>
<tr>
<td id="label">MemberID</td>
<td id="label"> First Name</td>
<td id="label">EmailID</td>
<td id="label">More</td>
</tr>

<s:iterator value="wfTypeDetails.associatedMembers" var="i">
<tr>
				<td><s:property value="%{#i.memberid}" /></td>
				<td><s:property value="%{#i.fname}" /></td>
				<td><s:property value="%{#i.emailid}" /></td>
				<td><a
					href="<s:url action="user/workflow/viewmemberdetails.action">
				<s:param name="cmd">
				displaymemberdetails
				</s:param>
				<s:param name="memberid">
				%{#i.memberid}
				</s:param>
				</s:url>">Details
				</a></td>
</tr>
</s:iterator>
</table>
</body>
</html>