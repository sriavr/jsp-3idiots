package action;

import java.util.ArrayList;

import model.Action;
import model.State;
import model.WorkflowCategory;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddStateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private WorkflowType wfType = new WorkflowType();
	private ArrayList<State> states = new ArrayList<State>();
	private State state = new State();

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Inside AddStateAction");
		System.out.println("Before insertion into db");
		System.out.println("StateName: " + state.getStateName());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());

		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		if (wfType != null && wfType.getWftypeid() != 0) {
			state.getWorkflowType().setWftypeid(wfType.getWftypeid());
			if (state.getStateName() != null
					&& !state.getStateName().equals("")) {
				state.insert();
			}
			states = State.selectallwftypeid(wfType.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
		}

		System.out.println("After insertion into db");
		System.out.println("StateName: " + state.getStateName());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		state.setStateName("");
		state.setStateDescription("");
		state.getWorkflowType().setWfname("");
		state.getWorkflowType().setDescription("");
		state.getWorkflowType().setWftypeid(0);
		return SUCCESS;
	}
}
