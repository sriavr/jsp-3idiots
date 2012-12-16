<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href=templatemo_style.css>
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h2>Add a Role</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="AddRole" method="post">
     <s:textfield name="rolename" label = "Role Name" id="myinput" 
      size="15" /> 
    <s:password name="description" label="Description" id="myinput"
      size="15" />
    <s:submit name = "submit" id="mysubmit" value="AddRole"
      align="center" />
</s:form>
</body>
</html>
