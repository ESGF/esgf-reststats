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

@Path("/crossproject/projectgeolocation")
public class ProjectHostGeolocationController {
	
	@Path("xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<ProjectHostGeolocation> getAlldatausage() throws SQLException {
		
		List<ProjectHostGeolocation> dmvalues = new LinkedList<ProjectHostGeolocation>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_PROJECT_HOST_GEOLOCATION.getSql());
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
            	Double latitude                     = rs.getDouble("latitude");
            	Double longitude                    = rs.getDouble("longitude");
            	
            	ProjectHostGeolocation phg = new ProjectHostGeolocation(total_size, number_of_downloads, number_of_successful_downloads, number_of_replica_downloads,
            			average_duration, number_of_users, host_name, project_name, latitude, longitude);
            	dmvalues.add(phg);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<ProjectHostGeolocation> result = dmvalues;
		
		return result;
	}
	
	@Path("json")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<ProjectHostGeolocation> getAllDataUsageJson() throws JSONException, SQLException {
		
		List<ProjectHostGeolocation> dmvalues = new LinkedList<ProjectHostGeolocation>(); 
		Connection conn = null;
		
        try {
        	conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_PROJECT_HOST_GEOLOCATION.getSql());
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
            	Double latitude                     = rs.getDouble("latitude");
            	Double longitude                    = rs.getDouble("longitude");
            	
            	ProjectHostGeolocation phg = new ProjectHostGeolocation(total_size, number_of_downloads, number_of_successful_downloads, number_of_replica_downloads,
            			average_duration, number_of_users, host_name, project_name, latitude, longitude);
            	dmvalues.add(phg);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<ProjectHostGeolocation> result = dmvalues;
		
		return result;
	}
}
