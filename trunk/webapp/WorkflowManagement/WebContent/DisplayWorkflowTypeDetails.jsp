<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Workflow Type Details</title>
</head>
<body>
 
	<table>
		<tr>
			<td><b class="current" id="leftmenu">ID</b></td>
			<td>:&nbsp;<s:property
					value="wfTypeDetails.workflowType.wftypeid" />
			</td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Workflow Name</b></td>
			<td>:&nbsp;<s:property value="wfTypeDetails.workflowType.wfname" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Workflow Description</b></td>
			<td>:&nbsp;<s:property
					value="wfTypeDetails.workflowType.description" /></td>
		</tr>

	</table>

</body>
</html>