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
			</ul>
			<div class="cleaner"></div>
		</div>
		<!-- end of templatemo_menu -->

		<div id="templatemo_middle_subpage">
			<h1>Oops!! Something went wrong</h1>
			<h3 style="width:350px">Apologize for this problem. An unexpected error occurred in
				the System. Our team will get back to you soon.</h3>
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
