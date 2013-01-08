<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event History details</title>
</head>
<body>
 
	<table>
		<tr>
			<td><b class="current" id="leftmenu">Workflow Instance ID</b></td>

			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.wfinstanceid" />
			</td>
		</tr>

		<tr>
			<td><b class="current" id="leftmenu">Creation Date</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.creationdatetime" /></td>
		</tr>

		<tr>
			<td><b class="current" id="leftmenu">Created by</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.owner.fname" />&nbsp; <s:property
					value="wfInstanceDetails.workflowInstance.owner.lname" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Email</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.owner.emailid" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Phone</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.owner.phone" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Address</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.owner.address" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Role</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.owner.role.rolename" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Role description</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.owner.role.roledescription" /></td>
		</tr>
		<!-- <tr> -->
		<%-- 				<td><b class="current" id="leftmenu">ItemName</b></td>                <td>: &nbsp;<s:property --%>
		<%-- 						value="wfInstanceDetails.workflowInstance.wfitemid.wfitemid" /></td> --%>
		<!-- 			</tr> -->
		<tr>
			<td><b class="current" id="leftmenu">Item Name</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.wfitemid.wfitemname" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Item Type</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.wfitemid.wfitemtype" /></td>
		</tr>
		<!-- <tr> -->
		<%-- 				<td><b class="current" id="leftmenu">State</b></td>                   <td>: &nbsp;<s:property --%>
		<%-- 						value="wfTypeDetails.state.stateID" /></td> --%>
		<!-- 			</tr> -->
		<tr>
			<td><b class="current" id="leftmenu">Current Status</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.currentstate.stateName" /></td>
		</tr>
		<tr>
			<td><b class="current" id="leftmenu">Status Description</b></td>
			<td>: &nbsp;<s:property
					value="wfInstanceDetails.workflowInstance.currentstate.stateDescription" /></td>
		</tr>

	</table>
</body>
</html>