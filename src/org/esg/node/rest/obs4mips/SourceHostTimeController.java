package org.esg.node.rest.obs4mips;

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

@Path("/obs4mips/source")
public class SourceHostTimeController {
	
	@Path("xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<SourceHostTime> getAlldatausage() throws SQLException {
		
		List<SourceHostTime> dmvalues = new LinkedList<SourceHostTime>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.OBS_DMART_SOURCE_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Long total_size                     = rs.getLong("total_size");
            	Long number_of_downloads            = rs.getLong("number_of_downloads");
            	Long number_of_successful_downloads = rs.getLong("number_of_successful_downloads");
            	Integer average_duration            = rs.getInt("average_duration");
            	Integer number_of_users             = rs.getInt("number_of_users");
            	Integer month                       = rs.getInt("month");
            	Integer year                        = rs.getInt("year");
            	String host_name                    = rs.getString("host_name");
            	String source_id_name               = rs.getString("source_id_name");
            	
            	SourceHostTime sht = new SourceHostTime(total_size, number_of_downloads, number_of_successful_downloads, average_duration,
            			number_of_users, month, year, host_name, source_id_name);
            	dmvalues.add(sht);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<SourceHostTime> result = dmvalues;
		
		return result;
	}
	
	@Path("json")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<SourceHostTime> getAllDataUsageJson() throws JSONException, SQLException {
		
		List<SourceHostTime> dmvalues = new LinkedList<SourceHostTime>(); 
		Connection conn = null;
		
        try {
        	conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.OBS_DMART_SOURCE_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Long total_size                     = rs.getLong("total_size");
            	Long number_of_downloads            = rs.getLong("number_of_downloads");
            	Long number_of_successful_downloads = rs.getLong("number_of_successful_downloads");
            	Integer average_duration            = rs.getInt("average_duration");
            	Integer number_of_users             = rs.getInt("number_of_users");
            	Integer month                       = rs.getInt("month");
            	Integer year                        = rs.getInt("year");
            	String host_name                    = rs.getString("host_name");
            	String source_id_name               = rs.getString("source_id_name");
            	
            	SourceHostTime sht = new SourceHostTime(total_size, number_of_downloads, number_of_successful_downloads, average_duration,
            			number_of_users, month, year, host_name, source_id_name);
            	dmvalues.add(sht);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<SourceHostTime> result = dmvalues;
		
		return result;
	}
}
