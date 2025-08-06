import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		ArrayList<Integer>list[] = new ArrayList[count];
		for(int i = 0; i < list.length;i++) {
			list[i] = new ArrayList<Integer>();
			int nunber = scanner.nextInt();
			for(int j = 0; j < nunber;j++) {
				list[i].add(scanner.nextInt());
			}
		}
		scanner.close();
		for(int i = 0; i < list.length; i++) {
			long sum = 0;
			for(int j = 0; j < list[i].size() - 1; j++) {
				for(int k = j + 1; k < list[i].size();k++) {
					sum += GCD(list[i].get(j),list[i].get(k));
				}
			}
			System.out.println(sum);
		}
	}
	public static int GCD(int small,int big) {
		int remainder = 0;
		if(big < small) {
			int temp = small;
			small = big;
			big = temp;
		}
		while(small != 0) {
			remainder = big % small;
			big  = small;
			small = remainder;
		}
		return big;
	}
}
