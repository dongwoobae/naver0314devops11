package day0319;

public class Pprac2 {

	public static void main(String[] args) {
		while(true)
		{
		int x = (int)(Math.random()*6)+1;
		int y =(int)(Math.random()*6)+1;
		
			if (x+y==5)
			{
				System.out.printf("%d,%d\n",x,y);
				break;
			}
			System.out.printf("%d,%d\n",x,y);
			}
}
	}