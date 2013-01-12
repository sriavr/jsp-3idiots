package action;

import java.util.ArrayList;

import model.WorkflowCategory;
import model.WorkflowDataDef;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddWorkflowDatadefAction extends ActionSupport {
	WorkflowType wfType = new WorkflowType();
	WorkflowDataDef wfDatadef = new WorkflowDataDef();
	ArrayList<WorkflowDataDef> wfDatadefs = new ArrayList<WorkflowDataDef>();
	boolean isreadonly = true;

	public boolean isIsreadonly() {
		return isreadonly;
	}

	public void setIsreadonly(boolean isreadonly) {
		this.isreadonly = isreadonly;
	}

	public WorkflowDataDef getWfDatadef() {
		return wfDatadef;
	}

	public void setWfDatadef(WorkflowDataDef wfDatadef) {
		this.wfDatadef = wfDatadef;
	}

	public ArrayList<WorkflowDataDef> getWfDatadefs() {
		return wfDatadefs;
	}

	public void setWfDatadefs(ArrayList<WorkflowDataDef> wfDatadefs) {
		this.wfDatadefs = wfDatadefs;
	}

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	@Override
	public String execute() throws Exception {
		if (isreadonly) {
			wfDatadef.setIsreadonly(1);
		} else {
			wfDatadef.setIsreadonly(0);
			wfDatadef.setConstantvalue("");
		}
		System.out.println("Inside AddWorkflowDatadefAction");
		System.out.println("Before insertion into db");
		System.out.println("DatadefName: " + wfDatadef.getName());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());

		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		if (wfType != null && wfType.getWftypeid() != 0) {
			wfDatadef.setWftypeid(wfType.getWftypeid());
			if (wfDatadef.getName() != null
					&& !(wfDatadef.getName().equals(""))) {
				wfDatadef.insert();
			}
			wfDatadefs = WorkflowDataDef.selectall(wfType.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
		}

		System.out.println("After insertion into db");
		System.out.println("DatadefName: " + wfDatadef.getName());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		wfDatadef.setName("");
		wfDatadef.setDescription("");
		wfDatadef.setIsreadonly(1);
		isreadonly = true;
		wfDatadef.setConstantvalue("");
		return SUCCESS;
	}
}
