package model.board;

import java.util.ArrayList;

public class BoardSet {
	// BoardVO 1���� 
	// ReplyVO N���� �Բ� �پ��ִ� ������ "�Խñ�"�����͸� ǥ���ϴ� Ŭ����
	private BoardVO board;
	private ArrayList<ReplyVO> rdatas = new ArrayList<ReplyVO>();
	
	public BoardVO getBoard() {
		return board;
	}
	public void setBoard(BoardVO board) {
		this.board = board;
	}
	public ArrayList<ReplyVO> getRdatas() {
		return rdatas;
	}
	public void setRdatas(ArrayList<ReplyVO> rdatas) {
		this.rdatas = rdatas;
	}
	@Override
	public String toString() {
		return "BoardSetȮ�� [board=" + board + ", rdatas=" + rdatas + "]";
	}
	
	
}
