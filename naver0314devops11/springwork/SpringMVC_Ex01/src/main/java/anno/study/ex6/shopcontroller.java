package anno.study.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Component("shopcont")
//@RequiredArgsConstructor// AllArgsConstructor �� ���� �ٸ� ������ �߰��� �� error��.
public class shopcontroller {
	//@NonNull
	@Autowired//autowired�ε� ����.
	ShopDao dao;
	//ShopDao dao = new ShopDao();//���⼭ new ShopDao�� �����ϴ� ���ε� ShopDao dao; ������� 
	//�������� �ʾƼ� AllargsConstructor�� ������ �ؾ���.
	
	public void insert(String sang, int su, int dan) {
		ShopDto dto = new ShopDto(sang,su,dan);
		dao.insert(dto);
	}
	
	public void delete(String sang) {
		dao.delete(sang);
	}
	
	public void update(String sang, int su, int dan) {
		ShopDto dto= new ShopDto();	
		dto.setSang(sang);
		dto.setDan(dan);
		dto.setSu(su);
		
		dao.update(dto);
		dao.selectAll();
	}
	
	
}
