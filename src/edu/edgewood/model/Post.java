package edu.edgewood.model;

import java.util.Date;

public class Post {
	
	private int postId;
	private String creatorId;
	private String title;
	private String shortDesc;
	private String longDesc;
	private Date dateCreated;
	
	public Post(){}

	public Post(int postId, String creatorId, String title, String shortDesc, String longDesc, Date dateCreated) {
		super();
		this.postId = postId;
		this.creatorId = creatorId;
		this.title = title;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.dateCreated = dateCreated;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
