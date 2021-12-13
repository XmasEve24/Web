package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Bank1 {
	private int bid;
	private String name;
	private int balance;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Bank1 [bid=" + bid + ", name=" + name + ", balance=" + balance + "]";
	}
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public void connect() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/orcl");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean transfer(int balance) {
		connect();
		try {
			conn.setAutoCommit(false); // 자동커밋모드를 해제
			
			// 58~64번라인까지 하나의 작업단위
			pstmt=conn.prepareStatement("update bank1 set balance=balance-? where bid=11");
			pstmt.setInt(1, balance);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("update bank2 set balance=balance+? where bid=21");
			pstmt.setInt(1, balance);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("select * from bank1 where bid=11");
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			if(rs.getInt("balance")<0) {
				conn.rollback();
				return false;
			}
			conn.commit();
			
			conn.setAutoCommit(true); // 자동커밋모드 원상복구
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void select() {
		connect();
		try {
			pstmt=conn.prepareStatement("select * from bank1");
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			bid=rs.getInt("bid");
			name=rs.getString("name");
			balance=rs.getInt("balance");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
