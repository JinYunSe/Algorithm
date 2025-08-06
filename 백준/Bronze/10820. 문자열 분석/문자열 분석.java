import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            int lower = 0;
            int upper = 0;
            int number = 0;
            int blank = 0;
            for (int i=0; i<input.length(); i++) {
                char temp = input.charAt(i);
                if (Character.isUpperCase(temp)) {
                    upper += 1;
                } else if (Character.isLowerCase(temp)) {
                    lower += 1;
                } else if (Character.isDigit(temp)) {
                    number += 1;
                } else if (Character.isSpaceChar(temp)) {
                    blank += 1;
                }
            }
            System.out.println(lower + " " + upper + " " + number + " " + blank);
        }
	}
}