package org.esg.node.rest.historical;

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

@Path("/historical-stats-by-continent/all-projects")
public class AllDataUsageContinentController {
	
	@Path("/xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public Table<Row> getXml() throws SQLException {
		
	    List<Row> rowList = new ArrayList<Row>();
	    Connection conn = null;
	    
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.ALL_DATA_USAGE_CONTINENT.getSql());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	
            	Row row = new Row();
                ArrayList<Field> rowsArray = new ArrayList<Field>();
                
                Field total_size = new Field();
                total_size.setName("total_size");
                total_size.setValue(String.valueOf(rs.getLong("gb")));
                rowsArray.add(total_size);
                
                Field number_of_downloads = new Field();
                number_of_downloads.setName("number_of_downloads");
                number_of_downloads.setValue(String.valueOf(rs.getLong("downloads")));
                rowsArray.add(number_of_downloads);
                
                Field number_of_distinct_file = new Field();
                number_of_distinct_file.setName("number_of_distinct_file");
                number_of_distinct_file.setValue(String.valueOf(rs.getLong("files")));
                rowsArray.add(number_of_distinct_file);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("users")));     
                rowsArray.add(number_of_users);
                
                Field month = new Field();
                month.setName("month");
                month.setValue(String.valueOf(rs.getLong("month")));     
                rowsArray.add(month);
                
                Field year = new Field();
                year.setName("year");
                year.setValue(String.valueOf(rs.getInt("year")));     
                rowsArray.add(year);
                
                Field continent_name = new Field();
                continent_name.setName("continent_name");
                continent_name.setValue(String.valueOf(rs.getString("continent")));     
                rowsArray.add(continent_name);
                
                Field host_name = new Field();
                host_name.setName("host_name");
                host_name.setValue(String.valueOf(rs.getString("host")));     
                rowsArray.add(host_name);
                
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
	    listOfRows.setName("all_data_usage_continent");

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
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.ALL_DATA_USAGE_CONTINENT.getSql());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	
            	Row row = new Row();
                ArrayList<Field> rowsArray = new ArrayList<Field>();
                
                Field total_size = new Field();
                total_size.setName("total_size");
                total_size.setValue(String.valueOf(rs.getLong("gb")));
                rowsArray.add(total_size);
                
                Field number_of_downloads = new Field();
                number_of_downloads.setName("number_of_downloads");
                number_of_downloads.setValue(String.valueOf(rs.getLong("downloads")));
                rowsArray.add(number_of_downloads);
                
                Field number_of_distinct_file = new Field();
                number_of_distinct_file.setName("number_of_distinct_file");
                number_of_distinct_file.setValue(String.valueOf(rs.getLong("files")));
                rowsArray.add(number_of_distinct_file);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("users")));     
                rowsArray.add(number_of_users);
                
                Field month = new Field();
                month.setName("month");
                month.setValue(String.valueOf(rs.getLong("month")));     
                rowsArray.add(month);
                
                Field year = new Field();
                year.setName("year");
                year.setValue(String.valueOf(rs.getInt("year")));     
                rowsArray.add(year);
                
                Field continent_name = new Field();
                continent_name.setName("continent_name");
                continent_name.setValue(String.valueOf(rs.getString("continent")));     
                rowsArray.add(continent_name);
                
                Field host_name = new Field();
                host_name.setName("host_name");
                host_name.setValue(String.valueOf(rs.getString("host")));     
                rowsArray.add(host_name);
                
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
	    listOfRows.setName("all_data_usage_continent");

	    return listOfRows;
	}

}
