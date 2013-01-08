package model;


import java.sql.*;
import java.util.ArrayList;

import util.*;


public class Admin {

	private int adminid;
	private String username;
	private String password;
	
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int update() {
		String updateSQL = 
			    "update admin "
				+ "set ' username = '" + username + "',"
				+"password = '" + password
				+"' where adminid = " + adminid;
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into admin "
				+ "(adminid,username,password) " + "values('" + 
				adminid + "', '"+ username + "', '"+ password + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<Admin> selectall(String selectionModifier) {
		ArrayList<Admin> selection = new ArrayList<Admin>();
		ResultSet resultSet = null;
		String query = "select * from admin " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Admin admin = new Admin();
				admin.adminid = resultSet.getInt("adminid");
				admin.username = resultSet.getString("username");
				admin.password = resultSet.getString("password");
				selection.add(admin);
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

	public static Admin selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from admin " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				Admin admin = new Admin();
				admin.adminid = resultSet.getInt("adminid");
				admin.username = resultSet.getString("username");
				admin.password = resultSet.getString("password");
				DB.close(resultSet);
				DB.close(connection);
				return admin;
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
