<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="script/jquery.nivo.slider.js" type="text/javascript"></script>


</head>
<body class="homepage">

<div id="templatemo_wrapper">
	<div id="templatemo_header">
    	
        <div id="site_title"><h1>Workflow Management</h1></div>
        <div class="cleaner"></div>
    </div>
    
    <div id="templatemo_menu">
        <ul>
            <li><a href="Login.jsp" class="current">Home</a></li>
           <!--  <li><a href="contact.html">Contact</a></li> -->
        </ul>    	
        <div class="cleaner"></div>
    </div> <!-- end of templatemo_menu -->
    <div id="templatemo_middle">
    
    	<div id="intro">
    		<h1>Event History</h1>
            <p>This is a generic app that creates and manages various workflows and specifies how the flow is from point to point through out</p>
            <a class="learn_more" href="#"></a>
        </div>
    
		<div class="slider">
			<img src="" alt="have to put"/>
			</div>    
    <div id="templatemo_main">    
    <div class="col_w900">
    <s:if test="hasActionErrors()">
	   <div class="errors">
	      <s:actionerror/>
	   </div>
	</s:if>
	<table>
		<tr>
			<td>Owner Name</td>
			<td>Owner Role</td>
			<td>Workflow Name</td>
			<td>Instance ID</td>
			<td>Action performed</td>
			<td>Processed by</td>
			<td>Current Status</td>
			<td>Previous Status</td>
			<td>Processing Date</td>
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

<div id="templatemo_footer_wrapper">
	<div id="templatemo_footer">
    	
        Copyright © 2048 <a href="#">3-Idiots web solutions</a> - 
        Designed by <a href="http://www.templatemo.com" target="_parent">Damn Mads JSP Team</a>
    
    </div> <!-- end of footer wrapper -->
</div> <!-- end of footer -->

</div>

</body>
</html>