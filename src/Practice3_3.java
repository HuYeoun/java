
public class Practice3_3 {

	public static void main(String[] args) {
		int REM=0,CNT=0;
		
		for(int SU=1;SU<=500;SU++) {
			int SUM=0, K=SU/2;
			for(int J=1;J<=K;J++) {
				REM=SU-(SU/J)*J;	
				if(REM==0)SUM=SUM+J;
			}if(SU==SUM) {
				CNT++;
				System.out.println("완전수:"+SU);
			}
		}System.out.print("완전수의 개수: "+CNT);
	}
}
