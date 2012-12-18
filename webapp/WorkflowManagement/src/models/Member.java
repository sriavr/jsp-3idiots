package models;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class Member {

	private int memberid;
	private int roleid;
	private String fname;
	private String lname;
	private String emailid;
	private BigDecimal phone;
	private String username;
	private String password;
	private String address;
	
	
	
	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public BigDecimal getPhone() {
		return phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int update() {
		String updateSQL = 
			    "update member "
				+ "set roleid = '" + roleid + "', fname = '" + fname + "',"
				+"lname = '" + lname + "', emailid = '" + emailid + "',"
				+"phone = '" + phone + "', username = '" + username + "',"
				+"password = '" + password + "', address = '" + address + "',"
				+"' where memberid = " + memberid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int insert() {
		String insertSQL = "insert into member "
				+ "(memberid,roleid,fname,lname,emailid,phone,username,password,address) " + "values('" + 
				memberid + "', '" + roleid + "', '" + fname + "', '" + lname + "', '" + emailid + "', '"+phone + "', '"+ username + "', '"+ password + "', '" + address + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<Member> selectall(String selectionModifier) {
		ArrayList<Member> selection = new ArrayList<Member>();
		ResultSet resultSet = null;
		String query = "select * from member " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Member member = new Member();
				member.memberid = resultSet.getInt("memberid");
				member.roleid = resultSet.getInt("roleid");
				member.fname = resultSet.getString("fname");
				member.lname = resultSet.getString("lname");
				member.emailid = resultSet.getString("emailid");
				member.phone = resultSet.getBigDecimal("phone");
				member.username = resultSet.getString("username");
				member.password = resultSet.getString("password");
				member.address = resultSet.getString("address");
				//System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(member);
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

	public static Member selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from member " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				Member member = new Member();
				member.memberid = resultSet.getInt("memberid");
				member.roleid = resultSet.getInt("roleid");
				member.fname = resultSet.getString("fname");
				member.lname = resultSet.getString("lname");
				member.emailid = resultSet.getString("emailid");
				member.phone = resultSet.getBigDecimal("phone");
				member.username = resultSet.getString("username");
				member.password = resultSet.getString("password");
				member.address = resultSet.getString("address");
				DB.close(resultSet);
				DB.close(connection);
				return member;
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
