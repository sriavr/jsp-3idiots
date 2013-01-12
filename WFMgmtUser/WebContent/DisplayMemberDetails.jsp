<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
     <div id="templatemo_middle">
    
    	<div id="intro">
        	<h2>Member Details</h2>
            <p>This page display all the Member Details related to a particular instance</p>
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
<tr><td><b class="current">MemberID</b><td> <td><s:property value="member.memberid"/><td></tr>
<tr><td><b class="current">FName</b></td>  <td><s:property value="member.fname"/></td></tr>
<tr><td><b class="current">LName</b></td> <td><s:property value="member.lname"/></td></tr>
<tr><td><b class="current">EmailID</b><td> <td><s:property value="member.emailid"/><td></tr>
<tr><td><b class="current">Phone</b></td>  <td><s:property value="member.phone"/></td></tr>
<tr><td><b class="current">UserName</b></td> <td><s:property value="member.username"/></td></tr>
<tr><td><b class="current">UserName</b></td> <td><s:property value="member.address"/></td></tr>

</table>
</div>


