// bla
package edu.edgewood.model;

import java.util.Date;

public class Modification {
	
	private int postId;
	private String modifierId;
	private Date dateModified;
	
	public Modification(){}
	
	public Modification(int postId, String modifierId, Date dateModified) {
		this.postId = postId;
		this.modifierId = modifierId;
		this.dateModified = dateModified;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	
	
	
	

}
