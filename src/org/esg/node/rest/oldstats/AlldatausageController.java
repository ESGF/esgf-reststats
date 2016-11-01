package org.esg.node.rest.oldstats;

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

@Path("/oldstats/alldatausage")
public class AlldatausageController {
	
	@Path("xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<Alldatausage> getAlldatausage() throws SQLException {
		
		List<Alldatausage> dmvalues = new LinkedList<Alldatausage>(); 
		Connection conn = null;
		
        try {
                conn = Constants.DATASOURCE.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlQuery.ALL_DATA_USAGE.getSql());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                	Double year       = rs.getDouble("year");
                	Double month      = rs.getDouble("month");
                	Integer downloads = rs.getInt("downloads");
                	Integer files     = rs.getInt("files");
                	Integer users     = rs.getInt("users");
                	Double gb         = rs.getDouble("gb");
                	String host       = rs.getString("host");
                	Alldatausage du = new Alldatausage(year, month, downloads, files, users, gb, host);
                	dmvalues.add(du);
                }
                
                rs.close();
                stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<Alldatausage> result = dmvalues;
		
		return result;
	}
	
	@Path("json")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Alldatausage> getAllDataUsageJson() throws JSONException, SQLException {
		
		List<Alldatausage> dmvalues = new LinkedList<Alldatausage>(); 
		Connection conn = null;
		
        try {
                conn = Constants.DATASOURCE.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlQuery.ALL_DATA_USAGE.getSql());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                	Double year       = rs.getDouble("year");
                	Double month      = rs.getDouble("month");
                	Integer downloads = rs.getInt("downloads");
                	Integer files     = rs.getInt("files");
                	Integer users     = rs.getInt("users");
                	Double gb         = rs.getDouble("gb");
                	String host       = rs.getString("host");
                	Alldatausage du = new Alldatausage(year, month, downloads, files, users, gb, host);
                	dmvalues.add(du);
                }
                
                rs.close();
                stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        List<Alldatausage> result = dmvalues;
		
		return result;
	}
}
