package model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import util.*;

public class Member {

	private Role role = new Role();

	private int memberid;
	private String fname;
	private String lname;
	private String emailid;
	private String phone;
	private String username;
	private String password;
	private String address;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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
		String updateSQL = "update member " + "set roleid = '"
				+ role.getRoleid() + "', fname = '" + fname + "',"
				+ "lname = '" + lname + "', emailid = '" + emailid + "',"
				+ "phone = '" + phone + "', username = '" + username + "',"
				+ "password = '" + password + "', address = '" + address
				+ "' where memberid = " + memberid;
		// System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		System.out.println("memberid in MEMBER.JAVA--->>" + memberid);
		String deleteSQL = "delete from member where memberid = " + memberid;
		System.out.println("member deleted");
		return DB.update(deleteSQL);
	}

	public int insert() {
		String insertSQL = "insert into member "
				+ "(roleid,fname,lname,emailid,phone,username,password,address) "
				+ "values(" + +role.getRoleid() + ", '" + fname + "', '"
				+ lname + "', '" + emailid + "', '" + phone + "', '" + username
				+ "', '" + password + "', '" + address + "');";
		System.out.println("successfully added to db " + insertSQL);
		return DB.update(insertSQL);

	}

	public void clear() {
		this.address = "";
		this.emailid = "";
		this.fname = "";
		this.lname = "";
		this.memberid = 0;
		this.password = "";
		this.phone = "";
		this.role.setRoleid(0);
		this.role.setRoledescription("");
		this.role.setRolename("");
	}

	public static ArrayList<Member> selectallwftype(int wftype) {
		ArrayList<Member> selection = new ArrayList<Member>();
		ResultSet resultSet = null;
		String query = "select m.memberid, m.roleid, m.fname, m.lname, m.emailid,"
				+ " m.phone, m.username, m.password, m.address, r.wftypeid, r.rolename as rolename,"
				+ " r.description as roledesc from member m, role r where m.roleid = r.roleid and r.wftypeid = "
				+ wftype;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Member member = new Member();
				member.memberid = resultSet.getInt("memberid");
				member.role.setRoleid(resultSet.getInt("m.roleid"));
				member.role.setRolename(resultSet.getString("rolename"));
				member.role.setRoledescription(resultSet.getString("roledesc"));
				member.fname = resultSet.getString("fname");
				member.lname = resultSet.getString("lname");
				member.emailid = resultSet.getString("emailid");
				member.phone = (resultSet.getBigDecimal("phone")).toString();
				member.username = resultSet.getString("username");
				member.password = resultSet.getString("password");
				member.address = resultSet.getString("address");
				// System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(member);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		// System.out.println("selection size :"+selection.size());
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static ArrayList<Member> selectall(String modifier) {
		ArrayList<Member> selection = new ArrayList<Member>();
		ResultSet resultSet = null;
		String query = "select m.memberid, m.roleid, m.fname, m.lname, m.emailid,"
				+ " m.phone, m.username, m.password, m.address, r.wftypeid, r.rolename as rolename,"
				+ " r.description as roledesc from member m, role r where m.roleid = r.roleid  "
				+ modifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Member member = new Member();
				member.memberid = resultSet.getInt("memberid");
				member.role.setRoleid(resultSet.getInt("m.roleid"));
				member.role.setRolename(resultSet.getString("rolename"));
				member.role.setRoledescription(resultSet.getString("roledesc"));
				member.role.getWorkflowType().setWftypeid(
						resultSet.getInt("r.wftypeid"));
				member.fname = resultSet.getString("fname");
				member.lname = resultSet.getString("lname");
				member.emailid = resultSet.getString("emailid");
				member.phone = (resultSet.getBigDecimal("phone")).toString();
				member.username = resultSet.getString("username");
				member.password = resultSet.getString("password");
				member.address = resultSet.getString("address");
				// System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
				selection.add(member);
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		// System.out.println("selection size :"+selection.size());
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	// /*
	// * public static ArrayList<Member> selectall(String selectionModifier) {
	// * ArrayList<Member> selection = new ArrayList<Member>(); ResultSet
	// * resultSet = null; String query =
	// *
	// "select m.memberid, m.roleid, m.fname, m.lname, m.emailid, m.phone, m.username, m.password, m.address, r.wftypeid, r.rolename as rolename, r.description as roledesc from member m, role r where m.roleid = r.roleid "
	// * + selectionModifier; Connection connection = DB.getConnection();
	// * resultSet = DB.select(query, connection); try { while
	// (resultSet.next())
	// * { Member member = new Member(); member.memberid =
	// * resultSet.getInt("memberid");
	// * member.role.setRoleid(resultSet.getInt("m.roleid"));
	// * member.role.setRolename(resultSet.getString("rolename"));
	// * member.role.setRoledescription(resultSet.getString("roledesc"));
	// * member.fname = resultSet.getString("fname"); member.lname =
	// * resultSet.getString("lname"); member.emailid =
	// * resultSet.getString("emailid"); member.phone =
	// * resultSet.getBigDecimal("phone"); member.username =
	// * resultSet.getString("username"); member.password =
	// * resultSet.getString("password"); member.address =
	// * resultSet.getString("address"); //
	// * System.out.println(member.memberid+" "+member.roleid+" "+member.fname);
	// * selection.add(member); } } catch (SQLException e) { //
	// * MyLog.myCatch("Member.java", 43, e); e.printStackTrace(); } //
	// * System.out.println("selection size :"+selection.size());
	// * DB.close(resultSet); DB.close(connection); return selection; }
	// */

	public static Member selectOne(int memid) {
		ResultSet resultSet = null;
		String query = "call display_member_details(" + memid + "); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				Member member = new Member();
				member.memberid = resultSet.getInt("memberid");
				member.role.setRoleid(resultSet.getInt("roleid"));
				member.role.setRolename(resultSet.getString("rolename"));
				member.role.setRoledescription(resultSet
						.getString("roledescription"));
				member.fname = resultSet.getString("fname");
				member.lname = resultSet.getString("lname");
				member.emailid = resultSet.getString("emailid");
				member.phone = resultSet.getBigDecimal("phone").toString();
				member.username = resultSet.getString("username");
				member.password = resultSet.getString("password");
				member.address = resultSet.getString("address");
				DB.close(resultSet);
				DB.close(connection);
				return member;
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Member.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

}
