<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="templatemo_middle">

	<div id="intro">
		<h2>Workflow Instance Details</h2>
		<p>This is a page that display the Workflow Instance Details</p>
		<a class="learn_more" href="#"></a>
	</div>
</div>

<div id="templatemo_main">
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:form action="progressworkflow">
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
			<tr>
				<s:select name="actionid" list="actions" headerKey="-1"
					headerValue="--Select Action--" listKey="actionid"
					listValue="actionname" label="Action" required="true"></s:select>
			</tr>
		</table>

		<s:hidden name="wfInstanceDetails.workflowInstance.wfinstanceid">
		</s:hidden>

		<s:hidden name="instanceid">
		</s:hidden>

		<s:hidden name="cmd" value="submitworkflow">
		</s:hidden>
		<s:submit name="submit" id="mysubmit" value="Submit Workflow"
			align="center" action="progressworkflow" />

	</s:form>
</div>
