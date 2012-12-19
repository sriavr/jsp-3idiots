package models;
import java.sql.*;
import utils.*;


public class Actions {

	private int actionid;
	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getActiondescription() {
		return actiondescription;
	}

	public void setActiondescription(String actiondescription) {
		this.actiondescription = actiondescription;
	}

	private int wftypeid;
	private String actionname;
	private String actiondescription;
	
	
	
	
	public int update() {
		String updateSQL = 
			    "update actions "
				+ "set actionid = '" + actionid + "',wftypeid = '" + wftypeid + "',"
				+"actionname = '" + actionname + "', actiondescription = '" + actiondescription + "',"
				+"' where actionid = " + actionid;
	
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into actions "
				+ "(actionid,wftypeid,actionname,actiondescription) " + "values('" + 
				actionid + "', '" + wftypeid + "', '" + actionname + "', '" + actiondescription +"');";
		return DB.update(insertSQL);
	}

		
}
