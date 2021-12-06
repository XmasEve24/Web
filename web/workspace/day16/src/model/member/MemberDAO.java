package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.board.BoardVO;
import model.common.JDBCUtil;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql_selectAll = "select * from board";
	String sql_selectOne = "select * from board where = bid?";
	String sql_insert = "insert into board values((select nvl(max(idx),0)+1 from board),?,?,?)";
	String sql_update = "delete from board where idx=?";
	String sql_delete = "update board set title=?, uname=?, content where idx=?";
	
	public ArrayList<BoardVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		try {
			ResultSet rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(sql_selectAll);
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	public BoardVO selectOne(BoardVO vo) {
		conn = JDBCUtil.connect();
		BoardVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	public boolean insert(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean update(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean delete(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
