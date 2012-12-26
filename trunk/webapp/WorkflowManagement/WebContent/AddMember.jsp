<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h2>Add a Member</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="addmember" method="post">
	
    <s:textfield name="roleid" label = "Role ID" id="myinput" value="%{memberroleid}"
      size="15" />
    <s:textfield name="fname" label = "First Name" id="myinput" 
      size="15" />
    <s:textfield name="lname" label = "Last Name" id="myinput" 
      size="15" />  
    <s:textfield name="emailid" label = "Email ID" id="myinput" 
      size="15" /> 
    <s:textfield name="phone" label = "Phone" id="myinput" 
      size="15" />
    <s:textfield name="username" label="Username" id="myinput"
      size="15" />
    <s:password name="password" label="Password" id="myinput"
      size="15" /> 
    <s:textfield name="address" label="Address" id="myinput"
      size="15" />
    <s:submit name = "submit" id="mysubmit" value="Add Member"
      align="center" />
      <s:submit name = "submit" id="mysubmit" value="View Member List"
      align="left" />
       <s:submit name = "submit" id="mysubmit" value="Next"
      align="right" />
</s:form>
</body>
</html>
