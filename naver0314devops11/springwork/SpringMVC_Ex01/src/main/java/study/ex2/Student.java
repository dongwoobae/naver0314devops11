package study.ex2;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor// final�̳� nonnull ���� �ֵ鸸
@Setter
public class Student {
	private String schoolName;
	//��� ���� �� �޴� �����ڰ� �ƴ϶� ���� �ʿ��� ������ �޴� �����ڸ� �����Ϸ���
	//final�� ���̰ų� NonNull�� ���̰� RequiredArgsConstructor�� �����ϸ� �ȴ�.
	@NonNull
	MyInfo myInfo;
	
//	public Student(MyInfo info) {
//		myInfo=info;
//	}
//	
//	public void setSchoolName(String schoolName) {
//		this.schoolName = schoolName;
//	}
//	
	public void show() {
		System.out.println(myInfo);//toString ȣ��
		System.out.println("�б���: "+schoolName);
	}
}
