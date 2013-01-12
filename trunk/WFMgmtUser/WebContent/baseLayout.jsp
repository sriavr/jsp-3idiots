<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
	type="text/javascript"></script>
<script src="script/jquery.nivo.slider.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>
<body class="homepage">

	<div id="templatemo_wrapper">
		<div id="templatemo_header">
			<tiles:insertAttribute name="myHeader" />
		</div>
		<div align="center">
			<table>
				<tr>
					<td id="templatemo_left"><tiles:insertAttribute name="myleft" />
					</td>
					<td id="templatemo_wrapper"><tiles:insertAttribute
							name="myBody" /></td>
				</tr>
			</table>
		</div>
	</div>
	<tiles:insertAttribute name="myFooter" />
</body>
</html>