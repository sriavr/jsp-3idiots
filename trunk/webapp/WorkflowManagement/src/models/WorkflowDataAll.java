package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class WorkflowDataAll {

	private int wfdatadefid;
	private int wftypeid;
	private String name;
	private String description;
	private int isreadonly;
	private int wfdataid;
	private int wfinstanceid;
	private String value;

	
	
	public int updatedef() {
		String updateSQL = 
			    "update workflowdatadef "
				+ "set wftypeid = '" + wftypeid + "', name = '" + name
				+ "', description = '" + description
				+ "', isreadonly = '" + isreadonly+
				"' where wfdatadefid = " + wfdatadefid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int deletedef() {
		String deleteSQL = 
			    "delete from workflowdatadef where wfdatadefid = " + wfdatadefid;
	//	System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}
	
	public int insertdef() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowdatadef "
				+ "(wfdatadefid,wftypeid,name,description,isreadonly ) " + "values('" + wfdatadefid + "', '" + wftypeid + "', '" + name + "', '" + description + "', '" + isreadonly + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowDataAll> selectalldef(String selectionModifier) {
		ArrayList<WorkflowDataAll> selection = new ArrayList<WorkflowDataAll>();
		ResultSet resultSet=null;
		String query = "select * from workflowdatadef " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
				workflowitem.wfdatadefid=resultSet.getInt("wfdatadefid");
				workflowitem.wftypeid = resultSet.getInt("wftypeid");
				workflowitem.name = resultSet.getString("name");
				workflowitem.description = resultSet.getString("description");
				workflowitem.isreadonly = resultSet.getInt("isreadonly");
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

	public static WorkflowDataAll selectOnedef(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from workflowdatadef " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
				workflowitem.wfdatadefid=resultSet.getInt("wfdatadefid");
				workflowitem.wftypeid = resultSet.getInt("wftypeid");
				workflowitem.name = resultSet.getString("name");
				workflowitem.description = resultSet.getString("description");
				workflowitem.isreadonly = resultSet.getInt("isreadonly");
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
	
	public int update() {
		String updateSQL = 
			    "update workflowdata "
				+ "set wfdatadefid = '" + wfdatadefid + "',"
				+ "wfinstanceid = '" + wfinstanceid 
				+ "', value = '" + value+
				"' where wfdataid = " + wfdataid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = 
			    "delete from workflowdata where wfdataid = " + wfdataid;
	//	System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}
	
	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowdata"
				+ "(wfdataid,wfdatadefid,wfinstanceid,value) " + "values('" + wfdataid + "', '" + wfdataid + "', '" + wfdatadefid + "', '" + wfinstanceid + "', '" + value + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowDataAll> selectall(String selectionModifier) {
		ArrayList<WorkflowDataAll> selection = new ArrayList<WorkflowDataAll>();
		ResultSet resultSet=null;
		String query = "select * from workflowdata" + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
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

	public static WorkflowDataAll selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from workflowdata " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
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

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsreadonly() {
		return isreadonly;
	}

	public void setIsreadonly(int isreadonly) {
		this.isreadonly = isreadonly;
	}
}
