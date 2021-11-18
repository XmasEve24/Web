package day03;

public class Calc {
	
	private int res;
	public int getRes() {
		return res;
	}
	
	
	public Calc(int num1,int num2,String op) {
		if(op.equals("+")) {
			res=num1+num2;
		}
		else {
			res=num1-num2;
		}
	}

}
