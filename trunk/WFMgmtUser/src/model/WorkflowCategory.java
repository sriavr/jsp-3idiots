package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class WorkflowCategory {

	private int wftypeid;
	private int wfcategoryid;
	private String wfcategoryname;

	public int getWfcategoryid() {
		return wfcategoryid;
	}

	public void setWfcategoryid(int wfcategoryid) {
		this.wfcategoryid = wfcategoryid;
	}

	public String getWfcategoryname() {
		return wfcategoryname;
	}

	public void setWfcategoryname(String wfcategoryname) {
		this.wfcategoryname = wfcategoryname;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public int update() {
		String updateSQL = "update workflowcategory "
				+ "set WFCategoryName = '" + wfcategoryname + "', "
				+ "WFTypeID =" + wftypeid + " where WFCategoryID = "
				+ wfcategoryid;
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "INSERT INTO workflowcategory (`WFCategoryName`,`WFTypeID`) VALUES ('"
				+ wfcategoryname + "', " + wftypeid + ")";
		return DB.update(insertSQL);
	}

	public int delete() {
		String deleteSQL = "delete from workflowcategory where WFCategoryID = "
				+ wfcategoryid;
		System.out.println("Deleted the item");
		return DB.update(deleteSQL);
	}

	public static ArrayList<WorkflowCategory> selectall(int wftypeid) {
		ArrayList<WorkflowCategory> selection = new ArrayList<WorkflowCategory>();
		ResultSet resultSet = null;
		String query = "select * from workflowcategory where wftypeid = "
				+ wftypeid + "; ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowCategory wfCategory = new WorkflowCategory();
				wfCategory.wftypeid = resultSet.getInt("wftypeid");
				wfCategory.wfcategoryid = resultSet.getInt("wfcategoryid");
				wfCategory.wfcategoryname = resultSet
						.getString("wfcategoryname");
				selection.add(wfCategory);
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

}
