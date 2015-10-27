package org.itehcs.report.gitlabUtil;

import java.io.Serializable;

public class MergeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5068769242743816640L;
	private String id;
	private String iid;
	private String project_id;
	private String title;
	private String description;
	private String state;
	private String created_at;
	private String updated_at;
	private String target_branch;
	private String source_branch;
	private String upvotes;
	private String downvotes;
	private String author;
	private String assignee;
	private String source_project_id;
	private String target_project_id;
	private String labels;
	private String milestone;

	public void setId(String s) {
		this.id = s;
	}
	public String getId()
	{
		return this.id;
	}
	public String getIid() {
		return this.iid;
	}

	public void setIid(String s) {
		this.iid = s;
	}

	public String getProject_id() {
		return this.project_id;
	}

	public void setProject_id(String s) {
		this.project_id = s;
	}

	public String getTtile() {
		return this.title;
	}

	public void setTitle(String s) {
		this.title = s;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String s) {
		this.description = s;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String s) {
		this.state = s;
	}

	public String getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(String s) {
		this.created_at = s;
	}

	public String getUpdated_at() {
		return this.updated_at;
	}

	public void setUpdated_at(String s) {
		this.updated_at = s;
	}

	public String getTarget_branch() {
		return this.target_branch;
	}

	public void setTarget_branch(String s) {
		this.target_branch = s;
	}

	public String getSource_branch() {
		return this.source_branch;
	}

	public void setSource_branch(String s) {
		this.source_branch = s;
	}

	public void setUpvotes(String s) {
		this.upvotes = s;
	}

	public String getUpvotes() {
		return this.upvotes;
	}

	public void setDownvotes(String s) {
		this.downvotes = s;
	}

	public String getDownvotes() {
		return this.downvotes;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String s) {
		this.author = s;
	}

	public void setAssignee(String s) {
		this.assignee = s;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setSource_project_id(String s) {
		this.source_project_id = s;
	}

	public String getSource_project_id() {
		return this.source_project_id;
	}

	public String getTarget_project_id() {

		return this.target_project_id;
	}

	public void settarget_project_id(String s) {
		this.target_project_id = s;
	}

	public String getLabels() {
		return this.labels;
	}

	public void setLabels(String s) {
		this.labels = s;
	}

	public String getMilestone(String s) {
		return this.milestone;
	}

	public void setMilestone(String s) {
		this.milestone =s;
	}
}
