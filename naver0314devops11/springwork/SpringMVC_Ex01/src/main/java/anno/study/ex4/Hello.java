package anno.study.ex4;

import org.springframework.stereotype.Component;

import lombok.Data;


//@Component //xml�� �ڵ� ���, �� ��� Ŭ�����̸��� �� ���̵� �ȴ�.
@Component("h")// ���̵� h�� ���
@Data
public class Hello {
	private int num;
	private String name;
	
	public void showMessage() {
		System.out.println("Hello Class�� ���� �޼ҵ��Դϴ�");
	}
	
	
}
