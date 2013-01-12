package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DB;

public class WorkflowTypeDetails {
	private ArrayList<StateSequence> stateSequenceTable = new ArrayList<StateSequence>();
	private ArrayList<WorkflowInstance> associatedWorkflowInstances = new ArrayList<WorkflowInstance>();
	private ArrayList<Role> associatedRoles = new ArrayList<Role>();
	private ArrayList<Member> associatedMembers = new ArrayList<Member>();
	private ArrayList<WorkflowCategory> associatedCategories = new ArrayList<WorkflowCategory>();
	private WorkflowType workflowType = new WorkflowType();
	private ArrayList<WorkflowDataDef> workflowDataDefns = new ArrayList<WorkflowDataDef>();
	private State state = new State();
	private Action action = new Action();
	private Member member = new Member();

	public ArrayList<WorkflowDataDef> getWorkflowDataDefns() {
		return workflowDataDefns;
	}

	public void setWorkflowDataDefns(
			ArrayList<WorkflowDataDef> workflowDataDefns) {
		this.workflowDataDefns = workflowDataDefns;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<StateSequence> getStateSequenceTable() {
		return stateSequenceTable;
	}

	public void setStateSequenceTable(
			ArrayList<StateSequence> stateSequenceTable) {
		this.stateSequenceTable = stateSequenceTable;
	}

	public ArrayList<WorkflowInstance> getAssociatedWorkflowInstances() {
		return associatedWorkflowInstances;
	}

	public void setAssociatedWorkflowInstances(
			ArrayList<WorkflowInstance> associatedWorkflowInstances) {
		this.associatedWorkflowInstances = associatedWorkflowInstances;
	}

	public ArrayList<Role> getAssociatedRoles() {
		return associatedRoles;
	}

	public void setAssociatedRoles(ArrayList<Role> associatedRoles) {
		this.associatedRoles = associatedRoles;
	}

	public ArrayList<Member> getAssociatedMembers() {
		return associatedMembers;
	}

	public void setAssociatedMembers(ArrayList<Member> associatedMembers) {
		this.associatedMembers = associatedMembers;
	}

	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	public static WorkflowTypeDetails selectone(int wftypeid) {
		WorkflowTypeDetails wftypedetails = new WorkflowTypeDetails();

		StateSequence stateseq = new StateSequence();

		ResultSet resultSet = null;
		String query = "call display_workflow_type_details(" + wftypeid + "); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				wftypedetails.workflowType.setWftypeid(resultSet
						.getInt("wftypeid"));
				wftypedetails.workflowType.setWfname(resultSet
						.getString("wfname"));
				wftypedetails.workflowType.setDescription(resultSet
						.getString("description"));
			}

			String query3 = "call display_workflow_data_def(" + wftypeid
					+ "); ";
			DB.close(resultSet);
			resultSet = DB.select(query3, connection);
			while (resultSet.next()) {
				WorkflowDataDef workflowDataDef = new WorkflowDataDef();
				workflowDataDef.setWftypeid(resultSet.getInt("wftypeid"));
				workflowDataDef.setWfdatadefid(resultSet.getInt("wfdatadefid"));
				workflowDataDef.setName(resultSet.getString("name"));
				workflowDataDef.setDescription(resultSet
						.getString("description"));
				workflowDataDef.setIsreadonly(resultSet.getInt("isreadonly"));
				workflowDataDef.setConstantvalue(resultSet
						.getString("constantvalue"));
				wftypedetails.workflowDataDefns.add(workflowDataDef);
			}

			String query4 = "call display_members(" + wftypeid + "); ";
			DB.close(resultSet);
			resultSet = DB.select(query4, connection);
			while (resultSet.next()) {
				Member member = new Member();
				member.setMemberid(resultSet.getInt("memberid"));
				member.setFname(resultSet.getString("fname"));
				member.setLname(resultSet.getString("lname"));
				member.setEmailid(resultSet.getString("emailid"));
				member.setPhone(resultSet.getBigDecimal("phone").toString());
				member.setUsername(resultSet.getString("username"));
				member.setPassword(resultSet.getString("password"));
				member.setAddress(resultSet.getString("address"));
				wftypedetails.associatedMembers.add(member);
			}

			String query5 = "call display_roles(" + wftypeid + "); ";
			DB.close(resultSet);
			resultSet = DB.select(query5, connection);
			while (resultSet.next()) {
				Role role = new Role();
				role.setRoleid(resultSet.getInt("roleid"));
				role.setRolename(resultSet.getString("rolename"));
				role.setRoledescription(resultSet.getString("roledescription"));
				wftypedetails.associatedRoles.add(role);
			}

			String query6 = "call display_state_sequences(" + wftypeid + "); ";
			DB.close(resultSet);
			resultSet = DB.select(query6, connection);
			while (resultSet.next()) {
				stateseq.setSeqid(resultSet.getInt("seqid"));
				stateseq.getRole().setRoleid(resultSet.getInt("roleid"));
				stateseq.getRole().setRolename(resultSet.getString("rolename"));
				stateseq.getRole().setRoledescription(
						resultSet.getString("roledescription"));
				stateseq.getPrevState().setStateID(
						resultSet.getInt("prevstateid"));
				stateseq.getPrevState().setStateName(
						resultSet.getString("prevstatename"));
				stateseq.getPrevState().setStateDescription(
						resultSet.getString("prevstatedescription"));
				stateseq.getNextState().setStateID(
						resultSet.getInt("nextstateid"));
				stateseq.getNextState().setStateName(
						resultSet.getString("nextstatename"));
				stateseq.getNextState().setStateDescription(
						resultSet.getString("nextstatedescription"));
				stateseq.getAction().setActionid(resultSet.getInt("actionid"));
				stateseq.getAction().setActionname(
						resultSet.getString("actionname"));
				stateseq.getAction().setActiondescription(
						resultSet.getString("actiondescription"));
				stateseq.getWorkflowType().setWftypeid(
						resultSet.getInt("wftypeid"));
				stateseq.getWorkflowType().setWfname(
						resultSet.getString("wfname"));
				stateseq.getWorkflowType().setDescription(
						resultSet.getString("wfdescription"));
				wftypedetails.stateSequenceTable.add(stateseq);
			}

			String query7 = "call display_states(" + wftypeid + "); ";
			DB.close(resultSet);
			resultSet = DB.select(query7, connection);
			while (resultSet.next()) {
				wftypedetails.state.setStateID(resultSet.getInt("stateid"));
				wftypedetails.state.setStateName(resultSet
						.getString("statename"));
				wftypedetails.state.setStateDescription(resultSet
						.getString("statedescription"));
				wftypedetails.state.getWorkflowType().setWftypeid(
						resultSet.getInt("wftypeid"));
				wftypedetails.state.getWorkflowType().setWfname(
						resultSet.getString("wfname"));
				wftypedetails.state.getWorkflowType().setDescription(
						resultSet.getString("wfdescription"));
			}

			String query8 = "call display_actions(" + wftypeid + "); ";
			DB.close(resultSet);
			resultSet = DB.select(query8, connection);
			while (resultSet.next()) {
				wftypedetails.action.setActionid(resultSet.getInt("actionid"));
				wftypedetails.action.setActionname(resultSet
						.getString("actionname"));
				wftypedetails.action.setActiondescription(resultSet
						.getString("actiondescription"));
				wftypedetails.action.getWorkflowType().setWftypeid(
						resultSet.getInt("wftypeid"));
				wftypedetails.action.getWorkflowType().setWfname(
						resultSet.getString("wfname"));
				wftypedetails.action.getWorkflowType().setDescription(
						resultSet.getString("wfdescription"));
			}

			String query9 = "call display_workflow_instances(" + wftypeid
					+ "); ";
			DB.close(resultSet);
			resultSet = DB.select(query9, connection);
			// wftypedetails.associatedWorkflowInstances = new
			// ArrayList<WorkflowInstance>();
			while (resultSet.next()) {
				WorkflowInstance workflowInstance = new WorkflowInstance();
				workflowInstance.setWfinstanceid(resultSet
						.getInt("wfinstanceid"));
				workflowInstance.setCreationdatetime(resultSet
						.getString("creationdatetime"));
				workflowInstance.getOwner().setMemberid(
						resultSet.getInt("ownerid"));
				workflowInstance.getOwner().setFname(
						resultSet.getString("ownerfname"));
				workflowInstance.getOwner().setLname(
						resultSet.getString("ownerlname"));
				workflowInstance.getOwner().setEmailid(
						resultSet.getString("owneremailid"));
				workflowInstance.getOwner().setPhone(
						resultSet.getBigDecimal("ownerphone").toString());
				workflowInstance.getOwner().setAddress(
						resultSet.getString("owneraddress"));
				workflowInstance.getOwner().getRole()
						.setRoleid(resultSet.getInt("ownerroleid"));
				workflowInstance.getOwner().getRole()
						.setRolename(resultSet.getString("ownerrolename"));
				workflowInstance
						.getOwner()
						.getRole()
						.setRoledescription(
								resultSet.getString("ownerroledescription"));
				workflowInstance.getWfcategory().setWfcategoryid(
						resultSet.getInt("wfcategoryid"));
				workflowInstance.getWfcategory().setWfcategoryname(
						resultSet.getString("wfcategoryname"));
				workflowInstance.getCurrentstate().setStateID(
						resultSet.getInt("stateid"));
				workflowInstance.getCurrentstate().setStateName(
						resultSet.getString("statename"));
				workflowInstance.getCurrentstate().setStateDescription(
						resultSet.getString("statedescription"));
				workflowInstance.getWorkflowType().setWftypeid(
						resultSet.getInt("wftypeid"));
				workflowInstance.getWorkflowType().setWfname(
						resultSet.getString("wfname"));
				workflowInstance.getWorkflowType().setDescription(
						resultSet.getString("wfdescription"));
				wftypedetails.associatedWorkflowInstances.add(workflowInstance);
			}
			for (int i = 0; i < wftypedetails.associatedWorkflowInstances
					.size(); i++) {
				System.out.println(wftypedetails.associatedWorkflowInstances
						.get(i).getWorkflowType().getWfname()
						+ " "
						+ wftypedetails.associatedWorkflowInstances.get(i)
								.getWfinstanceid()
						+ " "
						+ wftypedetails.associatedWorkflowInstances.get(i)
								.getCurrentstate().getStateName());
			}

			String query10 = "call display_workflow_categories(" + wftypeid
					+ "); ";
			DB.close(resultSet);
			resultSet = DB.select(query10, connection);
			while (resultSet.next()) {
				WorkflowCategory category = new WorkflowCategory();
				category.setWfcategoryid(resultSet.getInt("wfcategoryid"));
				category.setWfcategoryname(resultSet
						.getString("wfcategoryname"));
				wftypedetails.associatedCategories.add(category);
			}

		} catch (SQLException e) {
			// MyLog.myCatch("Book.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return wftypedetails;
	}

	/**
	 * @return the associatedCategories
	 */
	public ArrayList<WorkflowCategory> getAssociatedCategories() {
		return associatedCategories;
	}

	/**
	 * @param associatedCategories
	 *            the associatedCategories to set
	 */
	public void setAssociatedCategories(
			ArrayList<WorkflowCategory> associatedCategories) {
		this.associatedCategories = associatedCategories;
	}

	public static ArrayList<WorkflowInstance> selectallInstancesMember(int memid) {
		ArrayList<WorkflowInstance> selection = new ArrayList<WorkflowInstance>();
		ResultSet resultSet = null;
		System.out
				.println("Quering select all in WorkflowInstance display_workflow_instances_member for member: "
						+ memid);
		String query = "call display_workflow_instances_member(" + memid
				+ "); ";
		Connection connection = DB.getConnection();
		resultSet = DB.select(query, connection);
		try {
			while (resultSet.next()) {
				WorkflowInstance workflowinstance = new WorkflowInstance();
				workflowinstance.setWfinstanceid(resultSet
						.getInt("wfinstanceid"));
				workflowinstance.getOwner().setMemberid(
						resultSet.getInt("ownerid"));
				workflowinstance.getOwner().setFname(
						resultSet.getString("ownername"));
				workflowinstance.getWorkflowType().setWfname(
						resultSet.getString("wfname"));
				int temp = resultSet.getInt("wftypeid");
				workflowinstance.getWorkflowType().setWftypeid(temp);
				workflowinstance.getWfcategory().setWfcategoryid(
						resultSet.getInt("wfcategoryid"));
				workflowinstance.getWfcategory().setWfcategoryname(
						resultSet.getString("wfcategoryname"));
				workflowinstance.getCurrentstate().setStateName(
						resultSet.getString("state"));
				workflowinstance.getCurrentstate().setStateDescription(
						resultSet.getString("statedescription"));
				workflowinstance.setCreationdatetime(resultSet
						.getString("creationdatetime"));
				selection.add(workflowinstance);
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
