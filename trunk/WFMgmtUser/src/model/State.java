package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DB;

public class State {
	private int stateID;
	private WorkflowType workflowType = new WorkflowType();
	private String stateName;
	private String stateDescription;

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateDescription() {
		return stateDescription;
	}

	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

	public int insert() {
		System.out.println("In insert of State.java");
		String insertSQL = "insert into states "
				+ "(wftypeid, statename, statedescription) " + "values("
				+ workflowType.getWftypeid() + ", '" + stateName + "', '"
				+ stateDescription + "');";
		return DB.update(insertSQL);

	}

	public static ArrayList<State> selectallwftypeid(int wftypeid) {
		ArrayList<State> selection = new ArrayList<State>();
		ResultSet resultSet = null;
		String query = "select r.stateid, r.wftypeid, r.statename, "
				+ "r.statedescription as rdescription, w.wftypeid, w.wfname, "
				+ "w.description as wfdescription from states r,"
				+ " workflowtype w where r.wftypeid = w.wftypeid and r.wftypeid = "
				+ wftypeid;
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				State state = new State();
				state.stateID = resultSet.getInt("stateid");
				state.stateName = resultSet.getString("statename");
				state.stateDescription = resultSet
						.getString("rdescription");
				state.workflowType.setWftypeid(resultSet.getInt("wftypeid"));
				state.workflowType.setWfname(resultSet.getString("wfname"));
				state.workflowType.setDescription(resultSet
						.getString("wfdescription"));
				selection.add(state);
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
