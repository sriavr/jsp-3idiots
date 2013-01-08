<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
  
<body>
<center><h2>Welcome to IT Asset Request Form</h2></center>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
<s:form action="assetallotment.action" method="post">	
   <select name="asset_category" id="assetcategory">
	<s:iterator value="assetcategory" var="i"> 
		<option value="${i}">${i}</option>
	</s:iterator>
   </select>
   <select name="asset_name" id="assetname">
	<s:iterator value="assetname" var="i"> 
		<option value="${i}">${i}</option>
	</s:iterator>
   </select>
    <s:submit name = "submit" id="mysubmit" value="Submit Request"
      align="center" />
    </s:form>
</body>
</html>
