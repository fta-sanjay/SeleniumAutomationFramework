package com.fta.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.fta.dbconnection.DBtoJSON;

public class DBOperations {
	
	private DBOperations() {};
	Connection connection=null;
	ResultSet resultset=null;
	Statement statement;
	
	@Test
	public void deleteAllDbData()
	{
		DBtoJSON dbtojson=new DBtoJSON();
	    connection=dbtojson.connectToDB();
		try {
			statement = connection.createStatement();
	        int rowsDeleted = statement.executeUpdate("DELETE FROM myzone.customer;");
	        System.out.println(rowsDeleted + " row(s) deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getDataFromDB()
	{
		DBtoJSON dbtojson=new DBtoJSON();
	    connection=dbtojson.connectToDB();
		try {
			statement = connection.createStatement();
			resultset= statement.executeQuery("select * from myzone.customer;");
			while(resultset.next())
			{
				System.out.println(resultset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
