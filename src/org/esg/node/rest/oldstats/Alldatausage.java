package org.esg.node.rest.oldstats;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alldatausage {
	
	private Double year;
	private Double month;
	private Integer downloads;
	private Integer files;
	private Integer users;
	private Double  gb;
	private String  host;
	
	public Alldatausage() {
		super();
	}

	public Alldatausage(Double year, Double month, Integer downloads,
			Integer files, Integer users, Double gb, String host) {
		super();
		this.year = year;
		this.month = month;
		this.downloads = downloads;
		this.files = files;
		this.users = users;
		this.gb = gb;
		this.host = host;
	}

	public Double getYear() {
		return year;
	}

	public void setYear(Double year) {
		this.year = year;
	}

	public Double getMonth() {
		return month;
	}

	public void setMonth(Double month) {
		this.month = month;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public Integer getFiles() {
		return files;
	}

	public void setFiles(Integer files) {
		this.files = files;
	}

	public Integer getUsers() {
		return users;
	}

	public void setUsers(Integer users) {
		this.users = users;
	}

	public Double getGb() {
		return gb;
	}

	public void setGb(Double gb) {
		this.gb = gb;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}