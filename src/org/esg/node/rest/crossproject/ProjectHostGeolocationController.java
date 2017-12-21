package org.esg.node.rest.crossproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.esg.node.utils.Constants;
import org.esg.node.utils.Field;
import org.esg.node.utils.Row;
import org.esg.node.utils.SqlQuery;
import org.esg.node.utils.Table;

@Path("/cross-project/stats-by-space")
public class ProjectHostGeolocationController {
	
	@Path("/xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public Table<Row> getXml() throws SQLException {
		
		List<Row> rowList = new ArrayList<Row>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_PROJECT_HOST_GEOLOCATION.getSql());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	
            	Row row = new Row();
                ArrayList<Field> rowsArray = new ArrayList<Field>();
                
                Field total_size = new Field();
                total_size.setName("total_size");
                total_size.setValue(String.valueOf(rs.getLong("total_size")));
                rowsArray.add(total_size);
                
                Field number_of_downloads = new Field();
                number_of_downloads.setName("number_of_downloads");
                number_of_downloads.setValue(String.valueOf(rs.getLong("number_of_downloads")));
                rowsArray.add(number_of_downloads);
                
                Field number_of_successful_downloads = new Field();
                number_of_successful_downloads.setName("number_of_successful_downloads");
                number_of_successful_downloads.setValue(String.valueOf(rs.getLong("number_of_successful_downloads")));
                rowsArray.add(number_of_successful_downloads);
                
                Field number_of_replica_downloads = new Field();
                number_of_replica_downloads.setName("number_of_replica_downloads");
                number_of_replica_downloads.setValue(String.valueOf(rs.getLong("number_of_replica_downloads")));
                rowsArray.add(number_of_replica_downloads);
                                
                Field average_duration = new Field();
                average_duration.setName("average_duration");
                average_duration.setValue(String.valueOf(rs.getInt("average_duration")));     
                rowsArray.add(average_duration);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("number_of_users")));     
                rowsArray.add(number_of_users);
                
                Field host_name = new Field();
                host_name.setName("host_name");
                host_name.setValue(String.valueOf(rs.getString("host_name")));     
                rowsArray.add(host_name);
                
                Field project_name = new Field();
                project_name.setName("project_name");
                project_name.setValue(String.valueOf(rs.getString("project_name")));     
                rowsArray.add(project_name);
                
                Field latitude = new Field();
                latitude.setName("latitude");
                latitude.setValue(String.valueOf(rs.getDouble("latitude")));     
                rowsArray.add(latitude);
                
                Field longitude = new Field();
                longitude.setName("longitude");
                longitude.setValue(String.valueOf(rs.getDouble("longitude")));     
                rowsArray.add(longitude);
                
                Field country_id = new Field();
                country_id.setName("country_id");
                country_id.setValue(String.valueOf(rs.getInt("country_id")));     
                rowsArray.add(country_id);
                
                row.setFieldList(rowsArray);
                
        	    rowList.add(row);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        Table<Row> listOfRows = new Table<Row> (rowList);
	    listOfRows.setName("cross_dmart_project_host_geolocation");

	    return listOfRows;
	}
	
	@Path("json")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Table<Row> getJson() throws SQLException {
		
		List<Row> rowList = new ArrayList<Row>(); 
		Connection conn = null;
		
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_PROJECT_HOST_GEOLOCATION.getSql());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	
            	Row row = new Row();
                ArrayList<Field> rowsArray = new ArrayList<Field>();
                
                Field total_size = new Field();
                total_size.setName("total_size");
                total_size.setValue(String.valueOf(rs.getLong("total_size")));
                rowsArray.add(total_size);
                
                Field number_of_downloads = new Field();
                number_of_downloads.setName("number_of_downloads");
                number_of_downloads.setValue(String.valueOf(rs.getLong("number_of_downloads")));
                rowsArray.add(number_of_downloads);
                
                Field number_of_successful_downloads = new Field();
                number_of_successful_downloads.setName("number_of_successful_downloads");
                number_of_successful_downloads.setValue(String.valueOf(rs.getLong("number_of_successful_downloads")));
                rowsArray.add(number_of_successful_downloads);
                
                Field number_of_replica_downloads = new Field();
                number_of_replica_downloads.setName("number_of_replica_downloads");
                number_of_replica_downloads.setValue(String.valueOf(rs.getLong("number_of_replica_downloads")));
                rowsArray.add(number_of_replica_downloads);
                                
                Field average_duration = new Field();
                average_duration.setName("average_duration");
                average_duration.setValue(String.valueOf(rs.getInt("average_duration")));     
                rowsArray.add(average_duration);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("number_of_users")));     
                rowsArray.add(number_of_users);
                
                Field host_name = new Field();
                host_name.setName("host_name");
                host_name.setValue(String.valueOf(rs.getString("host_name")));     
                rowsArray.add(host_name);
                
                Field project_name = new Field();
                project_name.setName("project_name");
                project_name.setValue(String.valueOf(rs.getString("project_name")));     
                rowsArray.add(project_name);
                
                Field latitude = new Field();
                latitude.setName("latitude");
                latitude.setValue(String.valueOf(rs.getDouble("latitude")));     
                rowsArray.add(latitude);
                
                Field longitude = new Field();
                longitude.setName("longitude");
                longitude.setValue(String.valueOf(rs.getDouble("longitude")));     
                rowsArray.add(longitude);
                
                row.setFieldList(rowsArray);
                
        	    rowList.add(row);
            }
            
            rs.close();
            stmt.close();
        } catch(SQLException e) {
				System.out.println(e.getMessage());
        } finally {
                if(conn != null) conn.close();
        }
 
        Table<Row> listOfRows = new Table<Row> (rowList);
	    listOfRows.setName("cross_dmart_project_host_geolocation");

	    return listOfRows;
	}
}
