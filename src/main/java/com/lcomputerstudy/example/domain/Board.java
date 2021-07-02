package com.lcomputerstudy.example.domain;

public class Board {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bDateTime;
	private String username;
	private int bCount;
	
	private int bGroup;
	private int bOrder;
	private int bDepth;
	
	
	private User user;
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbDateTime() {
		return bDateTime;
	}
	public void setbDateTime(String bDateTime) {
		this.bDateTime = bDateTime;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbOrder() {
		return bOrder;
	}
	public void setbOrder(int bOrder) {
		this.bOrder = bOrder;
	}
	public int getbDepth() {
		return bDepth;
	}
	public void setbDepth(int bDepth) {
		this.bDepth = bDepth;
	}
	
	
	@Override
	public String toString() {
		return "Board [bId=" + bId + ", bTitle=" + bTitle + ", bContent=" + bContent + ", usernamer=" + username
				+ ", bDateTime=" + bDateTime + "]";
	}
	
	
}
