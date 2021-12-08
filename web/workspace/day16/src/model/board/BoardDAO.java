package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql_insert = ""; // �α��ο� ������ ��쿡�� C(insert) ����
	String sql_update = "update board set favcnt=favcnt+1 where bid=?"; // ���ƿ�+1
	String sql_delete = ""; // �ش� �Խñ��� �ۼ��ڸ��� ��������
	String sql_selectAll = "select * from board order by bid desc"; // "������": pagination(���������̼�)
	   //oracle���� limit����ϴ� sql��
	String sql_insertR = "insert into reply values((select nvl(max(bid),0)+1 from board),?,?,?)";
	String sql_deleteR = "delete from reply where rid=?";
	
	public ArrayList<BoardSet> selectAll(int mcnt) { // ��� ���� �����ִ����� ���� ������ �޾ƿ�
		ArrayList<BoardSet> datas = new ArrayList<BoardSet>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
//			pstmt.setInt(1, mcnt);
			System.out.println("mcnt: " +mcnt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardSet bs = new BoardSet();
				BoardVO b = new BoardVO();
				ArrayList<ReplyVO> rdatas = new ArrayList<ReplyVO>();

				b.setBid(rs.getInt("bid"));
				b.setFavcnt(rs.getInt("favcnt"));
				b.setMid(rs.getString("mid"));
				b.setMsg(rs.getString("msg"));

				String sql = "select * from reply where bid=? order by rid desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, b.getBid()); // rs.getInt("bid")
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {
					ReplyVO r = new ReplyVO();
					r.setBid(rs2.getInt("bid"));
					r.setMid(rs2.getString("mid"));
					r.setRid(rs2.getInt("rid"));
					r.setRmsg(rs2.getString("rmsg"));
					rdatas.add(r);
				}
				b.setRcnt(rdatas.size()); // �Խñۿ� ���� ����� ����

				bs.setBoard(b);
				bs.setRdatas(rdatas);
				datas.add(bs);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO selectAll()���� �����߻�!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	public boolean update(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO update()���� �����߻�!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean insertR(ReplyVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insertR);
			pstmt.setInt(1, vo.getRid());
			pstmt.setInt(2, vo.getBid());
			pstmt.setString(3, vo.getMid());
			pstmt.setString(4, vo.getRmsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO insertR()���� �����߻�!");
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	public boolean deleteR(ReplyVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_deleteR);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO deleteR()���� �����߻�!");
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
