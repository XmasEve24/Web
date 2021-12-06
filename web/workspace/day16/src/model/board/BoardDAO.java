package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
	String sql_selectAll = "select * from board order by bid desc limit 0,?"; // "더보기" : pagination(페이지네이션)
	String sql_selectOne = "select * from board where = bid?";
	String sql_insert = "insert into board values((select nvl(max(idx),0)+1 from board),?,?,?)";
	String sql_update = "delete from board where idx=?";
	String sql_delete = "update board set title=?, uname=?, content where idx=?";
	
	public ArrayList<BoardSet> selectAll(int mcnt) { // 몇개의 글을 볼수있는지에 대한 정보를 받아옴
		ArrayList<BoardSet> datas = new ArrayList<BoardSet>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setInt(1, mcnt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardSet bs = new BoardSet();
				BoardVO b= new BoardVO();
				ArrayList<ReplyVO> rdatas = new ArrayList<ReplyVO>();
				
				b.setBid(rs.getInt("bid"));
				b.setFavcnt(rs.getInt("favcnt"));
				b.setMid(rs.getString("mid"));
				b.setMsg(rs.getString("msg"));
				
				String sql="select * from reply where bid=? order by rid desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, b.getBid()); // rs.getInt("bid")
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next()) {
					ReplyVO r = new ReplyVO();
					r.setBid(rs2.getInt("bid"));
					r.setMid(rs2.getString("mid"));
					r.setRid(rs2.getInt("rid"));
					r.setRmsg(rs2.getString("rmsg"));
				}
				
				bs.setBoard(b);
				bs.setRdatas(rdatas);
				datas.add(bs);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO selectAll()에서 문제발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
}
