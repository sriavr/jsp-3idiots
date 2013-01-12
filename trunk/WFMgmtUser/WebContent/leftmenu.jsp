<%@ taglib prefix="s" uri="/struts-tags"%>
<center>
	<div id="leftmenu_wrapper"></div>
	<div id="leftmenu">
		<div>
			<a class="learn_more"
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displaytypedetails
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				Workflow Type Details</a>
		</div>
		<br />
		<div>
			<a class="learn_more"
				href="<s:url action="viewtypelist.action">
		<s:param name="cmd">
		displaytypes
		</s:param>
	</s:url>">View
				Workflow Types List</a>
		</div>
		<br />
		<div id="leftmenu_title">
			<a
				href="<s:url action="viewinstancedetails.action">
		<s:param name="cmd">
		displayinstancedetails
		</s:param>
		<s:param name="wfinstanceid">%{wfinstanceid}
		</s:param>
	</s:url>">View
				Instance Details</a>
		</div>
		<br />

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displayinstances
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				Instance List</a>
		</div>
		<br />
		<div id="leftmenu_title">
			<a
				href="<s:url action="viewinstancedetails.action">
		<s:param name="cmd">
		displayeventhistory
		</s:param>
		<s:param name="wfinstanceid">%{wfinstanceid}
		</s:param>
	</s:url>">View
				Event History</a>
		</div>
		<br />

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewinstancedetails.action">
		<s:param name="cmd">
		displayworkflowinstancedata
		</s:param>
		<s:param name="wfinstanceid">%{wfinstanceid}
		</s:param>
	</s:url>">View
				Workflow Data</a>
		</div>
		<br>

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displaymembers
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				Member List</a>
		</div>
		<br />

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displayroles
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				Role List</a>
		</div>
		<br />

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displayactions
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				Actions List</a>
		</div>
		<br />

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displaystates
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				States List</a>
		</div>
		<br />

		<div id="leftmenu_title">
			<a
				href="<s:url action="viewtypedetails.action">
		<s:param name="cmd">
		displaystatesequence
		</s:param>
		<s:param name="wftypeid">%{wftypeid}
		</s:param>
	</s:url>">View
				State Sequence</a>
		</div>
		<br />

	</div>


	<div class="cleaner"></div>
	<!-- </div> <!-- end of templatemo_menu -->


</center>
<br>