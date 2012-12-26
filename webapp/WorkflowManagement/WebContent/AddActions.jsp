<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import ="action.* , models.*" %>
<%@ taglib  prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD AN ACTION</title>
</head>
<body>

<center><h1>Add an Action</h1></center><br/>
<s:form  action="addactions.action"  method="post">


<s:textfield name="wftypeid"  label="WFType ID"  id="myinput" value="%{wftypeid}" size="20" />

<s:textfield name="actionname"  label="Action Name"  id="myinput"  size="20 " />
<s:textfield name="actiondescription"  label="Action Description"  id="myinput"  size="20" />
<s:submit name="submit" value="Add Action"  width="30" align="left"/>
<s:submit name="submit" value="View Action"  width="30" align="left"/>
</s:form>
<a href="logout" id="myinput" >LOGOUT</a>

</body>
</html>
