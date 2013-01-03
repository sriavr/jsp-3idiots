
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD WORKFLOW ITEM</title>
</head>
<body>
<table>
<tr><td>
<s:form method="post" action="workflowitem.action"></td></tr>
<tr><td><s:hidden name="wfid"  value="%{wftypeid}"></s:hidden></td></tr>
<tr><td><s:textfield label="WFItemType"  name= "wfitemtype"></s:textfield></td></tr>
<tr><td><s:textfield label="WFItemCategory" name="wfitemcategory"></s:textfield></td></tr>
<tr><td><s:textfield label="WFItemName" name="wfitemname"></s:textfield></td></tr>
<tr><td><s:textfield label="QuantityAvail" name="quantityavail"></s:textfield></td></tr>


<s:submit name = "submit" id="mysubmit" value="Add Item" align="center" width="30"/>
<s:submit name = "submit" id="mysubmit" value="Next" align="center" width="30"/>
<s:submit name = "submit" id="mysubmit" value="View Item List" align="center" width="30"/>
</s:form>
</table>
</body>
</html>