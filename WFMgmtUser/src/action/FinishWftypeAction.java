package action;

import java.util.ArrayList;

import model.Action;
import model.Role;
import model.WorkflowCategory;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FinishWftypeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int wftypeid;

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	private WorkflowType wfType = new WorkflowType();

	@Override
	public String execute() throws Exception {
		System.out.println("Inside FinishWftypeAction");
		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		wftypeid = wfType.getWftypeid();
		System.out.println("wfType.getWftypeid(): " + wfType.getWftypeid()
				+ "WorkflowName: " + wfType.getWfname()
				+ "WorkflowDescription: " + wfType.getDescription()
				+ " wftypeid:" + wftypeid);

		if (wfType != null && wfType.getWftypeid() != 0) {
			ActionContext.getContext().getSession().remove(wfType);
		} else {
			addActionError("Workflow Type addition failed");
			return ERROR;
		}

		return SUCCESS;
	}
}
