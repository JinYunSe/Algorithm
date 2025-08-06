import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next().toLowerCase();
		scanner.close();
		boolean check = true;
		for(int i = 0; i < text.length();i++) {
			int j = text.length() - (i + 1);
			if(i > j) break;
			if((text.charAt(i) != text.charAt(j))) {
				check = false;
				break;
			}
		}
		if(check == true) System.out.print(1);
		else System.out.print(0);
	}
}
