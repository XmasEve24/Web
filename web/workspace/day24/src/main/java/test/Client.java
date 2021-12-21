package test;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		/*BeanFactory factory = new BeanFactory();
		Phone phone = (Phone)factory.getBean(args[0]);
		phone.volumeUp();
		phone.msg();*/
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone = (Phone)factory.getBean("phone");
		phone.volumeDown();
		phone.volumeUp();
		phone.msg();
		
		/*Phone p1=(Phone)factory.getBean("galaxyPhone");
		Phone p2=(Phone)factory.getBean("galaxyPhone");
		Phone p3=(Phone)factory.getBean("galaxyPhone");*/
		
		
		
		
		factory.close();
	}
}
// 코드의 핵심-1
// 결합도 낮추기!

