!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ocean Blue Template</title>

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

<script type="text/javascript">
$(window).load(function() {
	$('#slider').nivoSlider({
		effect:'random',
		slices:10,
		animSpeed:800,
		pauseTime:1600,
		startSlide:1, //Set starting Slide (0 index)
		directionNav:false,
		directionNavHide:false, //Only show on hover
		controlNav:false, //1,2,3...
		controlNavThumbs:false, //Use thumbnails for Control Nav
		pauseOnHover:true, //Stop animation while hovering
		manualAdvance:false, //Force manual transitions
		captionOpacity:0.6, //Universal caption opacity
		beforeChange: function(){},
		afterChange: function(){},
		slideshowEnd: function(){} //Triggers after all slides have been shown
	});
});
</script>

</head>
<body class="homepage">

<div id="templatemo_wrapper">
	<div id="templatemo_header">
    	

        
        <div id="search_box">
            <form action="#" method="get">
                <input type="text" value="Search" name="q" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                <input type="submit" name="Search" value="" id="searchbutton" title="Search" />
            </form>
        </div>
        
        <div class="cleaner"></div>
    </div>
    
    <div id="templatemo_menu">
        <ul>
            <li><a href="index.html" class="current">Home</a></li>
 
        </ul>    	
        <div class="cleaner"></div>
    </div> <!-- end of templatemo_menu -->
    
    <div id="templatemo_middle">
    
    	<div id="intro">
        	<h2>Pinnacle</h2>
          <p>XXXXXXXXXXXXXXXXXXXXXXxx</p>
            <a class="learn_more" href="#"></a>
        </div>
    
        <div id="slider">
            <a href="#"><img src="images/slideshow/01.jpg" alt="" title="Lorem ipsum dolor sit amet." /></a>
            <a href="#"><img src="images/slideshow/02.jpg" alt="" title="Nullam ante leo, consectetur eget.." /></a>
            <a href="#"><img src="images/slideshow/03.jpg" alt="" title="Suspendisse sit amet enim elit." /></a>
            <a href="#"><img src="images/slideshow/04.jpg" alt="" title="Nulla faucibus luctus quam eget placerat." /></a>
            <a href="#"><img src="images/slideshow/05.jpg" alt="" title="Phasellus aliquet viverra posuere. " /></a>
        </div>
	</div>
        
    <div id="templatemo_main">
    
    	<div class="col_w900">
        
            
        </div>
        
        <div class="col_w900 col_w900_last">
        
        	<div class="col_w420 lp_box float_l">

           	
            </div>
        
            <div class="col_w420 float_r">
            
            
            </div>
            
            
            
            <div class="cleaner"></div>
		</div>
        
        <div class="cleaner"></div>
    </div> <!-- end of main -->
        
</div> <!-- end of wrapper -->

<div id="templatemo_footer_wrapper">
	<div id="templatemo_footer">
    	
        Copyright © 2048 <a href="#">Your Company Name</a> - 
        Designed by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a>
    
    </div> <!-- end of footer wrapper -->
</div> <!-- end of footer -->

</body>
</html>