package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class Role {

	private int roleid;
	private int wftypeid;
	private String rolename;
	private String description;
	
	public int update() {
		String updateSQL = 
			    "update role "
				+ "set wftypeid = '" + wftypeid + "', rolename = '" + rolename + "', description = '" + description + 
				"' where id = " + roleid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into role "
				+ "(roleid, wftypeid,rolename, description) " + "values('" + roleid+"', '"+wftypeid
				+ "', '" + rolename + "', '" + description + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<Role> selectall(String selectionModifier) {
		ArrayList<Role> selection = new ArrayList<Role>();
		ResultSet resultSet=null;
		String query = "select * from role " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Role role = new Role();
				role.roleid = resultSet.getInt("roleid");
				role.wftypeid = resultSet.getInt("wftypeid");
				role.rolename = resultSet.getString("rolename");
				role.description = resultSet.getString("description");
				selection.add(role);
			}
		} catch (SQLException e) {
            //MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static Role selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select roleid,wftypeid, rolename, description"+
				"from role " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				Role role = new Role();
				role.roleid = resultSet.getInt("roleid");
				role.wftypeid = resultSet.getInt("wftypeid");
				role.rolename = resultSet.getString("rolename");
				role.description = resultSet.getString("description");
				DB.close(resultSet);
				DB.close(connection);
				return role;
			}
		} catch (SQLException e) {
           // MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
