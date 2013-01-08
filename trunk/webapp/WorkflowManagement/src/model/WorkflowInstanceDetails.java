package model;

import java.sql.*;
import java.util.ArrayList;

import util.*;

public class WorkflowInstanceDetails {

	private WorkflowInstance workflowInstance = new WorkflowInstance();
	private WorkflowType workflowType = new WorkflowType();
	private ArrayList<WorkflowEvent> eventHistory = new ArrayList<WorkflowEvent>();
	private ArrayList<WorkflowDataAll> associatedWorkflowData = new ArrayList<WorkflowDataAll>();

	public ArrayList<WorkflowDataAll> getAssociatedWorkflowData() {
		return associatedWorkflowData;
	}

	public void setAssociatedWorkflowData(
			ArrayList<WorkflowDataAll> associatedWorkflowData) {
		this.associatedWorkflowData = associatedWorkflowData;
	}

	public WorkflowInstance getWorkflowInstance() {
		return workflowInstance;
	}

	public void setWorkflowInstance(WorkflowInstance workflowInstance) {
		this.workflowInstance = workflowInstance;
	}

	/*
	 * public WorkflowDataAll getWorkflowData() { return workflowData; }
	 * 
	 * public void setWorkflowData(WorkflowDataAll workflowData) {
	 * this.workflowData = workflowData; }
	 */
	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public ArrayList<WorkflowEvent> getEventHistory() {
		return eventHistory;
	}

	public void setEventHistory(ArrayList<WorkflowEvent> eventHistory) {
		this.eventHistory = eventHistory;
	}

	public static WorkflowInstanceDetails selectone(int wfinstanceid) {
		WorkflowInstanceDetails wfInstanceDetails = new WorkflowInstanceDetails();

		ResultSet resultSet = null;
		String query1 = "call display_workflow_instance_details("
				+ wfinstanceid + "); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query1, connection);
		try {
			while (resultSet.next()) {
				wfInstanceDetails.workflowInstance.setWfinstanceid(resultSet
						.getInt("wfinstanceid"));
				wfInstanceDetails.workflowInstance
						.setCreationdatetime(resultSet
								.getString("creationdatetime"));
				wfInstanceDetails.workflowInstance.getOwner().setMemberid(
						resultSet.getInt("ownerid"));
				wfInstanceDetails.workflowInstance.getOwner().setFname(
						resultSet.getString("ownerfname"));
				wfInstanceDetails.workflowInstance.getOwner().setLname(
						resultSet.getString("ownerlname"));
				wfInstanceDetails.workflowInstance.getOwner().setEmailid(
						resultSet.getString("owneremailid"));
				wfInstanceDetails.workflowInstance.getOwner().setPhone(
						resultSet.getBigDecimal("ownerphone"));
				wfInstanceDetails.workflowInstance.getOwner().setAddress(
						resultSet.getString("owneraddress"));
				wfInstanceDetails.workflowInstance.getOwner().getRole()
						.setRoleid(resultSet.getInt("ownerroleid"));
				wfInstanceDetails.workflowInstance.getOwner().getRole()
						.setRolename(resultSet.getString("ownerrolename"));
				wfInstanceDetails.workflowInstance
						.getOwner()
						.getRole()
						.setRoledescription(
								resultSet.getString("ownerroledescription"));
				wfInstanceDetails.workflowInstance.getWfitemid().setWfitemid(
						resultSet.getInt("wfitemid"));
				wfInstanceDetails.workflowInstance.getWfitemid().setWfitemname(
						resultSet.getString("wfitemname"));
				wfInstanceDetails.workflowInstance.getWfitemid().setWfitemtype(
						resultSet.getString("wfitemtype"));
				wfInstanceDetails.workflowInstance.getCurrentstate()
						.setStateID(resultSet.getInt("stateid"));
				wfInstanceDetails.workflowInstance.getCurrentstate()
						.setStateName(resultSet.getString("statename"));
				wfInstanceDetails.workflowInstance.getCurrentstate()
						.setStateDescription(
								resultSet.getString("statedescription"));
				wfInstanceDetails.workflowType.setWftypeid(resultSet
						.getInt("wftypeid"));
				wfInstanceDetails.workflowType.setWfname(resultSet
						.getString("wfname"));
				wfInstanceDetails.workflowType.setDescription(resultSet
						.getString("wfdescription"));

			}

			String query2 = "call display_event_history(" + wfinstanceid
					+ "); ";
			DB.close(resultSet);
			resultSet = DB.select(query2, connection);
			while (resultSet.next()) {
				WorkflowEvent wfevent = new WorkflowEvent();
				wfevent.setEventid(resultSet.getInt("eventid"));
				wfevent.getStateSequence().setSeqid(resultSet.getInt("seqid"));
				wfevent.getStateSequence().getPrevState()
						.setStateID(resultSet.getInt("prevstateid"));
				wfevent.getStateSequence().getPrevState()
						.setStateName(resultSet.getString("prevstatename"));
				wfevent.getStateSequence()
						.getPrevState()
						.setStateDescription(
								resultSet.getString("prevstatedescription"));
				wfevent.getStateSequence().getNextState()
						.setStateID(resultSet.getInt("nextstateid"));
				wfevent.getStateSequence().getNextState()
						.setStateName(resultSet.getString("nextstatename"));
				wfevent.getStateSequence()
						.getNextState()
						.setStateDescription(
								resultSet.getString("nextstatedescription"));

				wfevent.getOwner().setMemberid(resultSet.getInt("ownerid"));
				wfevent.getOwner().setFname(resultSet.getString("ownerfname"));
				wfevent.getOwner().setLname(resultSet.getString("ownerlname"));
				wfevent.getOwner().setFname(resultSet.getString("ownerfname"));
				wfevent.getOwner().setEmailid(
						resultSet.getString("owneremailid"));
				wfevent.getOwner().setPhone(
						resultSet.getBigDecimal("ownerphone"));
				wfevent.getOwner().setAddress(
						resultSet.getString("owneraddress"));
				/*
				 * wfevent.getRole().setRoleid(resultSet.getInt("roleid"));
				 * wfevent
				 * .getRole().setRolename(resultSet.getString("rolename"));
				 * wfevent.getRole().setRoledescription(resultSet.getString(
				 * "roledescription"));
				 */
				wfevent.getOwner().getRole()
						.setRoleid(resultSet.getInt("ownerroleid"));
				wfevent.getOwner().getRole()
						.setRolename(resultSet.getString("ownerrolename"));
				wfevent.getOwner()
						.getRole()
						.setRoledescription(
								resultSet.getString("ownerroledescription"));
				wfevent.getActor().getRole()
						.setRoleid(resultSet.getInt("actorroleid"));
				wfevent.getActor().getRole()
						.setRolename(resultSet.getString("actorrolename"));
				wfevent.getActor()
						.getRole()
						.setRoledescription(
								resultSet.getString("actorroledescription"));

				wfevent.setEventDateTime(resultSet.getString("eventdatetime"));
				wfevent.getAction().setActionid(resultSet.getInt("actionid"));
				wfevent.getAction().setActionname(
						resultSet.getString("actionname"));
				wfevent.getAction().setActionname(
						resultSet.getString("actiondescription"));
				wfevent.getWorkflowType().setWftypeid(
						resultSet.getInt("wftypeid"));
				wfevent.getWorkflowType().setWfname(
						resultSet.getString("wfname"));
				wfevent.getWorkflowType().setDescription(
						resultSet.getString("description"));
				wfInstanceDetails.eventHistory.add(wfevent);
			}

			String query3 = "call display_workflow_data_all(" + wfinstanceid
					+ "); ";
			DB.close(resultSet);
			resultSet = DB.select(query3, connection);
			while (resultSet.next()) {
				WorkflowDataAll workflowDataAll = new WorkflowDataAll();
				workflowDataAll.setWfdataid(resultSet.getInt("wfdataid"));
				workflowDataAll.setWfinstanceid(resultSet
						.getInt("wfinstanceid"));
				workflowDataAll.setValue(resultSet.getString("value"));
				workflowDataAll.getWorkflowDataDef().setWftypeid(
						resultSet.getInt("wftypeid"));
				workflowDataAll.getWorkflowDataDef().setWfdatadefid(
						resultSet.getInt("wfdatadefid"));
				workflowDataAll.getWorkflowDataDef().setName(
						resultSet.getString("name"));
				workflowDataAll.getWorkflowDataDef().setDescription(
						resultSet.getString("description"));
				workflowDataAll.getWorkflowDataDef().setIsreadonly(
						resultSet.getInt("isreadonly"));
				workflowDataAll.getWorkflowDataDef().setConstantvalue(
						resultSet.getString("constantvalue"));
				wfInstanceDetails.getAssociatedWorkflowData().add(
						workflowDataAll);
				System.out.println(workflowDataAll.getWfdataid());
			}
		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return wfInstanceDetails;
	}

}
