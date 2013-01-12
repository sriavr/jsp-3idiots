package action;

import java.util.ArrayList;

import model.Action;
import model.Role;
import model.WorkflowCategory;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private WorkflowType wfType = new WorkflowType();
	private ArrayList<Action> actions = new ArrayList<Action>();
	private Action action = new Action();

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Inside AddAction");
		System.out.println("Before insertion into db");
		System.out.println("ActionName: " + action.getActionname());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());

		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		if (wfType != null && wfType.getWftypeid() != 0) {
			action.getWorkflowType().setWftypeid(wfType.getWftypeid());
			if (action.getActionname() != null
					&& !action.getActionname().equals("")) {
				action.insert();
			}
			actions = Action.selectallwftype(wfType.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
		}

		System.out.println("After insertion into db");
		System.out.println("ActionName: " + action.getActionname());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		action.setActionname("");
		action.setActiondescription("");
		action.getWorkflowType().setWfname("");
		action.getWorkflowType().setDescription("");
		action.getWorkflowType().setWftypeid(0);
		return SUCCESS;
	}
}
