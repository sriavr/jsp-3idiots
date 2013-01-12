<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="script/jquery.nivo.slider.js" type="text/javascript"></script>


</head>
<body class="homepage">

<div id="templatemo_wrapper">
<!-- 	<div id="templatemo_header"> -->
    	
<!--         <div id="site_title"><h1>Workflow Management</h1></div> -->
        
        
        
<!--         <div class="cleaner"></div> -->
<!--     </div> -->
    
    <div id="templatemo_menu">
        <ul>
            <li><a href="Login.jsp" class="current">Home</a></li>
           <!--  <li><a href="contact.html">Contact</a></li> -->
        </ul>    	
        <div class="cleaner"></div>
    </div> <!-- end of templatemo_menu -->
    
     <div id="templatemo_middle">
    
    	<div id="intro">
            <p>This is a generic app that creates and manages various workflows and specifies how the flow is from point to point through out</p>
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
	<div>
	<img src="" alt=" HAVE TO ADD" />
	</div>
	
	
<div id="templatemo_main">    
    <div class="col_w900">
    	
    
	<s:if test="hasActionErrors()">
	   <div class="errors">
	      <s:actionerror/>
	   </div>
	</s:if>
<s:form name="contact_form" action="adminfunctions.action" method="post">
	<s:submit name ="submit" id="mysubmit" value="Next" align="center" width="30" />
</s:form>

</div>
</div>


</div>

</body>
</html>
