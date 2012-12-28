package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class WorkflowInstance {

	private int wfinstanceid;
	private int memberid;
	private int wftypeid;
	private String creationdatetime;
	private int currentstate;
	private int wfitemid;
	
	
	
	public int update() {
		String updateSQL = 
			    "update workflowinstance "
				+ "set memberid = '" + memberid + "', wftypeid = '" + wftypeid
				+ "', creationdatetime = '" + creationdatetime
				+ "', currentstate = '" + currentstate
				+ "', wfitemid = '" + wfitemid +
				"' where wfinstanceid = " + wfinstanceid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = 
			    "delete from workflowinstance where wfinstanceid = " + wfinstanceid;
	//	System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}
	
	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into workflowinstance "
				+ "(memberid,wftypeid, creationdatetime, currentstate, wfitemid ) " + "values('" + memberid + "', '" + wftypeid + "', '" + creationdatetime + "', '" + currentstate + "', '" + wfitemid + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<WorkflowInstance> selectall(String selectionModifier) {
		ArrayList<WorkflowInstance> selection = new ArrayList<WorkflowInstance>();
		ResultSet resultSet=null;
		String query = "select * from workflowinstance " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowInstance workflowinstance = new WorkflowInstance();
				workflowinstance.wfinstanceid=resultSet.getInt("wfinstanceid");
				workflowinstance.memberid = resultSet.getInt("memberid");
				workflowinstance.wftypeid = resultSet.getInt("wftypeid");
				workflowinstance.creationdatetime = resultSet.getString("creationdatetime");
				workflowinstance.currentstate = resultSet.getInt("currentstate");
				workflowinstance.wfitemid = resultSet.getInt("wfitemid");
				selection.add(workflowinstance);
			}
		} catch (SQLException e) {
            //MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static WorkflowInstance selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from workflowitem " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				WorkflowInstance workflowinstance = new WorkflowInstance();
				workflowinstance.wfinstanceid=resultSet.getInt("wfinstanceid");
				workflowinstance.memberid = resultSet.getInt("memberid");
				workflowinstance.wftypeid = resultSet.getInt("wftypeid");
				workflowinstance.creationdatetime = resultSet.getString("creationdatetime");
				workflowinstance.currentstate = resultSet.getInt("currentstate");
				workflowinstance.wfitemid = resultSet.getInt("wfitemid");
				DB.close(resultSet);
				DB.close(connection);
				return workflowinstance;
			}
		} catch (SQLException e) {
           // MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getCreationdatetime() {
		return creationdatetime;
	}

	public void setCreationdatetime(String creationdatetime) {
		this.creationdatetime = creationdatetime;
	}

	public int getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(int currentstate) {
		this.currentstate = currentstate;
	}

	public int getWfitemid() {
		return wfitemid;
	}

	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
	}
  
	

		
}
