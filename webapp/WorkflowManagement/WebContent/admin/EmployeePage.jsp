<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h2>Welcome to Employee Information Form</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="employeeaction.action" method="post">
<table>
 <tr> <td> <h4> ID: <s:property value="memberid" /> </h4>  </td> </tr>
 <tr> <td> <h4> First Name: <s:property value="fname" /> </h4> </td> </tr>	
 <tr> <td> <h4> Last Name: <s:property value="lname" /> </h4> </td> </tr>   
 <tr> <td> <h4> Username: <s:property value="username" /> </h4> </td> </tr>      
 <tr> <td> <h4> Email ID: <s:property value="emailid" /> </h4> </td> </tr>
 <tr> <td> <h4> Phone: <s:property value="phone" /> </h4> </td> </tr>
 <tr> <td> <h4> Address: <s:property value="address" /> </h4> </td> </tr>   
 <tr> <td> <s:submit name = "submit" id="mysubmit" value="View Allocated Assets"
      align="center" /> </td> </tr>
 <tr> <td> <s:submit name = "submit" id="mysubmit" value="New Asset Request"
      align="center" /> </td> </tr>
       
</table>
</s:form>
</body>
</html>
