import java.util.Scanner;
public class Practice4_12 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int A,B,R=1,HIGH,LOW,L;
		
		System.out.print("A값을 입력하세요>> ");
		A=scan.nextInt();
		System.out.print("B값을 입력하세요>> ");
		B=scan.nextInt();
		
		if(A>B){HIGH=A;LOW=B;}
		else{LOW=A;HIGH=B;} //1번
		
		while(R>0) {
			R=HIGH%LOW;
			HIGH=LOW;
			LOW=R;
		}
		L=(A*B)/HIGH;
		System.out.println("최대공약수: "+HIGH+" ,최소공배수: "+L);
	}

}
