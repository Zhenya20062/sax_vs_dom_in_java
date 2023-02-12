package com.euzhene.sax_vs_dom;

public class GithubUser {
	private String id;
	private String name;
	private int projectCount;
	private String registered;
	private int commitCount;
	private int acceptedPullRequestCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public int getCommitCount() {
		return commitCount;
	}

	public void setCommitCount(int commitCount) {
		this.commitCount = commitCount;
	}

	public int getAcceptedPullRequestCount() {
		return acceptedPullRequestCount;
	}

	public void setAcceptedPullRequestCount(int acceptedPullRequestCount) {
		this.acceptedPullRequestCount = acceptedPullRequestCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
