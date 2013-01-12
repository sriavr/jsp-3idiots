package action;

import model.*;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WorkflowTypeAction extends ActionSupport {
	private int wftypeid;
	private String cmd = "";
	private String submit = "";
	private WorkflowTypeDetails wfTypeDetails = new WorkflowTypeDetails();
	private ArrayList<WorkflowType> wfTypes = new ArrayList<WorkflowType>();
	private ArrayList<WorkflowCategory> wfitems = new ArrayList<WorkflowCategory>();
	private WorkflowCategory wfCategory = new WorkflowCategory();

	public ArrayList<WorkflowCategory> getWfitems() {
		return wfitems;
	}

	public void setWfitems(ArrayList<WorkflowCategory> wfitems) {
		this.wfitems = wfitems;
	}

	public ArrayList<WorkflowType> getWfTypes() {
		return wfTypes;
	}

	public void setWfTypes(ArrayList<WorkflowType> wfTypes) {
		this.wfTypes = wfTypes;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wfTypeId) {
		this.wftypeid = wfTypeId;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public WorkflowTypeDetails getWfTypeDetails() {
		return wfTypeDetails;
	}

	public void setWfTypeDetails(WorkflowTypeDetails wfTypeDetails) {
		this.wfTypeDetails = wfTypeDetails;
	}

	public String execute() throws Exception {
		if (cmd == null)
			cmd = "";
		System.out.println("Inside WorkflowTypeAction");
		System.out.println("wftype id " + wftypeid);
		System.out.println("WorkflowName: "
				+ wfTypeDetails.getWorkflowType().getWfname()
				+ "WorkflowDescription: "
				+ wfTypeDetails.getWorkflowType().getDescription() + " cmd:"
				+ cmd);
		if (wftypeid != 0) {
			wfTypeDetails = WorkflowTypeDetails.selectone(wftypeid);
			this.setWfTypeDetails(wfTypeDetails);

//			wfTypes = WorkflowType.selectall("");
			wfitems = WorkflowCategory.selectall(wftypeid);
		}

		if (cmd.equals("displaytypedetails")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaytypedetails";
		}

		else if (cmd.equals("displayinstances")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displayinstances";
		}

		else if (cmd.equals("displayinstances_member")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displayinstances_member";
		}
		
		else if (cmd.equals("displaymembers")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaymembers";
		}

		else if (cmd.equals("displayroles")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displayroles";
		}
		else if (cmd.equals("displayactions")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displayactions";
		}
		else if (cmd.equals("displaystates")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaystates";
		}

		else if (cmd.equals("displaystatesequence")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaystatesequence";
		}
		else if (cmd.equals("createworkflowtype")) {

			return "createworkflowtype";
		}

		/*
		 * else if (cmd.equals("addwfcategory")) { if
		 * (wfTypeDetails.getWorkflowType().getWftypeid() == 0) { wftypeid =
		 * wfTypeDetails.getWorkflowType().insert(); }
		 * System.out.println("wftypename" +
		 * wfTypeDetails.getWorkflowType().getWfname()); return "addwfcategory";
		 * }
		 */

		else if (submit.startsWith("Create Workflow")) {
			System.out
					.println("Inside Create Workflow routine of WorkflowTypeAction, wftypeid:"
							+ wftypeid);
			if (wfTypeDetails.getWorkflowType().getWftypeid() == 0) {
				System.out.println("Before wftypid " + wftypeid);
				wfTypeDetails.getWorkflowType().setWfname(
						wfTypeDetails.getWorkflowType().getWfname());
				wfTypeDetails.getWorkflowType().setDescription(
						wfTypeDetails.getWorkflowType().getDescription());
				wftypeid = wfTypeDetails.getWorkflowType().insert();
				wfTypeDetails.getWorkflowType().setWftypeid(wftypeid);

				System.out.println("After insertion into db");
				System.out.println("WorkflowName: "
						+ wfTypeDetails.getWorkflowType().getWfname()
						+ "WorkflowDescription: "
						+ wfTypeDetails.getWorkflowType().getDescription()
						+ " cmd:" + cmd);
			}

			/*
			 * wfTypes = WorkflowType.selectall(""); for (int i = 0; i <
			 * wfTypes.size(); i++) { WorkflowType wf = wfTypes.get(i);
			 * System.out.println(wf.getWftypeid() + " " + wf.getWfname() + " "
			 * + wf.getDescription()); }
			 */

			return "addwfcategory";
		}

		else if (submit.startsWith("Add Workflow Category")) {
			wfCategory.setWftypeid(wftypeid);
			System.out
					.println("Inside Add Workflow Category routine of WorkflowTypeAction");
			System.out.println("category name "
					+ wfCategory.getWfcategoryname());
			wfCategory.insert();
			System.out.println("After insertion");
			return "addwfcategory";
		}
		return ERROR;
	}

	/**
	 * @return the wfCategory
	 */
	public WorkflowCategory getWfCategory() {
		return wfCategory;
	}

	/**
	 * @param wfCategory
	 *            the wfCategory to set
	 */
	public void setWfCategory(WorkflowCategory wfCategory) {
		this.wfCategory = wfCategory;
	};
}
