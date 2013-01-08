
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList,model.*, action.*" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body> 
<h2> <center>Displayed selected member is</center></h2>

<s:form   action="modifymember"  method ="post" >
<table>

	<tr><td><s:textfield name="memberid" label = "Member ID" id="myinput"  value="%{memberid}"
      size="15" /></td></tr>
<tr><td><s:textfield name="roleid" label = "Role ID" id="myinput"  value="%{roleid}"
      size="15" /></td></tr>
    <tr><td><s:textfield name="fname" label = "First Name" id="myinput" value="%{fname}"
      size="15" /></td></tr>
    <tr><td><s:textfield name="lname" label = "Last Name" id="myinput"  value="%{lname}" 
      size="15" /></td></tr>  
    <tr><td><s:textfield name="emailid" label = "Email ID" id="myinput"  value="%{emailid}"
      size="15" /></td></tr> 
    <tr><td><s:textfield name="phone" label = "Phone" id="myinput"  value="%{phone}"
      size="15" /></td></tr>
    <tr><td><s:textfield name="username" label="Username" id="myinput"  value="%{username}"
      size="15" /></td></tr>
    <tr><td><s:textfield name="password" label="Password" id="myinput"  value="%{password}"
      size="15" /></td></tr> 
    <tr><td><s:textfield name="address" label="Address" id="myinput"  value="%{address}"
      size="15" /></td></tr>
    <tr><td><s:submit name = "submit" id="mysubmit" value="Delete"   
      align="center" /></td></tr>
      <tr><td><s:submit name = "submit" id="mysubmit" value="Modify Member" 
      align="left" /></td></tr>

</table>
</s:form>
</body>
</html>