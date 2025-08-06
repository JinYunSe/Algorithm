import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean valid = true;
		int n = 0;
		do {
			try {
				n = scanner.nextInt();
				if(n > 50) {
					System.out.println("50이하의 숫자를 입력해주세요");
					valid = false;
				}
			}catch(InputMismatchException e) {
				scanner.nextLine();
				System.out.println("50이하의 숫자를 입력해주세요");
				valid = false;
			}	
		}while(!valid);
		String[] str = new String[n];
		for(int i = 0; i < str.length;i++) {
			str[i] = scanner.next();
		}
		scanner.close();
		char[] temp = str[0].toCharArray();
		for(int i = 0; i < str.length - 1;i++) {
			for(int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) != str[i+1].charAt(j))temp[j] = '?';
			}
		}
		System.out.print(temp);
	}
}