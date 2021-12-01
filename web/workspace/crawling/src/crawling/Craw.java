package crawling;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Craw {

	public static void main(String[] args) {
		ArrayList<DeckVO> dl = new ArrayList<DeckVO>();
		String url = "https://lolchess.gg/meta";
		// Å©·Ñ¸µ´ë»ó urlÁöÁ¤
		Document doc = null;
		Elements tmp;
		String deck_temp = null;
		String champ_temp = null;
		String gold_temp = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements ele = doc.select("div.guide-meta__deck-box");

		for (int i = 0; i < 15; i++) {
			tmp = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.name.mr-3");
			deck_temp = tmp.get(i).text();
			for(int j=0; j< deck_temp.length(); j++) {
				if(deck_temp.charAt(j)=='U' && deck_temp.charAt(j+1)=='P') {
					int idx_U = deck_temp.indexOf("U");
					deck_temp = deck_temp.substring(0,idx_U);
				}else if(deck_temp.charAt(j)=='N' && deck_temp.charAt(j+1)=='E') {
					int idx_N = deck_temp.indexOf("N");
					deck_temp = deck_temp.substring(0,idx_N);
				}
			}
			
			tmp = ele.select("div.guide-meta__deck__column.champions.mr-2");
			champ_temp = tmp.get(i).text();
			System.out.println(champ_temp);
			tmp = ele.select("div.guide-meta__deck > div.guide-meta__deck__column.cost.mr-2");
			gold_temp = tmp.get(i).text();
//			dl.add(new DeckVO(deck_temp, champ_temp, gold_temp));
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
//		String sql_insert = "insert into lol values(?,?,?)";
//		conn = JDBCUtil.connect();
//
//		try {
//			for(DeckVO vo : dl) {
//			pstmt = conn.prepareStatement(sql_insert);
//			pstmt.setString(1, vo.getDeck());
//			pstmt.setString(2, vo.getChamp());
//			pstmt.setString(3, vo.getGold());
//			pstmt.executeUpdate();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//		
//		conn = JDBCUtil.connect();
//		String sql_selectAll = "select * from lol";
//		try {
//			pstmt = conn.prepareStatement(sql_selectAll);
//			ResultSet rs=pstmt.executeQuery();
//			while(rs.next()) {
//				System.out.println("ÃßÃµµ¦: " + rs.getString("deck") + "\nµ¦±¸¼º Ã¨ÇÇ¾ð: " + rs.getString("champ") + "\nÇÊ¿ä °ñµå: " + rs.getString("gold") + "\n"  );
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
	}

}
