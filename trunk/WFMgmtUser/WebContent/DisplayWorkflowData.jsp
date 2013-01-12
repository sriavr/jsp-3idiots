<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <div id="templatemo_middle">
    
    	<div id="intro">
        	<h2>Workflow Data List</h2>
            <p>This is a page that list all the data of the Workflow</p>
            <a class="learn_more" href="#"></a>
        </div>
   	</div>

<div id="templatemo_main">    
<s:if test="hasActionErrors()">
	   <div class="errors">
	      <s:actionerror/>
	   </div>
	</s:if>

<table>
<!-- <tr> -->
<!-- <td id="label">WorkflowInstanceID</td> -->
<!-- <td id="label">WorkflowDataDefID</td> -->
<!-- <td id="label">WorkflowDataID</td> -->

<!-- <td id="label">Name</td> -->
<!-- <td id="label">Value</td> -->
<!-- </tr> -->
workflowDataAll

		<s:iterator value="wfInstanceDetails.associatedWorkflowData" var="i">
			<tr>
				<%-- 				<td><s:property value="%{#i.wfinstanceid}" /></td> --%>
				<%-- 				<td><s:property value="%{#i.workflowDataDef.wfdatadefid}" /></td> --%>
				<%-- 				<td><s:property value="%{#i.wfdataid}" /></td> --%>
				<td><s:property value="%{#i.workflowDataDef.name}" /></td>
				<s:if test="%{#i.workflowDataDef.isreadonly == 0}">
					<td><s:property value="%{#i.value}" /></td>
				</s:if>
				<s:else>
					<td><s:property value="%{#i.workflowDataDef.constantvalue}" /></td>
				</s:else>


			</tr>
		</s:iterator>

</table>

</div>