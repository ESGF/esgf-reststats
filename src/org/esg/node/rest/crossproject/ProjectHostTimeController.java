package org.esg.node.rest.crossproject;

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
import org.json.JSONException;

import org.esg.node.utils.Constants;
import org.esg.node.utils.SqlQuery;

@Path("/crossproject/projecttime")
public class ProjectHostTimeController {
	
	@Path("xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<ProjectHostTime> getAlldatausage() throws SQLException {
		
		List<ProjectHostTime> dmvalues = new LinkedList<ProjectHostTime>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_PROJECT_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Long total_size                     = rs.getLong("total_size");
            	Long number_of_downloads            = rs.getLong("number_of_downloads");
            	Long number_of_successful_downloads = rs.getLong("number_of_successful_downloads");
            	Long number_of_replica_downloads    = rs.getLong("number_of_replica_downloads");
            	Integer average_duration            = rs.getInt("average_duration");
            	Integer number_of_users             = rs.getInt("number_of_users");
            	String host_name                    = rs.getString("host_name");
            	String project_name                 = rs.getString("project_name");
            	Integer month                       = rs.getInt("month");
            	Integer year                        = rs.getInt("year");
            	
            	ProjectHostTime pht = new ProjectHostTime(total_size, number_of_downloads, number_of_successful_downloads, number_of_replica_downloads,
            			average_duration, number_of_users, host_name, project_name, month, year);
            	dmvalues.add(pht);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<ProjectHostTime> result = dmvalues;
		
		return result;
	}
	
	@Path("json")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<ProjectHostTime> getAllDataUsageJson() throws JSONException, SQLException {
		
		List<ProjectHostTime> dmvalues = new LinkedList<ProjectHostTime>(); 
		Connection conn = null;
		
        try {
        	conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_PROJECT_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Long total_size                     = rs.getLong("total_size");
            	Long number_of_downloads            = rs.getLong("number_of_downloads");
            	Long number_of_successful_downloads = rs.getLong("number_of_successful_downloads");
            	Long number_of_replica_downloads    = rs.getLong("number_of_replica_downloads");
            	Integer average_duration            = rs.getInt("average_duration");
            	Integer number_of_users             = rs.getInt("number_of_users");
            	String host_name                    = rs.getString("host_name");
            	String project_name                 = rs.getString("project_name");
            	Integer month                       = rs.getInt("month");
            	Integer year                        = rs.getInt("year");
            	
            	ProjectHostTime pht = new ProjectHostTime(total_size, number_of_downloads, number_of_successful_downloads, number_of_replica_downloads,
            			average_duration, number_of_users, host_name, project_name, month, year);
            	dmvalues.add(pht);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<ProjectHostTime> result = dmvalues;
		
		return result;
	}
}
