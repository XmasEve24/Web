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
		System.out.println("������������1");
	}
	
	/*public IPhone(Watch watch, String uname) {
		System.out.println("������������2");
		this.watch=watch;
		this.uname=uname;
		System.out.println("uname�� " + this.uname + "�Դϴ�" );
	}*/
	
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	public void msg() {
		System.out.println("������ ���ں�����");
	}
	/*public void initMethod() {
		System.out.println("�������� �ʱ�ȭ�Ҷ� ó���� �۾��� ���� �޼���");
	}
	public void destroyMethod() {
		System.out.println("������ ��ü �����ɶ� ó���� �۾��� ��ų��� �޼���");
	}*/
	
}
