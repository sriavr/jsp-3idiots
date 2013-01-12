<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
     <div id="templatemo_middle">
    
    	<div id="intro">
        	<h2>Workflow Data Def</h2>
            <p>This is a page that display Workflow Data Def</p>
            <a class="learn_more" href="#"></a>
        </div>
</div>
	
<div id="templatemo_main">    
    <div class="col_w900">
    	
    
	<s:if test="hasActionErrors()">
	   <div class="errors">
	      <s:actionerror/>
	   </div>
	</s:if>


<table>
<tr>

<td id="label">WorkflowDataDefID</td>
<td id="label">Name</td>
<td id="label">Value</td>
<td id="label">More</td>
</tr>

<tr>
<s:iterator value="" var="i">
				
				
				
				
				
				
				
</s:iterator>
</tr>
</table>
	</div>
</div>

<div id="templatemo_footer_wrapper">
	<div id="templatemo_footer">
    	
        Copyright © 2048 <a href="#">3-Idiots web solutions</a> - 
        Designed by <a href="http://www.templatemo.com" target="_parent">Damn Mads JSP Team</a>
    
    </div> <!-- end of footer wrapper -->
</div> <!-- end of footer -->

</div>

</body>
</html>
