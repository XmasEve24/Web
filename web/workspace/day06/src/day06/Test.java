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
		
		System.out.print("ã����� �̸��Է� : ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		String sql = "select * from test where b like '%" + num + "%'";
		/*
		 * 1. JDBC ����̹��� JVM�� �ε� 
		 * 2. DB�� ���� 
		 * 3. DBMS�� �����͸� read, write == SQL���� ���� 
		 * 4. DB���� ����
		 */
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(oracleD); // 1. JDBC ����̹��� JVM�� �ε�
//			System.out.println("JDBC ����̹� �ε� ����!");

			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("����Ŭ�� ���� ����!");

			stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// ���ͷ����Ϳ� ������ rs
			// �÷��ǵ��� �����ؼ� ���ͷ����ͷ� ������ ���
			int cnt=0;
			while(rs.next()) {
				System.out.println(rs.getInt("a") + " : " + rs.getString("b"));
				cnt++;
			}
			if(cnt==0) {
				System.out.println("���� �������Դϴ�.");
			}
			rs.close(); // statement�� 
			
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
