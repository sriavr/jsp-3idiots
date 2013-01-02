package models;
import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class WorkflowItem {

	
	private int wftypeid;
		
	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getWfitemname() {
		return wfitemname;
	}

	public void setWfitemname(String wfitemname) {
		this.wfitemname = wfitemname;
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

	public int getQuantityavail() {
		return quantityavail;
	}

	public void setQuantityavail(int quantityavail) {
		this.quantityavail = quantityavail;
	}

	private String wfitemname;
	private String wfitemtype;
	private String wfitemcategory;
	private int quantityavail;
	private int wfitemid;
	
	
	
	public int getWfitemid() {
		return wfitemid;
	}

	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
	}

	public int update() {
		String updateSQL = 
			    "update workflowitem "
				+ "set wftypeid = '" + wftypeid + "',"
				+"wfitemtype = '" +wfitemtype + "',"+" wfitemcategory = '" + wfitemcategory + " wfitemname = '" +wfitemname + "',"+ " quantityavail = '" +quantityavail 
				+"' where wfitemid = " + wfitemid;
	
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into workflowitem "
				+ "(wftypeid,wfitemtype,wfitemcategory , wfitemname , quantityavail) " + "values('" + 
				 wftypeid + "', '" + wfitemtype + "', '" + wfitemcategory +"', '"+wfitemname + "' , '"+quantityavail+"');";
		return DB.update(insertSQL);
	}
	
	public int delete() {
		String deleteSQL = 
			    "delete from workflowitem where wfitemid = "+ wfitemid;
		System.out.println("Deleted the item");
		return DB.update(deleteSQL);
	}

	
	
	public static ArrayList<WorkflowItem> selectall(String selectionModifier) {
		ArrayList<WorkflowItem> selection = new ArrayList<WorkflowItem>();
		ResultSet resultSet = null;
		String query = "select * from workflowitem " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowItem wfitem = new WorkflowItem();
				wfitem.wftypeid = resultSet.getInt("wftypeid");
				
				wfitem.wfitemname = resultSet.getString("wfitemname");
				wfitem.wfitemtype = resultSet.getString("wfitemtype");
				wfitem.wfitemcategory = resultSet.getString("wfitemcategory");
				//System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(wfitem);
			}
		} catch (SQLException e) {
            //MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		//System.out.println("selection size :"+selection.size());
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
				WorkflowItem wfitem = new WorkflowItem();
				
				wfitem.wftypeid = resultSet.getInt("wftypeid");
				
				wfitem.wfitemname = resultSet.getString("wfitemname");
				wfitem.wfitemtype = resultSet.getString("wfitemtype");
				wfitem.wfitemcategory = resultSet.getString("wfitemcategory");
				
				DB.close(resultSet);
				DB.close(connection);
				System.out.println("successfully return action object");
				return wfitem;
			}
		} catch (SQLException e) {
          //  MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	
	
	


		
}
