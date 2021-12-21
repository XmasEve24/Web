package test;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//@Component("iPhone") // == <bean class="" id="">��ϰ� ���� ����!!!  
// IPhone iPhone = new IPhone(); => �⺻�����ڰ� �����ؾ���!!!
public class IPhone implements Phone{
	@Resource(name="appleWatch")
	private Watch watch; // -> IoC�� ������ �ڵ�!
	
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
