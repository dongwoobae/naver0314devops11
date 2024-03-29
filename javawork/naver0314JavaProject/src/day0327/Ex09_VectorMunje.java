package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 * 1. 학생정보 추가 이름,나이,3과목 점수 입력
 * 2. 학생정보삭제 : 이름으로 찾아서 삭제(없을경우 메세지 출력)
 * 3. 전체 정보 출력: 번호, 이름, Java,Spring,HTML, 총점, 평균, 등급 출력
 * 4. 평균값으로 검색 (평균 값을 입력하면 그 평균값 이상의 학생들을 출력)
 * 5. 이름으로 검색 (입력한 글자 포함시 출력) (contains)
 * 6. 저장 후 종료
 */


public class Ex09_VectorMunje {

	static final String FILENAME = "c:/naver03/student.txt";
	Scanner sc = new Scanner(System.in);
	List<StudentDto> list = new Vector<StudentDto>();
	public int getMenu()
	{
		int menu =0;
		System.out.println("=".repeat(55));
		System.out.println("1.학생정보 추가 2.학생정보삭제 3.전체 정보 출력 \n4.평균값으로 검색 "
				+ "5.이름으로 검색 6.저장 후 종료");
		System.out.println("=".repeat(55));
		//try catch문 써서 문자가 입력되면 무조건 전체 출력
		try {
		menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			//만약 문자가 입력되면 전체출력을 하는걸로 해보자
			menu = 3;
		}
		return menu;
		
	}
	public void readFile()
	{
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while (true)
			{
				StudentDto stu = new StudentDto();
				String s = br.readLine();
				if (s==null)
					break;
				String []a = s.split(",");
				//studentDto 생성 후 setter 로 데이터 넣기
				//혹은 생성자 통해서 넣기도 됨
				stu.setName(a[0]);
				stu.setAge(Integer.parseInt(a[1]));
				stu.setJava(Integer.parseInt(a[2]));
				stu.setSpring(Integer.parseInt(a[3]));
				stu.setHtml(Integer.parseInt(a[4]));
				
				list.add(stu);
			}
			System.out.println(list.size()+"명의 정보를 읽었습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾지 못했습니다");
		} catch (IOException |NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public void addStudent()
	{
		int age;
		System.out.println("이름 입력");
		String name = sc.nextLine();
		System.out.println("나이 입력");
		//문자 입력시 무조건 0으로 추가
		try {
		age = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			age=0;
		}
		System.out.println("자바 점수 입력");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("스프링 점수 입력");
		int spring = Integer.parseInt(sc.nextLine());
		System.out.println("html 점수 입력");
		int html = Integer.parseInt(sc.nextLine());
		
		StudentDto stu = new StudentDto(name, age, java, spring, html);
		list.add(stu);
		System.out.println(list.size()+"번째 학생 정보를 입력했습니다");
	}
	public void deleteStudent()
	{
		System.out.println("삭제할 학생 이름을 입력하시오");
		String del = sc.nextLine();
		int search =0;
		for(int i=0; i<list.size();i++)
		{
			StudentDto a = list.get(i);
			if(a.getName().equals(del))
			{
				search++;
				list.remove(i);
				System.out.println(del+"님을 삭제하였습니다");
				break;
			}
		}
		if(search==0)
		{
			System.out.println(del+"님은 list에 존재하지 않습니다");
		}
	}
	public void listStudent()
	{
		
		System.out.println("\t\t** 전체 학생목록 출력 **\n");
		System.out.println("번호\t이름\tJava\tSpring\tHTML\t총점\t평균\t등급");
		for(int i=0;i<list.size();i++)
		{
			StudentDto s = list.get(i);
			System.out.printf("%d\t%s\t%d점\t%d점\t%d점\t%d점\t%.1f점\t%s\n",i+1,
					s.getName(),s.getJava(),s.getSpring(),s.getHtml(),s.getTotal()
					,s.getAvg(),s.getGrade());
		}
	}
	public void searchAvg()
	{
		System.out.println("찾을 평균값을 입력하시오");
		int avg = Integer.parseInt(sc.nextLine());
		int search =0;
		for(int i=0;i<list.size();i++)
		{
			StudentDto s = list.get(i);
		if((double)s.getAvg()>(double)avg)
		{
			search++;
			System.out.printf("%s\t%d점\t%d점\t%d점\t%d점\t%.1f점\t%s\n",
					s.getName(),s.getJava(),s.getSpring(),s.getHtml(),s.getTotal()
					,s.getAvg(),s.getGrade());
		}
		}
		if (search==0)
		{
			System.out.println("평균"+avg+"점을 넘는 학생은 없습니다");
		}
	}
	public void searchName()
	{
		
		System.out.println("찾을 이름을 입력하시오");
		String fname = sc.nextLine();
		int search =0;
		for(int i=0;i<list.size();i++)
		{
			StudentDto s = list.get(i);
			if(s.getName().contains(fname))
			{
				search++;
				System.out.printf("%s\t%d점\t%d점\t%d점\t%d점\t%.1f점\t%s\n",
						s.getName(),s.getJava(),s.getSpring(),s.getHtml(),s.getTotal()
						,s.getAvg(),s.getGrade());
			}
		}
		if(search==0)
		{
			System.out.println(fname+"을(를) 이름에 가진 학생은 없습니다");
		}
		
	}
	public void saveFile()
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for(StudentDto stu:list)
			{
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(1);
				String a = stu.getName() +","+stu.getAge()+","+stu.getJava()+","
						+stu.getSpring()+","+stu.getHtml()+","+stu.getTotal()
						+","+nf.format(stu.getAvg())+","+stu.getGrade()+"\n";
				fw.write(a);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list.size()+"명의 정보를 저장");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex09_VectorMunje ex = new Ex09_VectorMunje();
		ex.readFile();
		while(true)
		{
			switch(ex.getMenu())
			{
			case 1:
				ex.addStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.listStudent();
				break;
			case 4:
				ex.searchAvg();
				break;
			case 5:
				ex.searchName();
				break;
			case 6:
				ex.saveFile();
				System.out.println("학생정보를 저장 후 종료합니다");
				System.exit(0);
			default:
				System.out.println("잘못된 숫자입니다");
			}
		}
	}

}
