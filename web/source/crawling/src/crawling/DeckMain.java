package crawling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import crawling.DeckVO;


public class DeckMain {

	public void insert(DeckVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql_insert="insert into lol values(?,?,?)";
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getDeck());
			pstmt.setString(2, vo.getChamp());
			pstmt.setString(3, vo.getGold());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
	}
	
}
