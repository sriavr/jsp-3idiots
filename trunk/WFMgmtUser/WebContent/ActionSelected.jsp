<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="templatemo_middle">

	<div id="intro">
		<h2>Confirmation Page</h2>
		<p>This is a page that list all the members of the Workflow</p>
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
			<p>This is a confirmation page</p>
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
			<!-- <table>
				<tr>
					<td id="label">Instance ID</td>
					<td id="label">Owner Name</td>
					<td id="label">Workflow Name</td>
					<td id="label">Workflow Category Name</td>

					<td id="label">More</td>
				</tr>
			</table> -->

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
