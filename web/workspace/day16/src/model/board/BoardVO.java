package model.board;

public class BoardVO {
	private int bid;
	private String mid;
	private String msg;
	private int favcnt;
	private int rcnt; // ���̺� Į�����δ� ��������������, ���������� �ʿ��� �Ӽ�!
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
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	@Override
	public String toString() {
		return "BoardVOȮ�� [bid=" + bid + ", mid=" + mid + ", msg=" + msg + ", favcnt=" + favcnt + ", rcnt=" + rcnt + "]";
	}
}
