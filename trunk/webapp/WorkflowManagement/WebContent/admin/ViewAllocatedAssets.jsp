<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h2>Welcome to List of Allocated Assets</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="employeeaction.action" method="post">	
 <table>
 <s:iterator value="assetcategory" var="i"> 
 <tr> <td> <h4> Asset Category: <s:property value="%{i.assetcategory}" /> </h4> </td> </tr>
 </s:iterator>
 
 <s:iterator value="assetname" var="i"> 	
 <tr> <td> <h4> Asset Name: <s:property value="%{i.assetname}" /> </h4> </td> </tr>
 </s:iterator>   
 </table>  
 
 
 <s:submit name = "submit" id="mysubmit" value="Back"
      align="center" />
 </s:form>
</body>
</html>
