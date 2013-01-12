<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="templatemo_middle">

	<div id="intro">
		<h2>Create Workflow Instance</h2>
		<p>You can create a new workflow instance here</p>
	</div>
</div>

<div id="templatemo_main">
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

	<div id="templatemo_main">
		<div class="col_w900">

			<s:form name="contact_form" action="createworkflowinstance"
				method="post">

				<s:select name="categoryid" list="categories" headerKey="-1"
					headerValue="--Select Category--" listKey="wfcategoryid"
					listValue="wfcategoryname" label="Category" required="true"></s:select>

				<h3>Enter Workflow Data:</h3>
				<s:iterator value="workflowData" status="stat" var="i">
					<s:if test="%{#i.workflowDataDef.isreadonly == 0}">
						<s:textfield name="%{workflowData[#stat.index].value}"
							label="%{#i.workflowDataDef.name}" />
					</s:if>
					<s:else>
						<s:label value="%{#i.workflowDataDef.constantvalue}"
							label="%{#i.workflowDataDef.name}"></s:label>
					</s:else>

				</s:iterator>

				<%-- 				<s:iterator value="workflowData" var="i">
					<td><s:property value="%{#i.wfinstanceid}" /></td>
												<td><s:property value="%{#i.workflowDataDef.wfdatadefid}" /></td>
					<td><s:property value="%{#i.wfdataid}" /></td>
					<s:if test="%{#i.workflowDataDef.isreadonly == 0}">
						<s:textfield name="%{#i.value}" label="%{#i.workflowDataDef.name}" />
					</s:if>
					<s:else>
						<s:label value="%{#i.workflowDataDef.constantvalue}"
							label="%{#i.workflowDataDef.name}"></s:label>
					</s:else>
				</s:iterator>
 --%>
				<s:select name="actionid" list="actions" headerKey="-1"
					headerValue="--Select Action--" listKey="actionid"
					listValue="actionname" label="Action" required="true"></s:select>
				<s:hidden name="cmd" value="submitworkflow">
				</s:hidden>
				<s:submit name="submit" id="mysubmit" value="Submit Workflow"
					align="center" />
			</s:form>
		</div>
	</div>

	<div id="templatemo_footer_wrapper">
		<div id="templatemo_footer">

			Copyright © 2048 <a href="#">3-Idiots web solutions</a> - Designed by
			<a href="http://www.templatemo.com" target="_parent">Damn Mads
				JSP Team</a>

		</div>
		<!-- end of footer wrapper -->
	</div>
	<!-- end of footer -->

</div>

</body>
</html>
