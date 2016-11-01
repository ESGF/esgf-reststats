package org.esg.node.rest.cmip5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.esg.node.utils.Constants;
import org.esg.node.utils.SqlQuery;

@Path("/cmip5/variable_host_time")
public class VariableHostTimeController {
	
	@Path("xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<VariableHostTime> getXml() throws SQLException {
		
		List<VariableHostTime> dmvalues = new LinkedList<VariableHostTime>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CMIP5_VARIABLE_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	Long total_size = rs.getLong("month");
            	Long number_of_downloads = rs.getLong("number_of_downloads");
            	Long number_of_successful_downloads = rs.getLong("number_of_successful_downloads");
            	Integer average_duration = rs.getInt("average_duration");
            	Integer number_of_users = rs.getInt("number_of_users");
            	Long number_of_replica_downloads = rs.getLong("number_of_replica_downloads");
            	Integer month = rs.getInt("month");
            	Integer year = rs.getInt("year");
            	String host_name = rs.getString("host_name");
            	String variable_code = rs.getString("variable_code");
            	String variable_long_name = rs.getString("variable_long_name");
            	String cf_standard_name = rs.getString("cf_standard_name");
            	
            	VariableHostTime dmvalue = new VariableHostTime(total_size, number_of_downloads, 
            			number_of_successful_downloads, average_duration, number_of_users, 
            			number_of_replica_downloads, 
            			month, year, host_name, variable_code, variable_long_name, cf_standard_name);
            	dmvalues.add(dmvalue);
            	
            }
            
            rs.close();
            stmt.close();
	    } catch(SQLException e) {
				System.out.println(e.getMessage());
	    } finally {
	            if(conn != null) conn.close();
	    }
		
        List<VariableHostTime> result = dmvalues;
		
		return result;
	}
	
	@Path("json")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<VariableHostTime> getXmlJson() throws SQLException {
		
		List<VariableHostTime> dmvalues = new LinkedList<VariableHostTime>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CMIP5_VARIABLE_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	Long total_size = rs.getLong("month");
            	Long number_of_downloads = rs.getLong("number_of_downloads");
            	Long number_of_successful_downloads = rs.getLong("number_of_successful_downloads");
            	Integer average_duration = rs.getInt("average_duration");
            	Integer number_of_users = rs.getInt("number_of_users");
            	Long number_of_replica_downloads = rs.getLong("number_of_replica_downloads");
            	Integer month = rs.getInt("month");
            	Integer year = rs.getInt("year");
            	String host_name = rs.getString("host_name");
            	String variable_code = rs.getString("variable_code");
            	String variable_long_name = rs.getString("variable_long_name");
            	String cf_standard_name = rs.getString("cf_standard_name");
            	
            	VariableHostTime dmvalue = new VariableHostTime(total_size, number_of_downloads, 
            			number_of_successful_downloads, average_duration, number_of_users, 
            			number_of_replica_downloads, 
            			month, year, host_name, variable_code, variable_long_name, cf_standard_name);
            	dmvalues.add(dmvalue);
            	
            }
            
            rs.close();
            stmt.close();
	    } catch(SQLException e) {
				System.out.println(e.getMessage());
	    } finally {
	            if(conn != null) conn.close();
	    }
		
        List<VariableHostTime> result = dmvalues;
		
		return result;
	}

}
