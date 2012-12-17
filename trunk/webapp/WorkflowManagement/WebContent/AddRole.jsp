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
    <s:textfield name="roleid" label = "Role ID" id="myinput" 
      size="15" />
    <s:textfield name="wftypeid" label = "Workflow Type ID" id="myinput" 
      size="15" /> 
    <s:textfield name="rolename" label = "Role Name" id="myinput" 
      size="15" /> 
    <s:textfield name="description" label="Description" id="myinput"
      size="15" />
    <s:submit name = "submit" id="mysubmit" value="AddRole"
      align="center" />
</s:form>
</body>
</html>
