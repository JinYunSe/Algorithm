import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String binary_number = scanner.nextLine();
		scanner.close();
		ArrayList<Character>list = new ArrayList<Character>();
		for(int i = 0; i < binary_number.length();i++) {
			list.add(binary_number.charAt(i));
		}
		int count = 0;
		for(int i = 0; i < binary_number.length();i++) {
			if((binary_number.length() - (i + 1))% 3 == 2) {
				count = 0;
				count += list.get(i).equals('1') ? 4 : 0;
			}
			else if((binary_number.length() - (i + 1))% 3 == 1) count += list.get(i).equals('1') ? 2 : 0;
			else if((binary_number.length() - (i + 1))% 3 == 0) {
				count += list.get(i).equals('1') ? 1 : 0;
				System.out.print(count);
			}
		}
	}
}