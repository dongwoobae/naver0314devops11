package study.ex3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class MyCart {
	Person person;
	@NonNull
	private String sangpum;	
	@NonNull
	private int price;
	
//	public MyCart(String sangpum, int price) {
//		// TODO Auto-generated constructor stub
//		this.sangpum=sangpum;
//		this.price=price;
//	}
//	
//	public void setPerson(Person person) {
//		this.person=person;
//	}
	
	public void show() {
		System.out.println("������ ��� �̸�: "+person.getName()+"\n�ڵ�����ȣ: "+person.getPhone());
		System.out.println("��ǰ��: "+sangpum);
		System.out.println("��ǰ ����: "+price);
	}
}
