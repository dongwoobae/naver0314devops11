package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import lombok.Getter;

@Component
@Getter
public class Sawon {
	@Value("������")
	private String name;
	@Value("����� ���ı�")
	private String addr;
	@Value("34")
	private int age;
}
