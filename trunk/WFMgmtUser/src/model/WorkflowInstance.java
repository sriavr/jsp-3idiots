package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class WorkflowInstance {

	private int wfinstanceid;
	private String creationdatetime;
	private Member owner = new Member();
	private WorkflowType workflowType = new WorkflowType();
	private State currentstate = new State();
	private WorkflowCategory wfcategory = new WorkflowCategory();

	private WorkflowEvent event = new WorkflowEvent();
	private Action action = new Action();

	public int update() {
		String updateSQL = "update workflowinstance " + "set memberid = '"
				+ owner.getMemberid() + "', wftypeid = '"
				+ workflowType.getWftypeid() + "', creationdatetime = '"
				+ creationdatetime + "', currentstate = '" + currentstate
				+ "', wfitemid = '" + wfcategory + "' where wfinstanceid = "
				+ wfinstanceid;
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = "delete from workflowinstance where wfinstanceid = "
				+ wfinstanceid;
		// System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}

	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowinstance "
				+ "(memberid,wftypeid, creationdatetime, currentstate, wfitemid ) "
				+ "values('" + owner.getMemberid() + "', '"
				+ workflowType.getWftypeid() + "', '" + creationdatetime
				+ "', '" + currentstate + "', '" + wfcategory + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowInstance> selectall(String selectionModifier) {
		ArrayList<WorkflowInstance> selection = new ArrayList<WorkflowInstance>();
		ResultSet resultSet = null;
		String query = "select * from workflowinstance " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowInstance workflowinstance = new WorkflowInstance();
				workflowinstance.wfinstanceid = resultSet
						.getInt("wfinstanceid");
				workflowinstance.owner
						.setMemberid(resultSet.getInt("memberid"));
				workflowinstance.workflowType.setWftypeid(resultSet
						.getInt("wftypeid"));
				workflowinstance.creationdatetime = resultSet
						.getString("creationdatetime");
				workflowinstance.currentstate.setStateID(resultSet
						.getInt("currentstate"));
				workflowinstance.wfcategory.setWfcategoryid(resultSet
						.getInt("wfcategoryid"));
				workflowinstance.wfcategory.setWfcategoryname(resultSet
						.getString("wfcategoryname"));
				selection.add(workflowinstance);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	/*
	 * public static WorkflowInstance selectOne(String selectionModifier) {
	 * ResultSet resultSet = null; String query = "select * from workflowitem "
	 * + selectionModifier; Connection connection = DB.getConnection();
	 * resultSet = DB.select(query, connection); try { if (resultSet.next()) {
	 * WorkflowInstance workflowinstance = new WorkflowInstance();
	 * workflowinstance.wfinstanceid = resultSet .getInt("wfinstanceid");
	 * workflowinstance.owner .setMemberid(resultSet.getInt("memberid"));
	 * workflowinstance.workflowType.setWftypeid(resultSet .getInt("wftypeid"));
	 * workflowinstance.creationdatetime = resultSet
	 * .getString("creationdatetime");
	 * workflowinstance.currentstate.setStateID(resultSet
	 * .getInt("currentstate")); workflowinstance.wfitemid.setWfitemid(resultSet
	 * .getInt("wfitemid")); DB.close(resultSet); DB.close(connection); return
	 * workflowinstance; } } catch (SQLException e) { //
	 * MyLog.myCatch("workflow.java", 43, e); e.printStackTrace(); }
	 * DB.close(resultSet); DB.close(connection); return null; }
	 */

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public WorkflowEvent getEvent() {
		return event;
	}

	public void setEvent(WorkflowEvent event) {
		this.event = event;
	}

	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}

	public String getCreationdatetime() {
		return creationdatetime;
	}

	public void setCreationdatetime(String creationdatetime) {
		this.creationdatetime = creationdatetime;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public State getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(State currentstate) {
		this.currentstate = currentstate;
	}

	public WorkflowCategory getWfcategory() {
		return wfcategory;
	}

	public void setWfcategory(WorkflowCategory wfcategory) {
		this.wfcategory = wfcategory;
	}
	
}
