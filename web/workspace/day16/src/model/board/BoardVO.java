package model.board;

public class BoardVO {

	private int bid;
	private String mid;
	private String msg;
	private int favcnt;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getFavcnt() {
		return favcnt;
	}
	public void setFavcnt(int favcnt) {
		this.favcnt = favcnt;
	}
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", mid=" + mid + ", msg=" + msg + ", favcnt=" + favcnt + "]";
	}
	
	
}
