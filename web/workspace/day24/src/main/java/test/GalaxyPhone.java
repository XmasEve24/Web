package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("phone") // ������ȭ�� ���� ���
public class GalaxyPhone implements Phone{
	@Autowired
	private Watch watch; // ������ ��ȭ�� ���� �߻��ҿ���
	
	public GalaxyPhone() {
		System.out.println("������ ������");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	@Override
	public void msg() {
		System.out.println("������ ���ں�����");
	}
}
