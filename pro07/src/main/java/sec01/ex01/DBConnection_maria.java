package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection_maria{ 	
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver"; 	
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/park";  
	private static final String DB_USERNAME = "root"; 	
	private static final String DB_PASSWORD = "1234";   	
	private static Connection conn; 	
		PreparedStatement pstmt = null;   	
	
	private static void connectDB() {   		
		try { 			Class.forName(DB_DRIVER_CLASS); 			
		conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD); 			
		System.out.println("���Ἲ��1");   		}
		
			catch (ClassNotFoundException e) { 			
				System.out.println("����̺� �ε� ����"); 		} 
		
		catch (SQLException e) { 			
			System.out.println("DB ���� ����"); 		} 	} 
	
	public static void main(String[] args) { 		
		DBConnection_maria test = new DBConnection_maria(); 		
		test.connectDB(); 	
	} 
	
	}
		

