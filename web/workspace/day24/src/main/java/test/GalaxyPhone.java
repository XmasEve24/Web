package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("phone") // 설정변화가 적은 경우
public class GalaxyPhone implements Phone{
	@Autowired
	private Watch watch; // 설정의 변화가 자주 발생할예정
	
	public GalaxyPhone() {
		System.out.println("갤럭시 생성자");
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
		System.out.println("갤럭시 문자보내기");
	}
}
