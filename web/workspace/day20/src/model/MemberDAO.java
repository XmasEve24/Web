package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insert="insert into member values(?,?,?)";
	String sql_select="select * from member";
	
	public boolean insert(MemberVO vo) {
		conn=JNDI.getConnection();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDAO insert()���� �����߻�!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean select(MemberVO vo) {
		// �α��� �������θ� ��ȯ�ϴ� �޼���
		conn=JNDI.getConnection();
		try {
			pstmt=conn.prepareStatement(sql_select);
			pstmt.setString(1, vo.getMid());
			rs=pstmt.executeQuery();
			if(rs.next()){
				System.out.println("�ش��ϴ� id ����");
				if(rs.getString("mpw").equals(vo.getMpw())) {
					System.out.println("pw ��ġ");
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO selectOne()���� �����߻�!");
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
