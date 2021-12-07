package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insert="insert into member values(?,?,?)";
	String sql_selectOne="select * from member where mid=?";
	
	public boolean insert(MemberVO vo) {
		conn=JDBCUtil.connect();
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
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean selectOne(MemberVO vo) {
		// �α��� �������θ� ��ȯ�ϴ� �޼���
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
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
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return false;
	}
}
