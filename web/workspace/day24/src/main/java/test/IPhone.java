package test;

public class IPhone implements Phone{
	private Watch watch;
	private String uname;
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public IPhone() {
		System.out.println("아이폰생성자1");
	}
	
	/*public IPhone(Watch watch, String uname) {
		System.out.println("아이폰생성자2");
		this.watch=watch;
		this.uname=uname;
		System.out.println("uname은 " + this.uname + "입니다" );
	}*/
	
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	public void msg() {
		System.out.println("아이폰 문자보내기");
	}
	/*public void initMethod() {
		System.out.println("아이폰을 초기화할때 처리할 작업이 들어가는 메서드");
	}
	public void destroyMethod() {
		System.out.println("아이폰 객체 삭제될때 처리할 작업이 들거나는 메서드");
	}*/
	
}
