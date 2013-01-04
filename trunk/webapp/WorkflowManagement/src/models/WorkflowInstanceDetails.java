package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;

public class WorkflowInstanceDetails {

	private int wfinstanceid;

	private int ownerid;

	private String ownername;

	private String wfname;

	private String wfitemname;

	private String state;

	private String statedescription;

	private String creationdatetime;

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

	public String getWfitemname() {
		return wfitemname;
	}

	public void setWfitemname(String wfitemname) {
		this.wfitemname = wfitemname;
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

	public static WorkflowInstanceDetails selectone(int wfinstanceid) {
		WorkflowInstanceDetails selection = new WorkflowInstanceDetails();
		ResultSet resultSet = null;
		String query = "call display_workflow_instance_details(" + wfinstanceid
				+ "); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				selection.wfinstanceid = resultSet.getInt("wfinstanceid");
				selection.ownerid = resultSet.getInt("ownerid");
				selection.ownername = resultSet.getString("ownername");
				selection.wfname = resultSet.getString("wfname");
				selection.wfitemname = resultSet.getString("wfitemname");
				selection.state = resultSet.getString("state");
				selection.statedescription= resultSet.getString("statedescription");
				selection.creationdatetime = resultSet
						.getString("creationdatetime");
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}
}
