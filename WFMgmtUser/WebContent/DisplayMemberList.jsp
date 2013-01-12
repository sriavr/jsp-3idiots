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
	      <s:actionerror/>
	   </div>
	</s:if>


<table>
<tr>
<td id="label">MemberID</td>
<td id="label"> FName</td>
<td id="label"> LName</td>
<td id="label">EmailID</td>
<td id="label">Phone</td>
<td id="label">UserName</td>
<td id="label">Address</td>
<td id="label">More</td>
</tr>

<s:iterator value="wfTypeDetails.associatedMembers" var="i">
<tr>
				<td><s:property value="%{#i.memberid}" /></td>
				<td><s:property value="%{#i.fname}" /></td>
				<td><s:property value="%{#i.lname}" /></td>
				<td><s:property value="%{#i.emailid}" /></td>
				<td><s:property value="%{#i.phone}" /></td>
				<td><s:property value="%{#i.username}" /></td>
				<td><s:property value="%{#i.address}" /></td>
				<td><a
					href="<s:url action="viewmemberdetails.action">
				<s:param name="cmd">
				displaymemberdetails
				</s:param>
				<s:param name="memberid">
				%{#i.memberid}
				</s:param>
				</s:url>">Details
				</a></td>
</tr>
</s:iterator>
</table>

	</div>


