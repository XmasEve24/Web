package day06;

public class Test {

	public static void main(String[] args) {
		
		/*
		1. JDBC ����̹��� JVM�� �ε�
		2. DB�� ����
		3. DBMS�� �����͸� read, write == SQL���� ����
		4. DB���� ����		 
		*/
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
