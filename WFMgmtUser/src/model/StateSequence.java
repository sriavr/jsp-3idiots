package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class StateSequence {

	private int seqid;
	private WorkflowType workflowType = new WorkflowType();
	private Role role = new Role();
	private State prevState = new State();
	private State nextState = new State();
	private Action action = new Action();

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public State getPrevState() {
		return prevState;
	}

	public void setPrevState(State prevState) {
		this.prevState = prevState;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int update() {
		String updateSQL = "update statesequencetable " + "set wftypeid = '"
				+ workflowType.getWftypeid() + "', roleid = '"
				+ role.getRoleid() + "', previousstateid = '"
				+ prevState.getStateID() + "', nextstateid = '"
				+ nextState.getStateID() + "', actionid = '"
				+ action.getActionid() + "' where seqid = " + seqid;
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = "delete from statesequencetable where seqid = "
				+ seqid;
		// System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}

	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into statesequencetable "
				+ "(wftypeid, roleid, previousstateid, nextstateid, actionid ) "
				+ "values(" + workflowType.getWftypeid() + ", "
				+ role.getRoleid() + ", " + prevState.getStateID() + ", "
				+ nextState.getStateID() + ", " + action.getActionid() + ");";
		return DB.update(insertSQL);
	}

	public static ArrayList<StateSequence> selectall(String selectionModifier) {
		ArrayList<StateSequence> selection = new ArrayList<StateSequence>();
		ResultSet resultSet = null;
		String query = "select * from statesequencetable " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				StateSequence stateseq = new StateSequence();
				stateseq.seqid = resultSet.getInt("seqid");
				stateseq.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				stateseq.role.setRoleid(resultSet.getInt("roleid"));
				stateseq.prevState.setStateID(resultSet
						.getInt("previousstateid"));
				stateseq.nextState.setStateID(resultSet.getInt("nextstateid"));
				stateseq.action.setActionid(resultSet.getInt("actionid"));
				selection.add(stateseq);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static ArrayList<StateSequence> selectallwftype(int wftype) {
		ArrayList<StateSequence> selection = new ArrayList<StateSequence>();
		ResultSet resultSet = null;
		String query = "call display_state_sequences(" + wftype + ");";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				StateSequence stateseq = new StateSequence();
				stateseq.seqid = resultSet.getInt("seqid");
				stateseq.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				stateseq.workflowType.setWfname(resultSet.getString("wfname"));
				stateseq.workflowType.setDescription(resultSet
						.getString("wfdescription"));
				stateseq.role.setRoleid(resultSet.getInt("roleid"));
				stateseq.role.setRolename(resultSet.getString("rolename"));
				stateseq.role.setRoledescription(resultSet
						.getString("roledescription"));
				stateseq.prevState.setStateID(resultSet
						.getInt("prevstateid"));
				stateseq.prevState.setStateName(resultSet
						.getString("prevstatename"));
				stateseq.prevState.setStateDescription(resultSet
						.getString("prevstatedescription"));
				stateseq.nextState.setStateID(resultSet.getInt("nextstateid"));
				stateseq.nextState.setStateName(resultSet
						.getString("nextstatename"));
				stateseq.nextState.setStateDescription(resultSet
						.getString("nextstatedescription"));
				stateseq.action.setActionid(resultSet.getInt("actionid"));
				stateseq.action
						.setActionname(resultSet.getString("actionname"));
				stateseq.action.setActiondescription(resultSet
						.getString("actiondescription"));
				selection.add(stateseq);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static StateSequence selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from statesequencetable " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				StateSequence stateseq = new StateSequence();
				stateseq.seqid = resultSet.getInt("seqid");
				stateseq.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				stateseq.role.setRoleid(resultSet.getInt("roleid"));
				stateseq.prevState.setStateID(resultSet
						.getInt("previousstateid"));
				stateseq.nextState.setStateID(resultSet.getInt("nextstateid"));
				stateseq.action.setActionid(resultSet.getInt("actionid"));
				DB.close(resultSet);
				DB.close(connection);
				return stateseq;
			}
		} catch (SQLException e) {
			// MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public void clear() {
		this.action = new Action();
		this.nextState = new State();
		this.prevState = new State();
		this.role = new Role();
		this.seqid = 0;
		this.workflowType = new WorkflowType();
	}
}
