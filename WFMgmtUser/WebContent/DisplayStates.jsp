<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <div id="templatemo_middle">
    
    	<div id="intro">
        	<h2>States</h2>
            <p>This is a page that list all the states of the Workflow</p>
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
<td id="label">State ID</td>

<td id="label">State Name</td>
<td id="label">State Description</td>

<td id="label">More</td>
</tr>

<tr>

					<s:iterator value="workflowTypes" var="wf">
					 <tr><td><s:property value="#wf.wfTypeDetails.state.stateid" /></td>
					 <td><s:property value="#wf.wfTypeDetails.state.statename" /></td>
					 <td><s:property value="#wf.wfTypeDetails.state.statedescription" /></td></tr>
					</s:iterator>	

</tr>
</table>

