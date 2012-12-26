package models;
import java.sql.*;
import java.util.ArrayList;

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
				+ "set wftypeid = '" + wftypeid + "',"
				+"actionname = '" + actionname + "', actiondescription = '" + actiondescription + "',"
				+"' where actionid = " + actionid;
	
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into actions "
				+ "(wftypeid,actionname,actiondescription) " + "values('" + 
				 wftypeid + "', '" + actionname + "', '" + actiondescription +"');";
		return DB.update(insertSQL);
	}
	
	public int delete() {
		String deleteSQL = 
			    "delete from actions where actionid = "+ actionid;
		System.out.println("Deleted the action");
		return DB.update(deleteSQL);
	}

	
	
	public static ArrayList<Actions> selectall(String selectionModifier) {
		ArrayList<Actions> selection = new ArrayList<Actions>();
		ResultSet resultSet = null;
		String query = "select * from actions " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Actions action = new Actions();
				action.actionid = resultSet.getInt("actionid");
				
				action.actionname = resultSet.getString("actionname");
				action.actiondescription = resultSet.getString("actiondescription");
				action.wftypeid = resultSet.getInt("wftypeid");
				//System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(action);
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

	public static Actions selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from actions " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				Actions action = new Actions();
				action.actionid = resultSet.getInt("actionid");
				action.wftypeid = resultSet.getInt("wftypeidid");
				action.actionname = resultSet.getString("actionname");
				action.actiondescription = resultSet.getString("actiondescription");
				DB.close(resultSet);
				DB.close(connection);
				System.out.println("successfully return action object");
				return action;
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
