import java.util.Scanner;

public class Main {
	private static int count[] = new int[11];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcase = scanner.nextInt();
		int input[] = new int[testcase];
		for(int i = 0; i < input.length;i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();
		int count = 0;
		for(int i = 0; i < input.length;i++) {
			count = ReturnMethod(input[i]);
			System.out.println(count);
		}
	}
	public static int ReturnMethod(int n)
	{
		if(n < 0)return 0;
	    if(n == 0)return count[n] = 1;
	    if(count[n] != 0)return count[n];
	    return count[n] = ReturnMethod(n - 1) + ReturnMethod(n - 2) + ReturnMethod(n - 3); 
	}
}