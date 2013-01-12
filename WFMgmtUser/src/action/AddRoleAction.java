package action;

import java.util.ArrayList;

import model.Action;
import model.Role;
import model.WorkflowCategory;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddRoleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private WorkflowType wfType = new WorkflowType();
	private ArrayList<Role> roles = new ArrayList<Role>();
	private Role role = new Role();

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Inside AddRoleAction");
		System.out.println("Before insertion into db");
		System.out.println("RoleName: " + role.getRolename());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());

		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		if (wfType != null && wfType.getWftypeid() != 0) {
			role.getWorkflowType().setWftypeid(wfType.getWftypeid());
			if (role.getRolename() != null && !role.getRolename().equals("")) {
				role.insert();
			}
			roles = Role.selectallwftypeid(wfType.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
		}

		System.out.println("After insertion into db");
		System.out.println("RoleName: " + role.getRolename());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		role.setRolename("");
		role.setRoledescription("");
		role.getWorkflowType().setWfname("");
		role.getWorkflowType().setDescription("");
		role.getWorkflowType().setWftypeid(0);
		return SUCCESS;
	}
}
