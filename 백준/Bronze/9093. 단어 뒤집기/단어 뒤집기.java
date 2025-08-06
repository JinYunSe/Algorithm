import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner 스케너 = new Scanner(System.in);

		int 줄수 = 스케너.nextInt();
		스케너.nextLine();
		String[] 문장 = new String[줄수];
		for(int i = 0; i < 문장.length;i++) {
			문장[i] = 스케너.nextLine();
		}
		스케너.close();
		for(int i = 0; i < 문장.length;i++) {
			String[] 한줄 = 문장[i].split(" ");
			StringBuffer[] 거꾸로 = new StringBuffer[한줄.length];
			for(int j = 0; j < 한줄.length;j++) {
				거꾸로[j] = new StringBuffer(한줄[j]);
				System.out.print(거꾸로[j].reverse()+" ");
			}
			System.out.println();
		}
	}
}