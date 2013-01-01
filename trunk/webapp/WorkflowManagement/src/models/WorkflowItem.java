package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class WorkflowItem {

	private int wfitemid;
	private int wftypeid;
	private String wfitemtype;
	private String wfitemcategory;
	private String wfitemname;
	private int quantityavail;
	
	
	
	public int update() {
		String updateSQL = 
			    "update workflowitem "
				+ "set wftypeid = '" + wftypeid + "', wfitemtype = '" + wfitemtype
				+ "', wfitemcategory = '" + wfitemcategory
				+ "', wfitemname = '" + wfitemname
				+ "', quantityavail = '" + quantityavail +
				"' where wfitemid = " + wfitemid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = 
			    "delete from workflowitem where wfitemid = " + wfitemid;
	//	System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}
	
	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowitem "
				+ "(wftypeid, wfitemtype, wfitemcategory, wfitemname, quantityavail ) " + "values('" + wftypeid + "', '" + wfitemtype + "', '" + wfitemcategory + "', '" + wfitemname + "', '" + quantityavail + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowItem> selectall(String selectionModifier) {
		ArrayList<WorkflowItem> selection = new ArrayList<WorkflowItem>();
		ResultSet resultSet=null;
		String query = "select * from workflowitem " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowItem workflowitem = new WorkflowItem();
				workflowitem.wfitemid=resultSet.getInt("wfitemid");
				workflowitem.wftypeid = resultSet.getInt("wftypeid");
				workflowitem.wfitemtype = resultSet.getString("wfitemtype");
				workflowitem.wfitemcategory = resultSet.getString("wfitemcategory");
				workflowitem.wfitemname = resultSet.getString("wfitemname");
				workflowitem.quantityavail = resultSet.getInt("quantityavail");
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

	public static WorkflowItem selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from workflowitem " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				WorkflowItem workflowitem = new WorkflowItem();
				workflowitem.wfitemid=resultSet.getInt("wfitemid");
				workflowitem.wftypeid = resultSet.getInt("wftypeid");
				workflowitem.wfitemtype = resultSet.getString("wfitemtype");
				workflowitem.wfitemcategory = resultSet.getString("wfitemcategory");
				workflowitem.wfitemname = resultSet.getString("wfitemname");
				workflowitem.quantityavail = resultSet.getInt("quantityavail");
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

	public int getWfitemid() {
		return wfitemid;
	}

	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getWfitemtype() {
		return wfitemtype;
	}

	public void setWfitemtype(String wfitemtype) {
		this.wfitemtype = wfitemtype;
	}

	public String getWfitemcategory() {
		return wfitemcategory;
	}

	public void setWfitemcategory(String wfitemcategory) {
		this.wfitemcategory = wfitemcategory;
	}

	public String getWfitemname() {
		return wfitemname;
	}

	public void setWfitemname(String wfitemname) {
		this.wfitemname = wfitemname;
	}

	public int getQuantityavail() {
		return quantityavail;
	}

	public void setQuantityavail(int quantityavail) {
		this.quantityavail = quantityavail;
	}

		
}
