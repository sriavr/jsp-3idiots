<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h2>Add a Role</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="addrole" method="post">
    <s:textfield name="wftypeid" label = "Workflow Type ID" id="myinput" 
      size="15" value="%{rolewftypeid}" />  
     <s:textfield name="rolename" label = "Role Name" id="myinput" 
      size="15" /> 
    <s:textfield name="roledescription" label="Description" id="myinput"
      size="15" />
    <s:submit name = "submit" id="mysubmit" value="Add Role"
      align="left" />
    <s:submit name = "submit" id="mysubmit" value="View Role List"
      align="left" />

       <s:submit name = "submit" id="mysubmit" value="Next"
      align="left" />

   

    
</s:form>
</body>
</html>
