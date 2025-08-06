import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner 스케너 = new Scanner(System.in);
		int 자연수[] = new int[2];
		for(int i = 0; i < 2;i++) {
			try {
				자연수[i] = 스케너.nextInt();
				if(자연수[i] <= 0 || 자연수[i] >= 10000) {
					System.out.println("범위를 벗어난 숫자입니다. 다시 입력해주세요");
					i--;
					continue;
				}
			}catch(InputMismatchException e) {
				스케너.nextLine();
				i--;
				System.out.println("다시 자연수를 입력해주세요.");
				continue;
			}
		}
		if(자연수[0] < 자연수[1]) {
			int temp = 자연수[0];
			자연수[0] = 자연수[1];
			자연수[1] = temp;
		}
		스케너.close();
		System.out.print(최소공약수(자연수[0],자연수[1])+"\n"+최대공배수(자연수[0],자연수[1]));
	}
	public static int 최소공약수(int 큰수,int 작은수) {
		int 나머지 = 0; 
		while(작은수 != 0) {
			나머지 = 큰수 % 작은수;
			큰수 = 작은수;
			작은수 = 나머지;
		}
		return 큰수;
	}
	public static int 최대공배수(int 큰수,int 작은수) {
		return 큰수 * 작은수 / 최소공약수(큰수, 작은수);
	}
}
