<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
</head>
<body>

	<s:form></s:form>
	<s:text name="wftypeid"></s:text>
	<s:text name="memberid"></s:text>
	<s:text name="wfinstanceid"></s:text>
	<a
		href="<s:url action="user/workflow/viewtypedetails.action">
		<s:param name="cmd">
		displaytypedetails
		</s:param>
		<s:param name="wftypeid">1
		</s:param>
	</s:url>">View
		Workflow Type Details</a>

	<a
		href="<s:url action="user/workflow/viewtypelist.action">
		<s:param name="cmd">
		displaytypes
		</s:param>
	</s:url>">View
		Workflow Types List</a>

	<a
		href="<s:url action="user/workflow/instance/viewinstancedetails.action">
		<s:param name="cmd">
		displayinstancedetails
		</s:param>
		<s:param name="wfinstanceid">11
		</s:param>
	</s:url>">View
		Instance Details</a>


	<a
		href="<s:url action="user/workflow/instance/viewinstancelist.action">
		<s:param name="cmd">
		displayinstances
		</s:param>
		<s:param name="wftypeid">1
		</s:param>
	</s:url>">View
		Instance List</a>


	<a
		href="<s:url action="user/workflow/instance/vieweventhistory.action">
		<s:param name="cmd">
		displayeventhistory
		</s:param>
		<s:param name="wfinstanceid">11
		</s:param>
	</s:url>">View
		Event History</a>
	<a
		href="<s:url action="user/workflow/instance/viewinstancedetails.action">
		<s:param name="cmd">
		displayworkflowinstancedata
		</s:param>
		<s:param name="wfinstanceid">11
		</s:param>
	</s:url>">View
		Workflow Data</a>

	<a
		href="<s:url action="user/workflow/viewmemberlist.action">
		<s:param name="cmd">
		displaymembers
		</s:param>
		<s:param name="wftypeid">1
		</s:param>
	</s:url>">View
		Member List</a>


	<a
		href="<s:url action="user/workflow/viewrolelist.action">
		<s:param name="cmd">
		displayroles
		</s:param>
		<s:param name="wftypeid">1
		</s:param>
	</s:url>">View
		Role List</a>

</body>
</html>