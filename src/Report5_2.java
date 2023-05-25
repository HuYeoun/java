import java.util.ArrayList;
import java.util.Scanner;

public class Report5_2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ArrayList<Integer> arr=new ArrayList<>();
		
		int N=0,top=-1;
		
		while(true) {
			System.out.print("명령의 수(0<=N<=50)>> ");
			N=scan.nextInt();
			
			if(0<=N&&N<=50) break;
			
			System.out.println("다시 입력해주세요.");
		}
		
		for(int i=0;i<=N;i++) {
			String str=scan.nextLine();
			
			switch(str){
				case "pop":
					if(top==-1) {
						System.out.println("-1");
					}else {
						System.out.println(arr.get(top));
						arr.remove(top);
						top--;
					}
					break;
					
				case "size":
					System.out.println(top+1);
					break;
					
				case "empty":
					if(top==-1)System.out.println("1");
					else System.out.println("0");
					break;
					
				case "top":
					if(top==-1)System.out.println("-1");
					else System.out.println(top);
					break;
					
				case "printStack":
					for(int j=top;j>-1;j--) System.out.print(arr.get(j)+" ");
					System.out.println();
					break;
				
				default :
					int s = str.indexOf("push");
					
					if(s==0) {
						String intStr = str.replaceAll("[^\\d]", "");
						int num = Integer.parseInt(intStr);
						
						if(0<num&&num<100) {
							top++;
							arr.add(num);
							}else {
								System.out.println("정수는 0<X<100 안에서 지정해주세요");
								i--;
							}
						}
					s=1;
					break;
			}
		}
	}
}
