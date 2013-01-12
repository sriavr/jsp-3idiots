<%@page import="model.Member"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	int wftypeid = 0;
	Member loggedInUser;
	boolean isLoggedIn = false;
	if (session != null) {
		loggedInUser = (Member) session.getAttribute("memberloggedin");
		if (loggedInUser != null) {
			isLoggedIn = true;
			wftypeid = loggedInUser.getRole().getWorkflowType()
					.getWftypeid();
		} else {
			isLoggedIn = false;
		}
	} else {
		isLoggedIn = false;
	}
%>
<div id="leftmenu_wrapper">
	<div id="leftmenu">


		<div id="leftmenu_title">
			<a href="<s:url action="logout.action"/>">Logout</a>
		</div>

		<div id="leftmenu_title">
			<a
				href="<s:url action="createworkflowinstance.action">
						<s:param name="cmd">
							createworkflowinstance
						</s:param>
						
						<s:param name="wftypeid">
							<%=wftypeid%>
						</s:param> 
					</s:url>">
				Create Workflow Instance</a>
		</div>
		<br />


		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
						<s:param name="cmd">
							displayinstances_member
						</s:param>
		
						<s:param name="wftypeid">
							<%=wftypeid%>
						</s:param> 
					</s:url>">View
				Instance List for Member</a>
		</div>

		<div id="leftmenu_title"></div>
		<br />
		<div class="cleaner"></div>
	</div>


	<div class="cleaner"></div>
	<!-- </div> <!-- end of templatemo_menu -->
</div>
<br>