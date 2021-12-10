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
			System.out.println("MemberDAO insert()에서 문제발생!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean select(MemberVO vo) {
		// 로그인 성공여부를 반환하는 메서드
		conn=JNDI.getConnection();
		try {
			pstmt=conn.prepareStatement(sql_select);
			pstmt.setString(1, vo.getMid());
			rs=pstmt.executeQuery();
			if(rs.next()){
				System.out.println("해당하는 id 존재");
				if(rs.getString("mpw").equals(vo.getMpw())) {
					System.out.println("pw 일치");
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO selectOne()에서 문제발생!");
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
