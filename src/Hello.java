import java.util.Scanner;
public class Hello {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int inputNum=0;
		int fac=1;
		
		
		System.out.print("정수를 입력하세요. :");
		inputNum=scan.nextInt();
		
		for(int i=inputNum; 1<=i;i--) {
			fac=fac*i;
			sb.append(i);
			if(i!=1)sb.append("*");
		}
		System.out.print(inputNum+"!은 "+sb+" "+fac);
	}
}


