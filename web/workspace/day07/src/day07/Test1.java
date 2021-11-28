package day07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="ko";
		String password="1520";
		
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		String sqlD="insert into lol values(" +num1 + "," + 
		String sqlS="select * from test";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);   // 1
			
			conn = DriverManager.getConnection(url,user,password); // 2
			stmt = conn.createStatement(); // 3
			
			int ex = stmt.executeUpdate(sqlD);
			System.out.println(ex+"개 데이터 삭제됨!");

			ResultSet rs = stmt.executeQuery(sqlS);
			while(rs.next()) {
				System.out.println(rs.getInt("a") + " : " + rs.getString("b"));
			}
			// select
			// insert, update, delete
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
