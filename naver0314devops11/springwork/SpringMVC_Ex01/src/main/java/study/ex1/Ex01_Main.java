package study.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ �ڹ� ������� ȣ�� #1");
		MessageInter m = null;
		
		m=new Message1();
		String s=m.sayHello("�̿���");
		System.out.println(s);
		
		m=new Message2();
		s=m.sayHello("��ȣ��");
		System.out.println(s);
		
		System.out.println("\n������ ������� ȣ�� #1");
		ApplicationContext context = new ClassPathXmlApplicationContext("appex1.xml");
		MessageInter mi = (Message1)context.getBean("mes1");//��ȯŸ���� ������Ʈ�� ����ȯ �ؾ���
		s=mi.sayHello("ĵ��");
		System.out.println(s);
		
		mi=context.getBean("mes2", Message2.class);
		s=mi.sayHello("����ũ");
		System.out.println(s);
	}

}