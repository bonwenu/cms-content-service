package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class Content {
	@Id
	@GeneratedValue
	@Column(name = "c_id")
	private int id;

	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String format;

	@Column(nullable=false)
	private String description;

	@Column(nullable=false)
	private String url;
	
	/**
	 * The following fields, dateCreated and lastModified, were added in order to facilitate functionality for 
	 * displaying a graphical representation of content created over a period of time.
	 */
	
	@Column(name = "created")
	private long dateCreated;
	
	@Column(name = "last_modified")
	private long lastModified;
	
	@OneToMany(mappedBy ="contentId", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Link> links;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "userid")
	private User userid;
	    
	@Column(name = "status")
	private String status;
	
	public Content() {
		super();
	}
	
	

	public Content(int id, String title, String format, String description, String url, long dateCreated,
            long lastModified, Set<Link> links, User userid, String status) {
        super();
        this.id = id;
        this.title = title;
        this.format = format;
        this.description = description;
        this.url = url;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
        this.links = links;
        this.userid = userid;
        this.status = status;
    }

	public Content(int id, String title, String format, String description, String url, Set<Link> links, long dateCreated, long lastModified) {
		super();
		this.id = id;
		this.title = title;
		this.format = format;
		this.description = description;
		this.url = url;
		this.links = links;
		this.lastModified = lastModified;
		this.dateCreated = dateCreated;
		this.status = "pending";
		this.userid = new User();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Link> getLinks() {
		return links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}
	

	public long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}



	public User getUserid() {
		return userid;
	}



	public void setUserid(User userid) {
		this.userid = userid;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dateCreated ^ (dateCreated >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (lastModified ^ (lastModified >>> 32));
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		if (dateCreated != other.dateCreated)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (id != other.id)
			return false;
		if (lastModified != other.lastModified)
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", format=" + format + ", description=" + description
				+ ", url=" + url + ", dateCreated=" + dateCreated + ", lastModified=" + lastModified + ", links="
				+ links + ", userid=" + userid + ", status=" + status + "]";
	}

	
	
	
}
