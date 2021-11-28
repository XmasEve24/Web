package crawling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeckDAO {

	public static void main(String[] args) {
		ArrayList<DeckVO> dl = new ArrayList<DeckVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql_selectAll = "select * from lol";
		String sql_insert = "insert into lol values(?,?,?)";

		conn = JDBCUtil.connect();

		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			ResultSet rs=pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql_insert);
			for(int i=0; i<dl.size(); i++) {
				pstmt.setString(1, );
			}
			while (rs.next()) {
				System.out.println("ÃßÃµµ¦: " + rs.getString("deck") + "\nµ¦±¸¼º Ã¨ÇÇ¾ð: " + rs.getString("champ") + "\nÇÊ¿ä °ñµå: "
						+ rs.getInt("gold") + "\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}

	}

}
