<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="templatemo_middle">
	<div id="intro">
		<h2>Display Actions</h2>
		<p>This page display all the Actions related to a particular instance</p>
	</div>
</div>

<div id="templatemo_main">
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<table>
		<tr>
			<td><b class="current">ActionID</b></td>
			<td>:<s:property value="" />
			</td>
		</tr>
		<tr>
			<td><b class="current">ActionName</b></td>
			<td>:<s:property value="" /></td>
		</tr>
		<tr>
			<td><b class="current">ActionDescription</b></td>
			<td>:<s:property value="" /></td>
		</tr>

	</table>
</div>

