package model;

public class WorkflowEvent {

	private int eventid;
	private WorkflowType workflowType = new WorkflowType();
	private StateSequence stateSequence = new StateSequence();
	//private Role role= new Role();
	private Action action = new Action();
	private String eventDateTime;
	private Member actor = new Member();
	private Member owner = new Member();

	
	
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	/*public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}*/

	public String getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public Member getActor() {
		return actor;
	}

	public void setActor(Member actor) {
		this.actor = actor;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public StateSequence getStateSequence() {
		return stateSequence;
	}

	public void setStateSequence(StateSequence stateSequence) {
		this.stateSequence = stateSequence;
	}

}
