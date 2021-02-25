package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "ptitle")
	private String ptitle;
	
	@Column(name = "pdesc")
	private String pdesc;
	
	@Column(name = "pdate")
	private String pdate;
	
	
	@Column(name = "fimage")
	private String fimage;
	
	@Column(name = "feature")
	private String feature;
	
	
	@Column(name = "cname")
	private String cname;

	@Column(name = "username")
	private String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getFimage() {
		return fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "PostModel [id=" + id + ", ptitle=" + ptitle + ", pdesc=" + pdesc + ", pdate=" + pdate + ", fimage="
				+ fimage + ", feature=" + feature + ", cname=" + cname + ", username=" + username + "]";
	}


}
