package org.esg.node.utils;

public enum SqlQuery {
	
	/** historical **/
    CMIP5_DATA_USAGE("SELECT * FROM esgf_dashboard.cmip5_data_usage WHERE year < 2017;"),
    CORDEX_DATA_USAGE("SELECT * FROM esgf_dashboard.cordex_data_usage WHERE year < 2017;"),
    OBS4MIPS_DATA_USAGE("SELECT * FROM esgf_dashboard.obs4mips_data_usage WHERE year < 2017;"),
    ALL_DATA_USAGE("SELECT * FROM esgf_dashboard.all_data_usage WHERE year < 2017;"),
    
    CMIP5_DATA_USAGE_CONTINENT("SELECT * FROM esgf_dashboard.cmip5_data_usage_continent WHERE year < 2017;"),
    CORDEX_DATA_USAGE_CONTINENT("SELECT * FROM esgf_dashboard.cordex_data_usage_continent WHERE year < 2017;"),
    OBS4MIPS_DATA_USAGE_CONTINENT("SELECT * FROM esgf_dashboard.obs4mips_data_usage_continent WHERE year < 2017;"),
    ALL_DATA_USAGE_CONTINENT("SELECT * FROM esgf_dashboard.all_data_usage_continent WHERE year < 2017;"),
    
    COARSE_STATS_EUROPE("SELECT * FROM esgf_dashboard.all_data_usage_continent WHERE continent='Europe' AND year < 2017;"),
    COARSE_STATS_NOT_EUROPE("SELECT year, month, SUM(downloads) AS downloads, SUM(files) AS files, SUM(users) AS users, SUM(gb) AS gb, host " +
    		"FROM esgf_dashboard.all_data_usage_continent " +
    		"WHERE continent!='Europe' AND year < 2017 " +
    		"GROUP BY year, month, host " +
    		"ORDER BY year, month ASC;"),
    /** historical **/
    
    /** cross project **/
    CROSS_DMART_PROJECT_HOST_TIME("SELECT * FROM esgf_dashboard.cross_dmart_project_host_time WHERE year >= 2017;"),
    CROSS_DMART_PROJECT_HOST_GEOLOCATION("SELECT * FROM esgf_dashboard.cross_dmart_project_host_geolocation;"),
    /** cross project **/
    
    /** obs4mips **/
    OBS_DMART_CLIENTS_HOST_TIME_GEOLOCATION("SELECT * FROM esgf_dashboard.obs4mips_dmart_clients_host_time_geolocation WHERE year >= 2017;"),
    OBS_DMART_VARIABLE_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_variable_host_time WHERE year >= 2017;"),
    OBS_DMART_SOURCE_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_source_host_time WHERE year >= 2017;"),
    OBS_DMART_REALM_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_realm_host_time WHERE year >= 2017;"),
    OBS_DMART_DATASET_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_dataset_host_time WHERE year >= 2017;"),
	/** obs4mips **/

    /** cmip5 **/
    CMIP5_HOST_TIME_GEOLOCATION("SELECT * FROM esgf_dashboard.cmip5_dmart_clients_host_time_geolocation WHERE year >= 2017;"),
    CMIP5_MODEL_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_model_host_time WHERE year >= 2017;"),
    CMIP5_EXPERIMENT_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_experiment_host_time WHERE year >= 2017;"),
    CMIP5_VARIABLE_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_variable_host_time WHERE year >= 2017;"),
    CMIP5_DATASET_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_dataset_host_time WHERE year >= 2017;");
    /** cmip5 **/
	
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
