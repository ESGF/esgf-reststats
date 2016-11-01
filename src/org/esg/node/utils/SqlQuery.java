package org.esg.node.utils;

public enum SqlQuery {
	
    CMIP5_DATA_USAGE("SELECT * FROM esgf_dashboard.cmip5_data_usage"),
    CORDEX_DATA_USAGE("SELECT * FROM esgf_dashboard.cordex_data_usage"),
    OBS4MIPS_DATA_USAGE("SELECT * FROM esgf_dashboard.obs_data_usage"),
    ALL_DATA_USAGE("SELECT * FROM esgf_dashboard.all_data_usage"),
    CLIENT_STATS_DM("SELECT * FROM esgf_dashboard.client_stats_dm"),
    
    /** cross project **/
    CROSS_DMART_PROJECT_HOST_TIME("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, number_of_replica_downloads," +
    		"average_duration, number_of_users, host_name, project_name, month, year " +
    		"FROM esgf_dashboard.cross_dmart_project_host_time;"),
    CROSS_DMART_PROJECT_HOST_GEOLOCATION("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, number_of_replica_downloads," +
    		"average_duration, number_of_users, host_name, project_name, latitude, longitude " +
    		"FROM esgf_dashboard.cross_dmart_project_host_geolocation;"),
    /** cross project **/
    
    /** obs4mips **/
    OBS_DMART_CLIENTS_HOST_TIME_GEOLOCATION("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, " +
    		"average_duration, number_of_users, month, year, latitude, longitude, host_name " +
    		"FROM esgf_dashboard.obs4mips_dmart_clients_host_time_geolocation;"),
    OBS_DMART_VARIABLE_HOST_TIME("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, average_duration, " +
    		"number_of_users, month, year, host_name, variable_code, variable_long_name, cf_standard_name " +
    		"FROM esgf_dashboard.obs4mips_dmart_variable_host_time;"),
    OBS_DMART_SOURCE_HOST_TIME("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, average_duration, " +
    		"number_of_users, month, year, host_name, source_id_name " +
    		"FROM esgf_dashboard.obs4mips_dmart_source_host_time;"),
    OBS_DMART_REALM_HOST_TIME("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, average_duration, " +
    		"number_of_users, month, year, host_name, realm_name " +
    		"FROM esgf_dashboard.obs4mips_dmart_realm_host_time;"),
    OBS_DMART_DATASET_HOST_TIME("SELECT " +
    		"total_size, number_of_downloads, number_of_successful_downloads, average_duration, " +
    		"number_of_users, month, year, host_name, dataset_name, dataset_version, datetime_start, datetime_stop " +
    		"FROM esgf_dashboard.obs4mips_dmart_dataset_host_time;");
	/** obs4mips **/
	
	private final String sql;
	
	SqlQuery(final String sql) {
		this.sql = sql;
	}

	public String getSql() {
		return sql;
	}
	
	@Override
	public String toString() {
		return getSql();
	}
}
