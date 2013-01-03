package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DB;

public class ReportingManager {
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	private  int memberid;
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	private  String fname;
	private  String actionname;
	private  String statename;
	
	public static ArrayList<ReportingManager> selectOne(String selectionModifier) {
		ArrayList<ReportingManager> selection = new ArrayList<ReportingManager>();
		ResultSet resultSet = null;
		String query = "select memberid ,fname , actionname , statename from member natural join role natural join actions natural join states  " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				ReportingManager rmanager = new ReportingManager();
				rmanager.memberid = resultSet.getInt("memberid");
				
				rmanager.actionname = resultSet.getString("actionname");
				rmanager.statename = resultSet.getString("statename");
				rmanager.fname = resultSet.getString("fname");
				//System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(rmanager);
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
	}
	


