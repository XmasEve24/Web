package test;

public class GalaxyPhone implements Phone{
	public GalaxyPhone() {
		System.out.println("������ ������");
	}
	@Override
	public void volumeUp() {
		System.out.println("������ �Ҹ�++");
	}
	@Override
	public void volumeDown() {
		System.out.println("������ �Ҹ�--");
	}
	@Override
	public void msg() {
		System.out.println("������ ���ں�����");
	}
}
