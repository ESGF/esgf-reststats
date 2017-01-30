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

@Path("/cross-project/coarse-stats")
public class CoarseStatsController {
	
	@Path("/xml")
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public Table<Row> getXml() throws SQLException {
		
	    List<Row> rowList = new ArrayList<Row>();
	    Connection conn = null;
	    
        try {
            conn = Constants.DATASOURCE.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_COARSE_STATS.getSql());
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
                
                Field number_of_distinct_file = new Field();
                number_of_distinct_file.setName("number_of_distinct_file");
                number_of_distinct_file.setValue(String.valueOf(rs.getLong("number_of_distinct_file")));
                rowsArray.add(number_of_distinct_file);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("number_of_users")));     
                rowsArray.add(number_of_users);
                
                Field eu_stats = new Field();
                eu_stats.setName("eu");
                eu_stats.setValue(String.valueOf(rs.getBoolean("eu")));     
                rowsArray.add(eu_stats);
                
                Field month = new Field();
                month.setName("month");
                month.setValue(String.valueOf(rs.getLong("month")));     
                rowsArray.add(month);
                
                Field year = new Field();
                year.setName("year");
                year.setValue(String.valueOf(rs.getInt("year")));     
                rowsArray.add(year);
                
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
	    listOfRows.setName("cross_dmart_isenes_stats");

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
            PreparedStatement stmt = conn.prepareStatement(SqlQuery.CROSS_DMART_COARSE_STATS.getSql());
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
                
                Field number_of_distinct_file = new Field();
                number_of_distinct_file.setName("number_of_distinct_file");
                number_of_distinct_file.setValue(String.valueOf(rs.getLong("number_of_distinct_file")));
                rowsArray.add(number_of_distinct_file);
                
                Field number_of_users = new Field();
                number_of_users.setName("number_of_users");
                number_of_users.setValue(String.valueOf(rs.getInt("number_of_users")));     
                rowsArray.add(number_of_users);
                
                Field eu_stats = new Field();
                eu_stats.setName("eu");
                eu_stats.setValue(String.valueOf(rs.getBoolean("eu")));     
                rowsArray.add(eu_stats);
                
                Field month = new Field();
                month.setName("month");
                month.setValue(String.valueOf(rs.getLong("month")));     
                rowsArray.add(month);
                
                Field year = new Field();
                year.setName("year");
                year.setValue(String.valueOf(rs.getInt("year")));     
                rowsArray.add(year);
                
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
	    listOfRows.setName("cross_dmart_isenes_stats");

	    return listOfRows;
	}

}
