<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
 
	<table>
		<tr>
			<td id="label">Type ID</td>
			<td id="label">Workflow Name</td>
			<td id="label">Description</td>
			<td id="label">More</td>

		</tr>
		<s:iterator value="workflowTypes" var="wf">
			<tr>
				<td><s:property value="#wf.wftypeid" /></td>
				<td><s:property value="#wf.wfname" /></td>
				<td><s:property value="#wf.description" /></td>

				<td><a
					href="<s:url action="user/workflow/viewtypedetails.action">
				<s:param name="cmd">
				displaytypedetails
				</s:param>
				<s:param name="wftypeid">
				%{#wf.wftypeid}
				</s:param>
				</s:url>">Details
				</a></td>
			</tr>
		</s:iterator>


	</table>
</body>
</html>