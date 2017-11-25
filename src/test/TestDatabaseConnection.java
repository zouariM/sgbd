package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDatabaseConnection {

	public  static void test(String databaseName){
		try{
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,"root","");
			System.out.println("connection to database <"+databaseName+"> estableshed");
		}catch(Exception e){
			System.out.println("unable to connect to database <"+databaseName+">");
		}
	}
	
	public static void main(String[] args) {
		
		test("testdatabase");
	}

}
