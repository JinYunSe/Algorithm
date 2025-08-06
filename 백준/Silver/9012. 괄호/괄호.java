import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner 스케너 = new Scanner(System.in);
		int 줄 = 스케너.nextInt();
		String[] 한줄 = new String[줄];
		스케너.nextLine();
		for(int i = 0; i < 한줄.length;i++) {
			한줄[i] = 스케너.nextLine();
		}
		스케너.close();
		for(int i = 0; i < 한줄.length;i++) {
			int count = 0;
			String[] 괄호 = 한줄[i].split("");
			for(int j = 0; j < 괄호.length;j++) {
				if(count < 0)break;
				else if(괄호[j].equals("("))count++;
				else if(괄호[j].equals(")"))count--;
			}
			if(count == 0)System.out.println("YES");
			else System.out.println("NO");
		}	
	}
}