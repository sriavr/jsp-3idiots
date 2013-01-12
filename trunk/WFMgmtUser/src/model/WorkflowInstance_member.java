package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class WorkflowInstance_member {

	private int wfinstanceid;
	private int ownerid;
	private String ownername;
	private String wfname;
	private int wftypeid;
	private int wfcategoryid;
	private String wfcategoryname;
	private String state;
	private String statedescription;
	private String creationdatetime;

	// private ArrayList<WorkflowInstance_member> wfinstances_member = new
	// ArrayList<WorkflowInstance_member>();

	public static ArrayList<WorkflowInstance_member> selectall(int memid) {
		ArrayList<WorkflowInstance_member> selection = new ArrayList<WorkflowInstance_member>();
		ResultSet resultSet = null;
		System.out
				.println("Quering select all in WorkflowInstance display_workflow_instances_member for member: "
						+ memid);
		String query = "call display_workflow_instances_member(" + memid
				+ "); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowInstance_member workflowinstance = new WorkflowInstance_member();
				workflowinstance.setWfinstanceid(resultSet
						.getInt("wfinstanceid"));
				workflowinstance.setOwnerid(resultSet.getInt("ownerid"));
				workflowinstance.setOwnername(resultSet.getString("ownername"));
				workflowinstance.setWfname(resultSet.getString("wfname"));
				workflowinstance.setWftypeid(resultSet.getInt("wftypeid"));
				workflowinstance.setWfcategoryid(resultSet
						.getInt("wfcategoryid"));
				workflowinstance.setWfcategoryname(resultSet
						.getString("wfcategoryname"));
				workflowinstance.setState(resultSet.getString("state"));
				workflowinstance.setStatedescription(resultSet
						.getString("statedescription"));
				workflowinstance.setCreationdatetime(resultSet
						.getString("creationdatetime"));
				selection.add(workflowinstance);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getWfname() {
		return wfname;
	}

	public void setWfname(String wfname) {
		this.wfname = wfname;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatedescription() {
		return statedescription;
	}

	public void setStatedescription(String statedescription) {
		this.statedescription = statedescription;
	}

	public String getCreationdatetime() {
		return creationdatetime;
	}

	public void setCreationdatetime(String creationdatetime) {
		this.creationdatetime = creationdatetime;
	}

}
