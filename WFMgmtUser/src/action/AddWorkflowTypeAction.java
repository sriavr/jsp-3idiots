package action;

import java.util.Stack;

import model.State;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddWorkflowTypeAction extends ActionSupport {
	WorkflowType wfType = new WorkflowType();

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Inside AddWorkflowTypeAction");
		if (wfType.getWfname() == null) {
			return "home";
		}

		System.out.println("Before insertion into db");
		System.out.println("WorkflowName: " + wfType.getWfname()
				+ "WorkflowDescription: " + wfType.getDescription());
		int wftypeid = 0;
		if (wfType.getWfname() != null && !wfType.getWfname().equals("")) {
			wftypeid = wfType.insert();
		}
		if (wftypeid != 0) {
			ActionContext.getContext().getSession().put("currwftype", wfType);
		} else {
			addActionError("Workflow Type did not get saved into database");
			System.out.println("Workflow Type did not get saved into database");
			return ERROR;
		}

		State defaultState = new State();
		defaultState.getWorkflowType().setWftypeid(wftypeid);
		defaultState.setStateDescription("This workflowitem gets added automatically");
		defaultState.setStateName("default");
		defaultState.insert();
		
		System.out.println("After insertion into db");
		System.out.println("WorkflowName: " + wfType.getWfname()
				+ "WorkflowDescription: " + wfType.getDescription());

		return SUCCESS;
	}
}
