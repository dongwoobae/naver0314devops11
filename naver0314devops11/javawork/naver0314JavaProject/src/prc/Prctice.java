package prc;

interface Orange
{
    public void write();
}





public class Prctice {

    Orange or = new Orange() {

        @Override
        public void write() {
            System.out.println("오렌지다~");
        }
    };
    public void lambdaMethod()
    {
        Orange or2 = ()->System.out.println("람다식 오렌지");
        or.write();

        Orange or3=()->
                System.out.println("안녕하세요");
                System.out.println("람다식 공부중");
                or3.write();

        Orange or4= new Orange() {
            @Override
            public void write() {
                System.out.println("다양한 방법으로 구현");
            }

        };
        or4.write();

    }

    public static void main(String[] args) {
       



    }
}
