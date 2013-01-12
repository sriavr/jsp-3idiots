package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import mail.SendMail;
import model.Admin;
import model.Member;
import util.DB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProgressWorkflowAction extends ActionSupport {
	String instanceid;
	int actorid;
	int actionid;
	String cmd;

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getInstanceid() {
		return instanceid;
	}

	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}

	public int getActorid() {
		return actorid;
	}

	public void setActorid(int actorid) {
		this.actorid = actorid;
	}

	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

	int wftypeid;

	public String execute() throws Exception {
		System.out.println("In ProgressWorkflowAction actorid:" + actorid
				+ " actionid:" + actionid + " instanceid" + instanceid);
		System.out.println("Inside execute method of Progressworkflowaction");
		boolean isAdmin = (Boolean) ActionContext.getContext().getSession()
				.get("isAdmin");
		Integer wfinstanceid = (Integer) ActionContext.getContext().getSession().get("currentinstance");
		instanceid = wfinstanceid.toString();
		System.out.println("instanceid from session" + instanceid);
		Member member;
		Admin admin;
		int roleid = 0;
		if (isAdmin) {
			wftypeid = 0;
		} else {
			member = (Member) ActionContext.getContext().getSession()
					.get("memberloggedin");
			wftypeid = member.getRole().getWorkflowType().getWftypeid();
			roleid = member.getRole().getRoleid();
			actorid = member.getMemberid();
		}
		System.out.println("wftype id " + wftypeid + " cmd:" + cmd + " roleid:"
				+ roleid);

		SendMail send_mail = new SendMail();
		if (cmd.equalsIgnoreCase("submitworkflow")) {
			if (selectOne() == 0) {
				send_mail
						.sendMail(
								"noreply.workflow@gmail.com",
								"ksbhavaani@gmail.com",
								"Confirmation Mail",
								"Hi, This is to inform that workflow has been not been successfull due to incorrect access");
				return ERROR;
			} else {
				send_mail
						.sendMail("noreply.workflow@gmail.com",
								"ksbhavaani@gmail.com", "Confirmation Mail",
								"Hi, This is to confirm that workflow has been successfully submitted");
				return SUCCESS;
			}
		}

		return ERROR;
	};

	public int selectOne() {
		ResultSet resultSet = null;
		String query = "call progress_workflow_instance(" + instanceid + ","
				+ actorid + "," + actionid + ");";
		Connection connection = DB.getConnection();
		int eventhistoryid = 0;
		resultSet = DB.select(query, connection);
		System.out.println("Running query for progressing workflow: " + query);
		try {
			if (resultSet.next()) {
				eventhistoryid = resultSet.getInt("eventhistoryid");
			}
			System.out.println("Eventhistoryid after execution:"
					+ eventhistoryid);
		} catch (SQLException e) {
			// MyLog.myCatch("workflow.java", 43, e);
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return eventhistoryid;
	}

}
