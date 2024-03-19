package day0319;

public class Pprac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=10;j++)
			{
				int answer = 4*i + j*5;
				if(answer==60)
				{
					System.out.printf("%d,%d\n",i,j);
				}
			}
		}
	}

}
