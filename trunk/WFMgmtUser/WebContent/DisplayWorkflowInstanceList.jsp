<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="templatemo_middle">

	<div id="intro">
		<h2>Member List</h2>
		<p>This is a page that list all the members of the Workflow</p>
		<a class="learn_more" href="#"></a>
	</div>
</div>

<div id="templatemo_main">
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>


	<div id="templatemo_middle">

		<div id="intro">
			<h2>Workflow Management Solutions</h2>
			<p>This is a generic app that creates and manages various
				workflows and specifies how the flow is from point to point through
				out</p>
			<a class="learn_more" href="#"></a>
		</div>

		<!--         <div id="slider"> -->
		<!--             <a href="#"><img src="images/slideshow/01.jpg" alt="" title="Lorem ipsum dolor sit amet." /></a> -->
		<!--             <a href="#"><img src="images/slideshow/02.jpg" alt="" title="Nullam ante leo, consectetur eget.." /></a> -->
		<!--             <a href="#"><img src="images/slideshow/03.jpg" alt="" title="Suspendisse sit amet enim elit." /></a> -->
		<!--             <a href="#"><img src="images/slideshow/04.jpg" alt="" title="Nulla faucibus luctus quam eget placerat." /></a> -->
		<!--             <a href="#"><img src="images/slideshow/05.jpg" alt="" title="Phasellus aliquet viverra posuere. " /></a> -->
		<!--         </div> -->
	</div>

	<div id="templatemo_main">
		<div class="col_w900">


			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror />
				</div>
			</s:if>
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


				<s:iterator value="wfTypeDetails.associatedWorkflowInstances"
					var="i">
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
							href="<s:url action="viewtypedetails.action" includeContext="false">
				<s:param name="cmd">
				displaytypedetails
				</s:param>
				<s:param name="wftypeid">
				%{#i.workflowType.wftypeid}
				</s:param>
				</s:url>">
								<s:property value="#i.workflowType.wfname" />
						</a></td>
						<%-- 				<td><s:property value="#i.workflowType.description" /></td> --%>


						<td><a
							href="<s:url action="viewinstancedetails.action" includeContext="true">
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
