<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib  prefix="s"  uri="/struts-tags" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h2>Add Workflow Data</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="addworkflowdata" method="post">
		<select name="workflow_names" id="workflownames">
			<s:iterator value="workflownames" var="i"> 
				<option value="${i}">${i}</option>
			</s:iterator>
   		</select>  
     	<s:textfield name="name" label = "Name" id="myinput" 
      	size="15" /> 
    	<s:textfield name="description" label="Description" id="myinput"
      	size="15" />	
		<s:textfield name="value" label="Value" id="myinput"
      	size="15" />
      	<select name="workflow_instances" id="workflowinstances">
			<s:iterator value="workflowinstances" var="i"> 
				<option value="${i}">${i}</option>
			</s:iterator>
   		</select>
		<s:checkbox name = "isreadonly" value = "isreadonly" id="myinput" 
      	size="15" />
    
    <s:submit name = "submit" id="mysubmit" value="Add Workflow Data"
      align="center" />
    <s:submit name = "submit" id="mysubmit" value="View Workflow Data"
      align="center" />  
    <s:submit name = "submit" id="mysubmit" value="Next"
      align="center" /> 
</s:form>
</body>
</html>
