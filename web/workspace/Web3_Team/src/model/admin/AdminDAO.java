package model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class AdminDAO {
	
	// �����ڰ� �ʿ��� �޼���� �α���, �� select �ϳ�����. 
	// �����ڰ� ȸ�������� �� ���� �����ϱ�. 
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	JNDI JNDIUtil = new JNDI();
	
	String sql_selectOne="select * from admin where adminId=?";

	public boolean adminLogin(AdminVO vo) {
		conn=JNDIUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getAdminId());
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				vo.setAdminEmail(rs.getString("adminEmail"));
				vo.setAdminName(rs.getString("adminName"));
				vo.setAdminId(rs.getString("adminId"));
					
				if(rs.getString("adminPw").equals(vo.getAdminPw())) {
					vo.setAdminPw(rs.getString("adminPw"));
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("AdminDAO adminLogin() error");
			e.printStackTrace();
			return false;
		} 
		
		return false;	
	}
	
}
