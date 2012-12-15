<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="mystyle.css">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to Workflow Management</h1></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="login" method="post">
	<s:select label="Select User" name="user" headerValue="--SelectUser--" headerKey="1" list="{'Administrator','Member'}" />
   
    <s:textfield name="username" label = "User ID" id="myinput" 
      size="15" />
    <s:password name="password" label="Password" id="myinput"
      size="15" />
    <s:submit name = "submit" id="mysubmit" value="Login"
      align="center" />
</s:form>
</body>
</html>
