<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
  <div id="templatemo_middle">
    
    	<div id="intro">
        	<h2>Role Details</h2>
            <p>This is a page that display the role details </p>
            <a class="learn_more" href="#"></a>
        </div>
   	</div>
	
<div id="templatemo_main">    
    <s:if test="hasActionErrors()">
	   <div class="errors">
	      <s:actionerror/>
	   </div>
	</s:if>

<table>
<tr>
<td id="label">RoleID</td>
<td id="label"> Role Name</td>
<td id="label"> Description</td>
</tr>
				<td><s:property value="%{roleid}" /></td>
				<td><s:property value="%{rolename}" /></td>
				<td><s:property value="%{roledescription}" /></td>
</table>
</pre>
</body>
</html>