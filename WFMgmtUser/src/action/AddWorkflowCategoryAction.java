package action;

import java.util.ArrayList;

import model.WorkflowCategory;
import model.WorkflowType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddWorkflowCategoryAction extends ActionSupport {
	private WorkflowType wfType = new WorkflowType();
	private WorkflowCategory wfCategory = new WorkflowCategory();
	private ArrayList<WorkflowCategory> wfCategories = new ArrayList<WorkflowCategory>();

	public WorkflowCategory getWfCategory() {
		return wfCategory;
	}

	public void setWfCategory(WorkflowCategory wfCategory) {
		this.wfCategory = wfCategory;
	}

	public ArrayList<WorkflowCategory> getWfCategories() {
		return wfCategories;
	}

	public void setWfCategories(ArrayList<WorkflowCategory> wfCategories) {
		this.wfCategories = wfCategories;
	}

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Inside AddWorkflowCategoryAction");
		System.out.println("Before insertion into db");
		System.out.println("CategoryName: " + wfCategory.getWfcategoryname());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());

		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		if (wfType != null && wfType.getWftypeid() != 0) {
			wfCategory.setWftypeid(wfType.getWftypeid());
			if (wfCategory.getWfcategoryname() != null
					&& !wfCategory.getWfcategoryname().equals("")) {
				wfCategory.insert();
			}
			wfCategories = WorkflowCategory.selectall(wfType.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
		}

		System.out.println("After insertion into db");
		System.out.println("CategoryName: " + wfCategory.getWfcategoryname());
		System.out.println("id" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		wfCategory.setWfcategoryname("");
		return SUCCESS;
	}
}
