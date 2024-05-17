package anno.study.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex06_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appex6.xml");
		
		shopcontroller scl = (shopcontroller)context.getBean("shopcont");
		scl.insert("�Ƹ޸�ī��", 5, 1500);
		System.out.println("-".repeat(30));
		scl.delete("�Ƹ޸�ī��");
		System.out.println("-".repeat(30));
		scl.update("����", 1, 120000);
	}

}
