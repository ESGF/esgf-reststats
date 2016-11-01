package org.esg.node.rest.crossproject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProjectHostTime {
	
	private Long    total_size;
	private Long    number_of_downloads;
	private Long    number_of_successful_downloads;
	private Long    number_of_replica_downloads;
	private Integer average_duration;
	private Integer number_of_users;
	private String  host_name;
	private String  project_name;
	private Integer month;
	private Integer year;
	
	public ProjectHostTime() {
		super();
	}

	public ProjectHostTime(Long total_size, Long number_of_downloads, Long number_of_successful_downloads,
			Long number_of_replica_downloads, Integer average_duration, Integer number_of_users, String host_name,
			String project_name, Integer month, Integer year) {
		super();
		this.total_size = total_size;
		this.number_of_downloads = number_of_downloads;
		this.number_of_successful_downloads = number_of_successful_downloads;
		this.number_of_replica_downloads = number_of_replica_downloads;
		this.average_duration = average_duration;
		this.number_of_users = number_of_users;
		this.host_name = host_name;
		this.project_name = project_name;
		this.month = month;
		this.year = year;
	}

	public Long getTotal_size() {
		return total_size;
	}

	public void setTotal_size(Long total_size) {
		this.total_size = total_size;
	}

	public Long getNumber_of_downloads() {
		return number_of_downloads;
	}

	public void setNumber_of_downloads(Long number_of_downloads) {
		this.number_of_downloads = number_of_downloads;
	}

	public Long getNumber_of_successful_downloads() {
		return number_of_successful_downloads;
	}

	public void setNumber_of_successful_downloads(Long number_of_successful_downloads) {
		this.number_of_successful_downloads = number_of_successful_downloads;
	}

	public Long getNumber_of_replica_downloads() {
		return number_of_replica_downloads;
	}

	public void setNumber_of_replica_downloads(Long number_of_replica_downloads) {
		this.number_of_replica_downloads = number_of_replica_downloads;
	}

	public Integer getAverage_duration() {
		return average_duration;
	}

	public void setAverage_duration(Integer average_duration) {
		this.average_duration = average_duration;
	}

	public Integer getNumber_of_users() {
		return number_of_users;
	}

	public void setNumber_of_users(Integer number_of_users) {
		this.number_of_users = number_of_users;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}