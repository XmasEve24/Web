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
	
	String sql_selectAll = "select * from board order by idx desc";
	String sql_selectOne = "select * from board where inx=?";
	String sql_insert = "insert into board values((select nvl(max(idx),0)+1 from board),?,?,?)";
	String sql_delete = "delete from board where idx=?";
	String sql_update = "update board set title=?, uname=?, content where idx=?";
	
	public ArrayList<BoardVO> selectAll() {
		conn = JDBCUtil.connect();
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setUname(rs.getString("uname"));
				datas.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("selectALl에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	public BoardVO selectOne(BoardVO vo) { // 인자를 VO객체로 만듦으로써 유지보수가 용이해졌다!
		conn = JDBCUtil.connect();
		BoardVO data = null;
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getIdx());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setIdx(rs.getInt("idx"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setUname(rs.getString("uname"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("selectOne에서 문제발생!");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insert(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getUname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert에서 문제발생!");
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
			pstmt.setString(1, vo.getUname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update에서 문제발생!");
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
			pstmt.setInt(1, vo.getIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete에서 문제발생!");
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
			
}
