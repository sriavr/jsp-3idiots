<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    


    <div id="templatemo_middle">
    
    	<div id="intro">
    		<h1>Event History</h1>
            <p>This page display all the Event History  related to a particular instance</p>
            <a class="learn_more" href="#"></a>
        </div>
    
		
    <div id="templatemo_main">    
    
    <s:if test="hasActionErrors()">
	   <div class="errors">
	      <s:actionerror/>
	   </div>
	</s:if>
	<table>
		<tr>
			<td>Owner Name</td>&nbsp;
			<td>Owner Role</td>&nbsp;
			<td>Workflow Name</td>&nbsp;
			<td>Instance ID</td>&nbsp;
			<td>Action performed</td>&nbsp;
			<td>Processed by</td>&nbsp;
			<td>Current Status</td>&nbsp;
			<td>Previous Status</td>&nbsp;
			<td>Processing Date</td>&nbsp;
		</tr>
		<s:iterator value="wfInstanceDetails.eventHistory" var="i">
			<tr>
				<td><s:property value="%{#i.owner.fname}" />&nbsp;<s:property
						value="%{#i.owner.lname}" /></td>
				<td><s:property value="%{#i.owner.role.rolename}" /></td>
				<td><s:property value="%{#i.workflowType.wfname}" /></td>
				<td><s:property value="%{wfinstanceid}" /></td>
				<td><s:property value="%{#i.action.actionname}" /></td>
				<td><s:property value="%{#i.actor.role.rolename}" /></td>
				<td><s:property value="%{#i.stateSequence.nextState.stateName}" /></td>
				<td><s:property value="%{#i.stateSequence.prevState.stateName}" /></td>
				<td><s:property value="%{#i.eventDateTime}" /></td>
				<%-- 				<td><s:property value="%{#i.owner.memberid}" /></td> --%>
				<%-- 				<td><s:property value="%{#i.actor.fname}" />&nbsp;<s:property --%>
				<%-- 						value="%{#i.actor.lname}" /></td>						 --%>
				<%-- 				<td><s:property value="%{#i.eventid}" /></td> --%>
				<%-- 				<td><s:property value="%{i.workflowType.wftypeid}" /></td>				 --%>
			</tr>
		</s:iterator>
	<!-- </table>
	<!-- 		<td><b class="current" id="leftmenu">WorkFlow InstanceID</b> -->
	<!-- 		<td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.wfinstanceid" /> --%>
	<!-- 		<td> -->
	<!-- 		<td><b class="current" id="leftmenu">Previous State Name</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.currentstate.stateName" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Previous State -->
	<!-- 				Description</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.currentstate.stateDescription" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Action Name</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.action.actionname" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Action Description</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.action.actiondescription" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Workflow Type Name</b></td> -->
	<%-- 		<td>:<s:property value="wfInstanceDetails.workflowType.wfname" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Workflow Type -->
	<!-- 				Description</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowType.description" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Event DateTime</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.creationdatetime" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">FName</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.fname" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">LName</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.lname" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">MailID</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.emailid" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Phone</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.phone" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">Address</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.address" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">RoleName</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.role.rolename" /></td> --%>
	<!-- 		<td><b class="current" id="leftmenu">RoleDescription</b></td> -->
	<%-- 		<td>:<s:property --%>
	<%-- 				value="wfInstanceDetails.workflowInstance.owner.role.roledescription" /></td> --%>
	 
	 
	</table> 
	 </div>
</div>

