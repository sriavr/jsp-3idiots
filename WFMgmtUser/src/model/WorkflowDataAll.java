package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class WorkflowDataAll {
	private WorkflowDataDef workflowDataDef = new WorkflowDataDef();
	private int wfdataid;
	private int wfinstanceid;
	private String value;

	public WorkflowDataDef getWorkflowDataDef() {
		return workflowDataDef;
	}

	public void setWorkflowDataDef(WorkflowDataDef workflowDataDef) {
		this.workflowDataDef = workflowDataDef;
	}

	public int updatedef() {
		String updateSQL = "update workflowdatadef " + "set wftypeid = '"
				+ "(wfdatadefid,wftypeid,name,description,isreadonly ) "
				+ "values('" + workflowDataDef.getWfdatadefid() + "', '"
				+ workflowDataDef.getWftypeid() + "', '"
				+ workflowDataDef.getName() + "', '"
				+ workflowDataDef.getDescription() + "', '"
				+ workflowDataDef.getIsreadonly() + "');";
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int deletedef() {
		String deleteSQL = "delete from workflowdatadef where wfdatadefid = "
				+ workflowDataDef.getWfdatadefid();
		// System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}

	public int insertdef() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowdatadef "
				+ "(wfdatadefid,wftypeid,name,description,isreadonly ) "
				+ "values('" + workflowDataDef.getWfdatadefid() + "', '"
				+ workflowDataDef.getWftypeid() + "', '"
				+ workflowDataDef.getName() + "', '"
				+ workflowDataDef.getDescription() + "', '"
				+ workflowDataDef.getIsreadonly() + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowDataAll> selectalldef(
			String selectionModifier) {
		ArrayList<WorkflowDataAll> selection = new ArrayList<WorkflowDataAll>();
		ResultSet resultSet = null;
		String query = "select * from workflowdatadef " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
				workflowitem.workflowDataDef.setWfdatadefid(resultSet
						.getInt("wfdatadefid"));
				workflowitem.workflowDataDef.setWftypeid(resultSet
						.getInt("wftypeid"));
				workflowitem.workflowDataDef.setName(resultSet
						.getString("name"));
				workflowitem.workflowDataDef.setDescription(resultSet
						.getString("description"));
				workflowitem.workflowDataDef.setIsreadonly(resultSet
						.getInt("isreadonly"));
				selection.add(workflowitem);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
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
				workflowitem.workflowDataDef.setWfdatadefid(resultSet
						.getInt("wfdatadefid"));
				workflowitem.workflowDataDef.setWftypeid(resultSet
						.getInt("wftypeid"));
				workflowitem.workflowDataDef.setName(resultSet
						.getString("name"));
				workflowitem.workflowDataDef.setDescription(resultSet
						.getString("description"));
				workflowitem.workflowDataDef.setIsreadonly(resultSet
						.getInt("isreadonly"));
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
		String updateSQL = "update workflowdata " + "set wfdatadefid = '"
				+ workflowDataDef.getWfdatadefid() + "'," + "wfinstanceid = '"
				+ wfinstanceid + "', value = '" + value + "' where wfdataid = "
				+ wfdataid;
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = "delete from workflowdata where wfdataid = "
				+ wfdataid;
		// System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}

	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowdata"
				+ "(wfdataid,wfdatadefid,wfinstanceid,value) " + "values('"
				+ wfdataid + "', '" + wfdataid + "', '"
				+ workflowDataDef.getWfdatadefid() + "', '" + wfinstanceid
				+ "', '" + value + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowDataAll> selectwftype(int wftypeid) {
		ArrayList<WorkflowDataAll> selection = new ArrayList<WorkflowDataAll>();
		ResultSet resultSet = null;
		String query = "select * from workflowdatadef where wftypeid= "
				+ wftypeid;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
				// workflowitem.wfdataid = resultSet.getInt("wfdataid");
				// workflowitem.value = resultSet.getString("value");
				// workflowitem.wfinstanceid = resultSet.getInt("wfinstanceid");
				workflowitem.workflowDataDef.setWfdatadefid(resultSet
						.getInt("wfdatadefid"));
				workflowitem.workflowDataDef.setConstantvalue(resultSet
						.getString("constantvalue"));
				workflowitem.workflowDataDef.setName(resultSet
						.getString("name"));
				workflowitem.workflowDataDef.setDescription(resultSet
						.getString("description"));
				workflowitem.workflowDataDef.setIsreadonly(resultSet
						.getInt("isreadonly"));
				workflowitem.workflowDataDef.setWftypeid(resultSet
						.getInt("wftypeid"));

				selection.add(workflowitem);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static ArrayList<WorkflowDataAll> selectall(String selectionModifier) {
		ArrayList<WorkflowDataAll> selection = new ArrayList<WorkflowDataAll>();
		ResultSet resultSet = null;
		String query = "select * from workflowdata" + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowDataAll workflowitem = new WorkflowDataAll();
				workflowitem.wfdataid = resultSet.getInt("wfdataid");
				workflowitem.workflowDataDef.setWfdatadefid(resultSet
						.getInt("wfdatadefid"));
				workflowitem.wfinstanceid = resultSet.getInt("wfinstanceid");
				workflowitem.value = resultSet.getString("value");
				selection.add(workflowitem);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
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
				workflowitem.wfdataid = resultSet.getInt("wfdataid");
				workflowitem.workflowDataDef.setWfdatadefid(resultSet
						.getInt("wfdatadefid"));
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

}
