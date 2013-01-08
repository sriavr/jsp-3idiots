<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StateSequenceDetails</title>
</head>
<body>
 
<table>
<tr><td><b class="current" >SeqID</b><td>                        <td>:<s:property value="wfTypeDetails.stateSequenceTable.seqid"  /><td></tr>
<tr><td><b class="current" >RoleID</b></td>                      <td>:<s:property value="wfTypeDetails.wfInstanceDetails.owner.roleid"  /></td></tr>
<tr><td><b class="current" >RoleName</b></td>                    <td>:<s:property value="wfTypeDetails.wfInstanceDetails.owner.rolename"  /></td></tr>
<tr><td><b class="current" >RoleDescription</b><td>              <td>:<s:property value="wfTypeDetails.wfInstanceDetails.owner.roledescription"/><td></tr>
<tr><td><b class="current" >PreviousStateID</b></td>             <td>:<s:property value="wfTypeDetails.state.stateID"  /></td></tr>
<tr><td><b class="current" >PreviousStateName</b></td>           <td>:<s:property value="wfTypeDetails.state.stateName"  /></td></tr>
<tr><td><b class="current" >PreviousStateDescription</b><td>     <td>:<s:property value="wfTypeDetails.state.stateDescription"  /><td></tr>
<tr><td><b class="current" >NextStateID</b></td>                 <td>:<s:property value="wfTypeDetails.stateSequenceTable.nextState.stateID"  /></td></tr>
<tr><td><b class="current" >NextStateName</b></td>               <td>:<s:property value="wfTypeDetails.stateSequenceTable.nestState.stateName"  /></td></tr>
<tr><td><b class="current" >NextStateDescription</b><td>         <td>:<s:property value="wfTypeDetails.stateSequenceTable.nextState.stateDescription"  /><td></tr>
<tr><td><b class="current" >ActionID</b></td>                    <td>:<s:property value="wfTypeDetails.action.actionid"  /></td></tr>
<tr><td><b class="current" >ActionName</b></td>                  <td>:<s:property value="wfTypeDetails.action.actionname"  /></td></tr>
<tr><td><b class="current" >ActionDescription</b><td>            <td>:<s:property value="wfTypeDetails.action.actiondescription"  /><td></tr>
<tr><td><b class="current" >WorkFlowName</b></td>                <td>:<s:property value="wfTypeDetails.workflowType.wfname"  /></td></tr>
<tr><td><b class="current" >WorkFlowDescription</b></td>         <td>:<s:property value="wfTypeDetails.workflowType.description"  /></td></tr>

</table>

</body>
</html>


