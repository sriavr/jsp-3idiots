<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WorkflowInstanceList</title>
</head>
<body>
 
	<table>
		<tr>
			<td id="label">Instance ID</td>
			<td id="label">Creation Date</td>
			<td id="label">Full Name</td>
			<!-- 			<td id="label">Last Name</td> -->
			<!-- 			<td id="label">Email ID</td> -->
			<!-- 			<td id="label">Phone</td> -->
			<!-- 			<td id="label">Address</td> -->
			<!-- 			<td id="label">Role ID</td> -->
			<td id="label">Role</td>
			<!-- 			<td id="label">Role Description</td> -->
			<!-- 			<td id="label">Workflow Item ID</td> -->
			<td id="label">Item Name</td>
			<td id="label">Item Type</td>
			<!-- 			<td id="label">State ID</td> -->
			<td id="label">Current Status</td>
			<!-- 			<td id="label">State Description</td> -->
			<!-- 			<td id="label">Workflow Type ID</td> -->
			<td id="label">Workflow Type</td>
<!-- 			<td id="label">Workflow Description</td> -->


			<td id="label">More</td>
		</tr>


		<s:iterator value="wfTypeDetails.associatedWorkflowInstances" var="i">
			<tr>
				<td><s:property value="#i.wfinstanceid" /></td>
				<td><s:property value="#i.creationdatetime" /></td>
				<td><s:property value="#i.owner.fname" /> <s:property
						value="#i.owner.lname" /></td>
				<%-- 				<td><s:property value="#i.owner.emailid" /></td> --%>
				<%-- 				<td><s:property value="#i.owner.phone" /></td> --%>
				<%-- 				<td><s:property value="#i.owner.address" /></td> --%>
				<%-- 				<td><s:property value="#i.owner.role.roleid" /></td> --%>
				<td><s:property value="#i.owner.role.rolename" /></td>
				<%-- 				<td><s:property value="#i.owner.role.roledescription" /></td> --%>
				<%-- 				<td><s:property value="#i.wfitemid.wfitemid" /></td> --%>
				<td><s:property value="#i.wfitemid.wfitemname" /></td>
				<td><s:property value="#i.wfitemid.wfitemtype" /></td>
				<%-- 				<td><s:property value="#i.currentstate.stateID" /></td> --%>
				<td><s:property value="#i.currentstate.stateName" /></td>
				<%-- 				<td><s:property value="#i.currentstate.stateDescription" /></td> --%>
				<%-- 				<td><s:property value="#i.workflowType.wftypeid" /></td> --%>
				<td><a
					href="<s:url action="user/workflow/viewtypedetails.action" includeContext="false">
				<s:param name="cmd">
				displaytypedetails
				</s:param>
				<s:param name="wftypeid">
				%{#i.workflowType.wftypeid}
				</s:param>
				</s:url>"> <s:property value="#i.workflowType.wfname" /></a></td>
				<%-- 				<td><s:property value="#i.workflowType.description" /></td> --%>


				<td><a
					href="<s:url action="user/workflow/viewinstancedetails.action" includeContext="true">
				<s:param name="cmd" >
				displayinstancedetails
				</s:param>
				<s:param name="wfinstanceid" value="%{#i.wfinstanceid}">
				</s:param>
				</s:url>">Details
				</a></td>

			</tr>
		</s:iterator>

	</table>
</body>
</html>