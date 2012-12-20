<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>
 
<body>
<center><h1>Welcome to Admin Page</h1></center>
<center><h4>This is admin page..click next to continue!</h4></center>
<s:form action="adminfunctions.action" method="post">
	<s:submit name ="submit" id="mysubmit" value="Next" align="center" width="30" />
</s:form>
<a href="logout" id="mysubmit">Logout</a>
</body>
</html>
