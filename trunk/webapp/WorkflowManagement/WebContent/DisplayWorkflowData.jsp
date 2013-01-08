<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WorkflowDataList</title>
</head>
<body>

	<table>
		<tr>
			<!-- 			<td id="label">WorkflowInstanceID</td> -->
			<!-- 			<td id="label">WorkflowDataDefID</td> -->
			<!-- 			<td id="label">WorkflowDataID</td> -->

			<!-- 			<td id="label">Name</td> -->
			<!-- 			<td id="label">Value</td> -->
			<!-- 			<td id="label">More</td> -->
		</tr>
		Workflow Data

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
</body>
</html>