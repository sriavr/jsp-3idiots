package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class Role {

	private int roleid;
	private WorkflowType workflowType = new WorkflowType();
	private String rolename;
	private String roledescription;

	public int update() {
		String updateSQL = "update role set wftypeid = "
				+ workflowType.getWftypeid() + ", rolename = '" + rolename
				+ "', description = '" + roledescription + "' where roleid = "
				+ roleid;
		System.out.println("Updated the role");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = "delete from role where roleid = " + roleid;
		System.out.println("Deleted the role");
		return DB.update(deleteSQL);
	}

	public int insert() {
		System.out.println("In insert of role.java");
		String insertSQL = "insert into role "
				+ "(wftypeid,rolename, description) " + "values('"
				+ workflowType.getWftypeid() + "', '" + rolename + "', '"
				+ roledescription + "');";
		System.out.println("Succ inserted");
		return DB.update(insertSQL);

	}

	public static ArrayList<Role> selectall(String selectionModifier) {
		ArrayList<Role> selection = new ArrayList<Role>();
		ResultSet resultSet = null;
		String query =  "select r.roleid, r.wftypeid, r.rolename, "
				+ "r.description as rdescription, w.wftypeid, w.wfname, "
				+ "w.description as wfdescription from role r,"
				+ " workflowtype w where r.wftypeid = w.wftypeid "
				+ selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Role role = new Role();
				role.roleid = resultSet.getInt("roleid");
				role.rolename = resultSet.getString("rolename");
				role.roledescription = resultSet.getString("rdescription");
				role.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				role.workflowType.setWfname(resultSet.getString("wfname"));
				role.workflowType.setDescription(resultSet
						.getString("wfdescription"));
				selection.add(role);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static Role selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select r.roleid, r.wftypeid, r.rolename, "
				+ "r.description as rdescription, w.wftypeid, w.wfname, "
				+ "w.description as wfdescription from role r,"
				+ " workflowtype w where r.wftypeid = w.wftypeid "
				+ selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Role role = new Role();
				role.roleid = resultSet.getInt("roleid");
				role.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				role.rolename = resultSet.getString("rolename");
				role.roledescription = resultSet.getString("rdescription");
				role.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				role.workflowType.setWfname(resultSet.getString("wfname"));
				role.workflowType.setDescription(resultSet
						.getString("wfdescription"));
				DB.close(resultSet);
				DB.close(connection);
				return role;
			}
		} catch (SQLException e) {
			// MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledescription() {
		return roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

}
