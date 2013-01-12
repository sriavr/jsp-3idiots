package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DB;

public class WorkflowDataDef {

	private int wfdatadefid;
	private int wftypeid;
	private String name;
	private String description;
	private int isreadonly;
	private String constantvalue;
	
	
	
	public int updatedef() {
		String updateSQL = "update workflowdatadef " + "set wftypeid = '"
				+ wftypeid + "', name = '" + name + "', description = '"
				+ description + "', isreadonly = '" + isreadonly + "', constantvalue = '" + constantvalue
				+ "' where wfdatadefid = " + wfdatadefid;
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int deletedef() {
		String deleteSQL = "delete from workflowdatadef where wfdatadefid = "
				+ wfdatadefid;
		// System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}

	public int insertdef() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowdatadef "
				+ "(wfdatadefid,wftypeid,name,description,isreadonly,constantvalue) "
				+ "values('" + wfdatadefid + "', '" + wftypeid + "', '" + name
				+ "', '" + description + "', '" + isreadonly +  "', '" + constantvalue +"');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowDataDef> selectalldef(
			String selectionModifier) {
		ArrayList<WorkflowDataDef> selection = new ArrayList<WorkflowDataDef>();
		ResultSet resultSet = null;
		String query = "select * from workflowdatadef " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowDataDef workflowitem = new WorkflowDataDef();
				workflowitem.wfdatadefid = resultSet.getInt("wfdatadefid");
				workflowitem.wftypeid = resultSet.getInt("wftypeid");
				workflowitem.name = resultSet.getString("name");
				workflowitem.description = resultSet.getString("description");
				workflowitem.isreadonly = resultSet.getInt("isreadonly");
				workflowitem.constantvalue=resultSet.getString("constantvalue");
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

	public static WorkflowDataDef selectOnedef(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from workflowdatadef " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				WorkflowDataDef workflowitem = new WorkflowDataDef();
				workflowitem.wfdatadefid = resultSet.getInt("wfdatadefid");
				workflowitem.wftypeid = resultSet.getInt("wftypeid");
				workflowitem.name = resultSet.getString("name");
				workflowitem.description = resultSet.getString("description");
				workflowitem.isreadonly = resultSet.getInt("isreadonly");
				workflowitem.constantvalue=resultSet.getString("constantvalue");
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

	public String getConstantvalue() {
		return constantvalue;
	}

	public void setConstantvalue(String constantvalue) {
		this.constantvalue = constantvalue;
	}
}
