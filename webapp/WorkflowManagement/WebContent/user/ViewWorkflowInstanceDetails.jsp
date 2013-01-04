<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*"%>
<html>
<head>
<link rel="stylesheet" href="">
<title>WorkFlow Management</title>
</head>

<body>
	<center>
		<h1>Workflow Instances list</h1>
	</center>

	<s:form action="viewworkflowinstance.action" method="post">
		<table>

			<tr>
				<td>
					<h4>Workflow Instance ID:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.wfinstanceid" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Instance Owner ID:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.ownerid" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Instance Owner Name:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.ownername" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Workflow Name:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.wfname" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Item Name:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.wfitemname" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Creation Datetime:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.creationdatetime" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Current State:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.state" />
					</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4>Current State Description:</h4>
				</td>
				<td>
					<h4>
						<s:property value="wfInstanceDetails.statedescription" />
					</h4>
				</td>
			</tr>


		</table>


		<table>
			<%
				ArrayList<Actions> actionnames = new ArrayList<Actions>();
					actionnames = Actions
							.selectall("where actionid in (select actionid from statesequencetable where roleid = (407))");
					for (int i = 0; i < actionnames.size(); i++) {
						Actions actionname = actionnames.get(i);
						int name = actionname.getActionid();
						String value = actionname.getActionname();
						System.out.println(name + " " + value);
			%>
			<tr>
				<td><input type="submit" name="<%=name%>"
					value="<%=value%>" width="30" /></td>
			</tr>
			<%
				}
			%>
		</table>



	</s:form>
</body>
</html>
