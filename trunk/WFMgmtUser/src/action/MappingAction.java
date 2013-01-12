package action;

import java.math.BigDecimal;
import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MappingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private StateSequence stateSeq = new StateSequence();
	private ArrayList<StateSequence> stateSeqs = new ArrayList<StateSequence>();
	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	private ArrayList<State> states = new ArrayList<State>();
	private ArrayList<Role> roles = new ArrayList<Role>();
	private ArrayList<Action> actions = new ArrayList<Action>();

	public StateSequence getStateSeq() {
		return stateSeq;
	}

	public void setStateSeq(StateSequence stateSeq) {
		this.stateSeq = stateSeq;
	}

	public ArrayList<StateSequence> getStateSeqs() {
		return stateSeqs;
	}

	public void setStateSeqs(ArrayList<StateSequence> stateSeqs) {
		this.stateSeqs = stateSeqs;
	}

	public String execute() {
		System.out.println("Inside MappingAction");
		System.out.println("Before insertion into db");
		System.out.println("PrevStateID: "
				+ stateSeq.getPrevState().getStateID() + " NextStateID: "
				+ stateSeq.getNextState().getStateID() + " ActionID:"
				+ stateSeq.getAction().getActionid() + " RoleID:"
				+ stateSeq.getRole().getRoleid() + " WFTypeID:"
				+ stateSeq.getWorkflowType().getWftypeid());
		stateSeq.setWorkflowType((WorkflowType) ActionContext.getContext()
				.getSession().get("currwftype"));
		if (stateSeq.getWorkflowType().getWftypeid() != 0) {
			if (stateSeq.getAction().getActionid() != 0
					&& stateSeq.getRole().getRoleid() != 0
					&& stateSeq.getPrevState().getStateID() != 0
					&& stateSeq.getNextState().getStateID() != 0) {
				stateSeq.insert();
			} else {
				addActionError("required details missing");
			}
			stateSeqs = StateSequence.selectallwftype(stateSeq
					.getWorkflowType().getWftypeid());
			roles = Role.selectallwftypeid(stateSeq.getWorkflowType()
					.getWftypeid());
			actions = Action.selectallwftype(stateSeq.getWorkflowType()
					.getWftypeid());
			states = State.selectallwftypeid(stateSeq.getWorkflowType()
					.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
			return ERROR;
		}

		System.out.println("After insertion into db");
		System.out.println("PrevStateID: "
				+ stateSeq.getPrevState().getStateID() + " NextStateID: "
				+ stateSeq.getNextState().getStateID() + " ActionID:"
				+ stateSeq.getAction().getActionid() + " RoleID:"
				+ stateSeq.getRole().getRoleid() + " WFTypeID:"
				+ stateSeq.getWorkflowType().getWftypeid());
		stateSeq.clear();
		return SUCCESS;
	}

}
