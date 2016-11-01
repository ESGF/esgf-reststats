package org.esg.node.utils;

import org.postgresql.ds.PGSimpleDataSource;
import esg.common.util.ESGFProperties;

/**
 * @author CMCC
 */
public abstract class Constants { 

    public static PGSimpleDataSource DATASOURCE = null;
    public static String DASHBOARD_SERVICE_PATH = null;

	static {
		try{
            ESGFProperties esgfProperties = new ESGFProperties();
            
            DATASOURCE = new PGSimpleDataSource();
            DATASOURCE.setDatabaseName(esgfProperties.getProperty("db.database"));
            DATASOURCE.setServerName(esgfProperties.getProperty("db.host"));
            DATASOURCE.setUser(esgfProperties.getProperty("db.user"));
            DATASOURCE.setPassword(esgfProperties.getDatabasePassword());
            DATASOURCE.setPortNumber(Integer.valueOf(esgfProperties.getProperty("db.port")));
            DASHBOARD_SERVICE_PATH = esgfProperties.getProperty("dashboard.ip.app.home");
        }
		catch (Throwable e) {
			e.printStackTrace(); System.out.println(e.getMessage());
		}
    }
}


