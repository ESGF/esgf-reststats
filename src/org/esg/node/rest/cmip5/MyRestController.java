package org.esg.node.rest.cmip5;

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
import org.esg.node.utils.SqlQuery;

@Path("/test")
public class MyRestController {
 
	@Path("/prova.xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public Table<Row> getRowListInXML() throws SQLException{
		
	    List<Row> rowList = new ArrayList<Row>();
	    Connection conn = null;
	    
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CMIP5_DATASET_HOST_TIME.getSql());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	
            	Row row = new Row();
            	
                ArrayList<Field> rowsArray = new ArrayList<Field>();
                
                Field d_mart_key = new Field();
                d_mart_key.setName("d_mart_key");
                d_mart_key.setValue(String.valueOf(rs.getLong("dmart_key")));
                rowsArray.add(d_mart_key);
                
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
                                
                Field average_duration = new Field();
                average_duration.setName("average_duration");
                average_duration.setValue(String.valueOf(rs.getInt("average_duration")));     
                rowsArray.add(average_duration);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("number_of_users")));     
                rowsArray.add(number_of_users);
                
                Field number_of_replica_downloads = new Field();
                number_of_replica_downloads.setName("number_of_replica_downloads");
                number_of_replica_downloads.setValue(String.valueOf(rs.getLong("number_of_replica_downloads")));     
                rowsArray.add(number_of_replica_downloads);
                
                Field month = new Field();
                month.setName("month");
                month.setValue(String.valueOf(rs.getLong("month")));     
                rowsArray.add(month);
                
                Field year = new Field();
                year.setName("year");
                year.setValue(String.valueOf(rs.getInt("year")));     
                rowsArray.add(year);
                
                Field host_name = new Field();
                host_name.setName("host_name");
                host_name.setValue(String.valueOf(rs.getString("host_name")));     
                rowsArray.add(host_name);
                
                Field dataset_name = new Field();
                dataset_name.setName("dataset_name");
                dataset_name.setValue(String.valueOf(rs.getString("dataset_name")));     
                rowsArray.add(dataset_name);
                
                Field dataset_version = new Field();
                dataset_version.setName("dataset_version");
                dataset_version.setValue(String.valueOf(rs.getInt("dataset_version")));     
                rowsArray.add(dataset_version);
                
                Field datetime_start = new Field();
                datetime_start.setName("datetime_start");
                datetime_start.setValue(String.valueOf(rs.getString("datetime_start")));     
                rowsArray.add(datetime_start);
                
                Field datetime_stop = new Field();
                datetime_stop.setName("datetime_stop");
                datetime_stop.setValue(String.valueOf(rs.getString("datetime_stop")));     
                rowsArray.add(datetime_stop);
                              
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
	    listOfRows.setName("cmip5_dmart_dataset_host_time");

	    return listOfRows;
	}
}
