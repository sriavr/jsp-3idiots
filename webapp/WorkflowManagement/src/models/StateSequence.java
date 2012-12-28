package models;

import java.sql.*;
import java.util.ArrayList;

import utils.*;


public class StateSequence {

	private int seqid;
	private int wftypeid;
	private int roleid;
	private int previousstateid;
	private int nextstateid;
	private int actionid;
	
	
	public int update() {
		String updateSQL = 
			    "update statesequencetable "
				+ "set wftypeid = '" + wftypeid + "', roleid = '" + roleid
				+ "', previousstateid = '" + previousstateid
				+ "', nextstateid = '" + nextstateid
				+ "', actionid = '" + actionid +
				"' where seqid = " + seqid;
	//	System.out.println("Updated the book");
		return DB.update(updateSQL);
	}

	public int delete() {
		String deleteSQL = 
			    "delete from statesequencetable where seqid = " + seqid;
	//	System.out.println("Updated the book");
		return DB.update(deleteSQL);
	}
	
	public int insert() {
		System.out.println("In wf insert()");
		String insertSQL = "insert into statesequencetable "
				+ "(wftypeid, roleid, previousstateid, nextstateid, actionid ) " + "values('" + wftypeid + "', '" + roleid + "', '" + previousstateid + "', '" + nextstateid + "', '" + actionid + "');";
		return DB.update(insertSQL);
	}

	public static ArrayList<StateSequence> selectall(String selectionModifier) {
		ArrayList<StateSequence> selection = new ArrayList<StateSequence>();
		ResultSet resultSet=null;
		String query = "select * from statesequencetable " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				StateSequence stateseq = new StateSequence();
				stateseq.seqid=resultSet.getInt("seqid");
				stateseq.wftypeid = resultSet.getInt("wftypeid");
				stateseq.roleid = resultSet.getInt("roleid");
				stateseq.previousstateid = resultSet.getInt("previousstateid");
				stateseq.nextstateid = resultSet.getInt("nextstateid");
				stateseq.actionid = resultSet.getInt("actionid");
				selection.add(stateseq);
			}
		} catch (SQLException e) {
            //MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return selection;
	}

	public static StateSequence selectOne(String selectionModifier) {
		ResultSet resultSet = null;
		String query = "select * from statesequencetable " + selectionModifier;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			if (resultSet.next()) {
				StateSequence stateseq = new StateSequence();
				stateseq.seqid=resultSet.getInt("seqid");
				stateseq.wftypeid = resultSet.getInt("wftypeid");
				stateseq.roleid = resultSet.getInt("roleid");
				stateseq.previousstateid = resultSet.getInt("previousstateid");
				stateseq.nextstateid = resultSet.getInt("nextstateid");
				stateseq.actionid = resultSet.getInt("actionid");
				DB.close(resultSet);
				DB.close(connection);
				return stateseq;
			}
		} catch (SQLException e) {
           // MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return null;
	}

	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getPreviousstateid() {
		return previousstateid;
	}

	public void setPreviousstateid(int previousstateid) {
		this.previousstateid = previousstateid;
	}

	public int getNextstateid() {
		return nextstateid;
	}

	public void setNextstateid(int nextstateid) {
		this.nextstateid = nextstateid;
	}

	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

			
}
