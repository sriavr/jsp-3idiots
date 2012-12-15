package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class Workflow {

	private int wftypeid;
	private String wfname;
	private String description;
	
	public int update() {
		String updateSQL = 
			    "update workflowtype "
				+ "set wfname = '" + wfname + "', description = '" + description + 
				"' where id = " + wftypeid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into workflowtype "
				+ "(wftypeid, wfname, description) " + "values('" + wftypeid
				+ "', '" + wfname + "', " + description + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<Workflow> selectall(String selectionModifier) {
		ArrayList<Workflow> selection = new ArrayList<Workflow>();
		ResultSet resultSet=null;
		String query = "select * from workflowtype " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Workflow workflow = new Workflow();
				workflow.wftypeid = resultSet.getInt("wftypeid");
				workflow.wfname = resultSet.getString("wfname");
				workflow.description = resultSet.getString("description");
				selection.add(workflow);
			}
		} catch (SQLException e) {
            //MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static Workflow selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select wftypeid, wfname, description"+
				"from workflowtype " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				Workflow workflow = new Workflow();
				workflow.wftypeid = resultSet.getInt("wftypeid");
				workflow.wfname = resultSet.getString("wfname");
				workflow.description = resultSet.getString("description");
				DB.close(resultSet);
				DB.close(connection);
				return workflow;
			}
		} catch (SQLException e) {
           // MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

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
