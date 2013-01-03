package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DB;

public class WorkflowData {

	private int wfdatadefid;
	private int wfdataid;
	private int wfinstanceid;
	private String value;

	public int update() {
		String updateSQL = 
			    "update workflowdata "
				+ "set wfdatadefid = '" + wfdatadefid + "', wfinstanceid = '" + wfinstanceid
				+ "', value = '" + value+
				"' where wfdataid = " + wfdataid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int deletedef() {
		String deleteSQL = 
			    "delete from workflowdata where wfdataid = " + wfdataid;
	//	System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}
	
	public int insertdef() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowdata "
				+ "(wfdataid,wfdatadefid,wfinstanceid,value ) " + "values('" + wfdataid + "', '" + wfdatadefid + "', '" + wfinstanceid + "', '" + value+ "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowData> selectall(String selectionModifier) {
		ArrayList<WorkflowData> selection = new ArrayList<WorkflowData>();
		ResultSet resultSet=null;
		String query = "select * from workflowdata" + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowData workflowitem = new WorkflowData();
				workflowitem.wfdataid=resultSet.getInt("wfdataid");
				workflowitem.wfdatadefid = resultSet.getInt("wfdatadefid");
				workflowitem.wfinstanceid = resultSet.getInt("wfinstanceid");
				workflowitem.value = resultSet.getString("value");
				selection.add(workflowitem);
			}
		} catch (SQLException e) {
            //MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static WorkflowData selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from workflowdata " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				WorkflowData workflowitem = new WorkflowData();
				workflowitem.wfdataid=resultSet.getInt("wfdataid");
				workflowitem.wfdatadefid = resultSet.getInt("wfdatadefid");
				workflowitem.wfinstanceid = resultSet.getInt("wfinstanceid");
				workflowitem.value = resultSet.getString("value");
				DB.close(resultSet);
				DB.close(connection);
				return workflowitem;
			}
		} catch (SQLException e) {
           // MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	public int getWfdataid() {
		return wfdataid;
	}

	public void setWfdataid(int wfdataid) {
		this.wfdataid = wfdataid;
	}

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getWfdatadefid() {
		return wfdatadefid;
	}

	public void setWfdatadefid(int wfdatadefid) {
		this.wfdatadefid = wfdatadefid;
	}

}
