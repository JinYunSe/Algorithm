import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int number= scanner.nextInt();
        int cnt=1;
        int temp=0;
        int lenght=10;
        scanner.close();
        for(int i=1;i<=number;i++) {
            if(i==lenght) {
                cnt++;
                lenght=lenght*10;
            }
            temp= temp+cnt;
        }
        System.out.println(temp);
	}
}
