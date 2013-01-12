package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import util.*;

public class Action {

	private int actionid;
	private String actionname;
	private String actiondescription;
	private WorkflowType workflowType = new WorkflowType();

	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getActiondescription() {
		return actiondescription;
	}

	public void setActiondescription(String actiondescription) {
		this.actiondescription = actiondescription;
	}

	public int update() {
		String updateSQL = "update actions " + "set wftypeid = '"
				+ workflowType.getWftypeid() + "'," + "actionname = '"
				+ actionname + "', actiondescription = '" + actiondescription
				+ "'," + "' where actionid = " + actionid;

		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into actions "
				+ "(wftypeid,actionname,actiondescription) " + "values('"
				+ workflowType.getWftypeid() + "', '" + actionname + "', '"
				+ actiondescription + "');";
		return DB.update(insertSQL);
	}

	public int delete() {
		String deleteSQL = "delete from actions where actionid = " + actionid;
		System.out.println("Deleted the action");
		return DB.update(deleteSQL);
	}

	public static ArrayList<Action> selectall() {
		Map<String, Object> session;
		ArrayList<Action> selection = new ArrayList<Action>();
		ResultSet resultSet = null;
		session = ActionContext.getContext().getSession();
		Member member_loggedin = (Member) session.get("memberloggedin");
		int roleid = member_loggedin.getRole().getRoleid();
		String query = "select * from actions where actionid in (select actionid from statesequencetable where roleid = "
				+ roleid + ")";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Action action = new Action();
				action.actionid = resultSet.getInt("actionid");

				action.actionname = resultSet.getString("actionname");
				action.actiondescription = resultSet
						.getString("actiondescription");
				action.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				// System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(action);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		// System.out.println("selection size :"+selection.size());
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	// select * from actions where actionid in (select actionid from
	// statesequencetable where roleid = 402);

	public static ArrayList<Action> selectuseractions(int roleid) {
		Map<String, Object> session;
		ArrayList<Action> selection = new ArrayList<Action>();
		ResultSet resultSet = null;
		System.out.println("roleid:" + roleid);
		String query = "select * from actions where actionid "
				+ "in (select actionid from statesequencetable where roleid = "
				+ roleid + ");";
		System.out.println(query);
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Action action = new Action();
				action.actionid = resultSet.getInt("actionid");
				action.actionname = resultSet.getString("actionname");
				action.actiondescription = resultSet
						.getString("actiondescription");
				action.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				selection.add(action);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		// System.out.println("selection size :"+selection.size());
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static ArrayList<Action> selectallwftype(int wftypeid) {
		Map<String, Object> session;
		ArrayList<Action> selection = new ArrayList<Action>();
		ResultSet resultSet = null;
		String query = "select * from actions where wftypeid = " + wftypeid;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Action action = new Action();
				action.actionid = resultSet.getInt("actionid");
				action.actionname = resultSet.getString("actionname");
				action.actiondescription = resultSet
						.getString("actiondescription");
				action.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				selection.add(action);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		// System.out.println("selection size :"+selection.size());
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

}
