package com.bitcamp.study;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.dto.ShopDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		ShopDto dto1= new ShopDto();
//		dto1.setSangpoom("�Ӹ���");
//		dto1.setPhoto("shop/30.jpg");
//		dto1.setPrice(13000);
//		dto1.setSu(3);
//		
//		ShopDto dto2 = new ShopDto("�Ӹ���","shop/26.jpg",9000,5);
//		
//		model.addAttribute("dto1",dto1);
//		model.addAttribute("dto2",dto2);
//		
////		System.out.println(dto1.toString());//���� �Ʒ��� ���� ��
////		System.out.println(dto2);//toString ��������
//		
//		model.addAttribute("msg","Hello SpringFramework!");
//		model.addAttribute("today",new Date());
//		return "home";//������
//	}
	
	//RequestMapping �� method get, post ����������Ѵ�.
	//@GetMapping, @PostMapping �� ���������� 5���� �߰���
	@GetMapping("/")//mapping�� �޼ҵ� ���� ���� �� �־ �� ���Ͼȿ� ���� ������ �޼ҵ带 ���� �� ����
	public String startSpringWeb(Model model) {
			
		
		return "start";
	}
	
	@GetMapping("/board/list")//list.do�� list�� ȣ��� 
	//(/board/list.do)�� �������� ��쿡�� /board/list �� ã�� �� ������ ��
	public String Hello(Model model) {
		//���� parameter�� �ް� return�� �ش� jsp �̸�����
		model.addAttribute("msg","�ȳ��ϼ���");
		//addAttribute�� �� �־���
		return "result1";
	}
	
	@GetMapping("/guest/list")
	public ModelAndView Hello2() {
		//Ŭ���� ��ü�� ���̰� setViewName���� jsp ���� �̸��� ����
		ModelAndView mv=new ModelAndView();
		mv.addObject("today",new Date());
		//addObject �Լ��� �� �־���
		mv.setViewName("result2");
		return mv;
	}
}
