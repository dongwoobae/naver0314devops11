package study.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex03_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appex3.xml");

		MyCart mC = (MyCart)context.getBean("cart");

//		mC.show();

		MyCart mC2 = (MyCart)context.getBean("cart");

//		mC2.show();
		
		System.out.println("singleton �� ���� ������ �����ص� �ּҰ� ����");
		System.out.println("prototype�� ��쿡�� ���� �����Ҷ����� ���ο� �ּҿ� �����ȴ�");
		
		System.out.println(mC.hashCode());
		System.out.println(mC2.hashCode());
		//scope="singleton" �϶��� �ּҰ� ����
		//scope="prototype" �϶��� �ּҰ� �ٸ�
	}

}
