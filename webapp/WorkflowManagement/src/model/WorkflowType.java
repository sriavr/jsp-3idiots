package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class WorkflowType {

	private int wftypeid;
	private String wfname;
	private String description;

	public int update() {
		String updateSQL = "update workflowtype " + "set wfname = '" + wfname
				+ "', description = '" + description + "' where wftypeid = "
				+ wftypeid;
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = "delete from workflowtype where wftypeid = "
				+ wftypeid;
		// System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}

	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowtype "
				+ "(wfname, description) " + "values('" + wfname + "', '"
				+ description + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowType> selectall(String selectionModifier) {
		ArrayList<WorkflowType> selection = new ArrayList<WorkflowType>();
		ResultSet resultSet = null;
		String query = "call display_workflow_types(); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowType workflow = new WorkflowType();
				workflow.wftypeid = resultSet.getInt("wftypeid");
				workflow.wfname = resultSet.getString("wfname");
				workflow.description = resultSet.getString("description");
				selection.add(workflow);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	// public static WorkflowType selectOne(String selectionModifier) {
	// ResultSet resultSet = null;
	// String query = "select * from workflowtype " + selectionModifier;
	// Connection connection = DB.getConnection();
	// resultSet = DB.select(query, connection);
	// try {
	// if (resultSet.next()) {
	// WorkflowType workflow = new WorkflowType();
	// workflow.wftypeid = resultSet.getInt("wftypeid");
	// workflow.wfname = resultSet.getString("wfname");
	// workflow.description = resultSet.getString("description");
	// DB.close(resultSet);
	// DB.close(connection);
	// return workflow;
	// }
	// } catch (SQLException e) {
	// // MyLog.myCatch("workflow.java", 43, e);
	// e.printStackTrace();
	// }
	// DB.close(resultSet);
	// DB.close(connection);
	// return null;
	// }

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getWfname() {
		return wfname;
	}

	public void setWfname(String wfname) {
		this.wfname = wfname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
