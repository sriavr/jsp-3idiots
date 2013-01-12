<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
	type="text/javascript"></script>
<script src="script/jquery.nivo.slider.js" type="text/javascript"></script>

<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider({
			effect : 'random',
			slices : 10,
			animSpeed : 800,
			pauseTime : 1600,
			startSlide : 1, //Set starting Slide (0 index)
			directionNav : false,
			directionNavHide : false, //Only show on hover
			controlNav : false, //1,2,3...
			controlNavThumbs : false, //Use thumbnails for Control Nav
			pauseOnHover : true, //Stop animation while hovering
			manualAdvance : false, //Force manual transitions
			captionOpacity : 0.6, //Universal caption opacity
			beforeChange : function() {
			},
			afterChange : function() {
			},
			slideshowEnd : function() {
			} //Triggers after all slides have been shown
		});
	});
</script>

</head>
<body class="subpage">

	<div id="templatemo_wrapper">

		<div id="templatemo_header">

			<div id="site_title">
				<h1>Generic Workflow Management System -- User page</h1>
			</div>

			<div class="cleaner"></div>
		</div>

		<div id="templatemo_menu">
			<ul>
				<li><a href="Login.jsp" class="current">Home</a></li>
				<!--  <li><a href="contact.html">Contact</a></li> -->
			</ul>
			<div class="cleaner"></div>
		</div>
		<!-- end of templatemo_menu -->

		<div id="templatemo_middle_subpage">
			<h2>Workflow Instance List of Member</h2>
			<p>This is a page that list all the members of the Workflow</p>
		</div>


		<div id="templatemo_main">
			<div class="col_w900 col_w900_last">


				<s:if test="hasActionErrors()">
					<div class="errors">
						<s:actionerror />
					</div>
				</s:if>
				<table>
					<tr>
						<td id="label">Instance ID</td>
						<td id="label">Owner Name</td>
						<td id="label">Created on</td>
						<td id="label">Workflow Name</td>
						<td id="label">Current Status</td>
						<td id="label">More</td>
					</tr>


					<s:iterator value="wfTypeDetails.associatedWorkflowInstances"
						var="i">
						<tr>
							<td><s:property value="%{#i.wfinstanceid}" /></td>
							<td><s:property value="%{#i.owner.fname}" /> <s:property
									value="%{#i.owner.lname}" /></td>
							<td><s:property value="%{#i.creationdatetime}" /></td>
							<td><s:property value="%{#i.workflowType.wfname}" /></td>
							<td><s:property value="%{#i.currentstate.stateName}" /></td>
							<td><a class="learn_more"
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

				<table>
					<tr>
						<td align="left"><a class="learn_more"
							href="<s:url action="createworkflowinstance.action" includeContext="true">
				<s:param name="cmd" >
				createworkflowinstance
				</s:param>
				</s:url>">Create
								Workflow Instance </a></td>
					</tr>

				</table>
			</div>
		</div>

		<!-- <div id="templatemo_footer_wrapper"> -->
		<div id="templatemo_footer">

			Copyright © 2013 <a href="#">International Institute of
				Information Technology, Bangalore</a> - Designed by <a
				href="http://www.templatemo.com" target="_parent">Free CSS
				Templates</a>

		</div>
		<!-- end of footer wrapper -->
		<!-- </div> -->
		<!-- end of footer -->
	</div>
</body>
</html>
