package study.ex3;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Person {
	@NonNull
	private String name;
	private String phone;
	
//	//������ ����
//	public Person(String name) {
//		this.name=name;
//	}
//	
//	//setter ����
//	public void setPhone(String phone) {
//		this.phone=phone;
//	}
//	
//	//getter
//	public String getName() {
//		return name;
//	}
//	public String getPhone() {
//		return phone;
//	}
}
