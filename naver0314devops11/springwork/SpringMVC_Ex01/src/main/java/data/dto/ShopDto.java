package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //default ������
@AllArgsConstructor //��� ��� ������ ���ڷ� �޴� ������
//@Setter
//@Getter
//@ToString
@Data //setter + getter + toString ��ģ��
public class ShopDto {
	private String sangpoom;
	private String photo;
	private int price;
	private int su;
	
}
