import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner 스케너 = new Scanner(System.in);
		boolean valid = false;
		int 과목수 = 0;
		while(!valid){
			valid = true;
			try {
				과목수 = 스케너.nextInt();
				if(과목수 <= 0) {
					System.out.println("범위를 벗어난 숫자입니다. 다시 입력해주세요");
					valid = false;
				}
			}catch(InputMismatchException e) {
				스케너.nextLine();
				System.out.println("숫자를 입력해주세요");
				valid = false;
			}
		}
		ArrayList<Integer> 리스트[] = new ArrayList[과목수];
		for(int i = 0; i < 리스트.length;i++) {
			int 인원수 = 0;
			try {
				인원수 = 스케너.nextInt();
				if(인원수 < 1 || 인원수 > 1000) {
					i--;
					System.out.println("범위를 벗어난 인원입니다. 다시 입력해주세요");
					continue;
				}
			}catch(InputMismatchException e) {
				스케너.nextLine();
				i--;
				System.out.println("숫자를 입력해주세요");
				continue;
			}
			리스트[i] = new ArrayList<Integer>();
			for(int j = 0; j < 인원수;j++) {
				int 점수 = 0;
				try {
					점수 = 스케너.nextInt();
					if(점수 < 0 || 점수 > 100) {
						j--;
						System.out.println("범위를 벗어난 점수입니다. 다시 입력해주세요");
						continue;
					}
				}catch(InputMismatchException e) {
					j--;
					스케너.nextLine();
					System.out.println("숫자를 입력해주세요");
					continue;
				}
				리스트[i].add(점수);
			}
		}
		double[] 평균 = new double[과목수];
		for(int i = 0; i < 리스트.length;i++) {
			for(int j = 0; j < 리스트[i].size();j++) {
				평균[i] += 리스트[i].get(j);
			}
			평균[i] /= 리스트[i].size();
		}
		double 높은사람수[] = new double[과목수];
		for(int i = 0; i < 리스트.length;i++) {
			for(int j = 0; j < 리스트[i].size();j++) {
				if(평균[i] < 리스트[i].get(j)) {
					높은사람수[i]++;
				}
			}
		}
		for(int i = 0; i < 리스트.length;i++) {
			System.out.printf("%.3f%%\n",(double)(높은사람수[i]*100/리스트[i].size()));
		}
	}
}