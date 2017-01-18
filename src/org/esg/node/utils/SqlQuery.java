package org.esg.node.utils;

public enum SqlQuery {
	
    CMIP5_DATA_USAGE("SELECT * FROM esgf_dashboard.cmip5_data_usage"),
    CORDEX_DATA_USAGE("SELECT * FROM esgf_dashboard.cordex_data_usage"),
    OBS4MIPS_DATA_USAGE("SELECT * FROM esgf_dashboard.obs_data_usage"),
    ALL_DATA_USAGE("SELECT * FROM esgf_dashboard.all_data_usage"),
    CLIENT_STATS_DM("SELECT * FROM esgf_dashboard.client_stats_dm"),
    
    /** cross project **/
    CROSS_DMART_PROJECT_HOST_TIME("SELECT * FROM esgf_dashboard.cross_dmart_project_host_time;"),
    CROSS_DMART_PROJECT_HOST_GEOLOCATION("SELECT * FROM esgf_dashboard.cross_dmart_project_host_geolocation;"),
    /** cross project **/
    
    /** obs4mips **/
    OBS_DMART_CLIENTS_HOST_TIME_GEOLOCATION("SELECT * FROM esgf_dashboard.obs4mips_dmart_clients_host_time_geolocation;"),
    OBS_DMART_VARIABLE_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_variable_host_time;"),
    OBS_DMART_SOURCE_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_source_host_time;"),
    OBS_DMART_REALM_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_realm_host_time;"),
    OBS_DMART_DATASET_HOST_TIME("SELECT * FROM esgf_dashboard.obs4mips_dmart_dataset_host_time;"),
	/** obs4mips **/

    /** cmip5 **/
    CMIP5_HOST_TIME_GEOLOCATION("SELECT * FROM esgf_dashboard.cmip5_dmart_clients_host_time_geolocation"),
    CMIP5_MODEL_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_model_host_time"),
    CMIP5_EXPERIMENT_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_experiment_host_time"),
    CMIP5_VARIABLE_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_variable_host_time"),
    CMIP5_DATASET_HOST_TIME("SELECT * FROM esgf_dashboard.cmip5_dmart_dataset_host_time"),
    /** cmip5 **/
	
	/** is-enes stats **/
    CROSS_DMART_ISENES_STATS("SELECT * from esgf_dashboard.cross_dmart_isenes_stats");
    /** is-enes stats **/

	
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
