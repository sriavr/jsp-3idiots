package action;

import java.util.ArrayList;

import model.WorkflowType;
import model.WorkflowTypeDetails;

import com.opensymphony.xwork2.ActionSupport;

public class WorkflowAppAction extends ActionSupport {
	private ArrayList<WorkflowType> workflowTypes = new ArrayList<WorkflowType>();
	private String cmd;

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public ArrayList<WorkflowType> getWorkflowTypes() {
		return workflowTypes;
	}

	public void setWorkflowTypes(ArrayList<WorkflowType> workflowTypes) {
		this.workflowTypes = workflowTypes;
	}

	@Override
	public String execute() throws Exception {
		workflowTypes = new ArrayList<WorkflowType>();
		if (cmd.equals("displaytypes")) {
			workflowTypes = WorkflowType.selectall("");
			for(int i=0;i<workflowTypes.size();i++)	
				System.out.println(workflowTypes.get(i).getWftypeid()+workflowTypes.get(i).getWfname()+workflowTypes.get(i).getDescription());
			return "displaytypes";
		}
		return ERROR;
	}
}
