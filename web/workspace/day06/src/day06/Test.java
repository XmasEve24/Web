package day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Test {

	public static void main(String[] args) {

		String oracleD = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ko";
		String password = "1520";
		
		System.out.print("찾고싶은 이름입력 : ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		String sql = "select * from test where b like '%" + num + "%'";
		/*
		 * 1. JDBC 드라이버를 JVM에 로드 
		 * 2. DB에 연결 
		 * 3. DBMS에 데이터를 read, write == SQL문을 수행 
		 * 4. DB연결 해제
		 */
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(oracleD); // 1. JDBC 드라이버를 JVM에 로드
//			System.out.println("JDBC 드라이버 로드 성공!");

			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("오라클에 연결 성공!");

			stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 이터레이터와 유사한 rs
			// 컬렉션들을 복사해서 이터레이터로 가져와 사용
			int cnt=0;
			while(rs.next()) {
				System.out.println(rs.getInt("a") + " : " + rs.getString("b"));
				cnt++;
			}
			if(cnt==0) {
				System.out.println("없는 데이터입니다.");
			}
			rs.close(); // statement가 
			
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
