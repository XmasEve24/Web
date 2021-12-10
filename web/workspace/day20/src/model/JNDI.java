package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDI {
	
	PreparedStatement pstmt = null;
	
	public static Connection getConnection() {
		Connection conn = null;
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/orcl");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("JNDIŬ�������� ���ܹ߻�");
			e.printStackTrace();
		}
		return conn;
	}
}
