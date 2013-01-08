package action;

import model.WorkflowInstanceDetails;

import com.opensymphony.xwork2.ActionSupport;

public class DELETEMEViewWorkflowInstanceDetailsAction extends ActionSupport {

	private static final long serialVersionUID = 420895073712746467L;

	private int wfinstanceid;

	private WorkflowInstanceDetails wfInstanceDetails;

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}

	public WorkflowInstanceDetails getWfInstanceDetails() {
		return wfInstanceDetails;
	}

	public void setWfInstanceDetails(WorkflowInstanceDetails wfInstanceDetails) {
		this.wfInstanceDetails = wfInstanceDetails;
	}

	@Override
	public String execute() throws Exception {
		if (wfinstanceid == 0) {
			addActionError(getText("No instance selected"));
			return ERROR;
		}
		wfInstanceDetails = WorkflowInstanceDetails.selectone(wfinstanceid);

		return SUCCESS;
	}

}
