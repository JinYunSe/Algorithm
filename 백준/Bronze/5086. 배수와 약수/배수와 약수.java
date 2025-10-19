import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while(true)를 통해 무한 반복문을 만들어준다.
		// 향후, 입력으로 0 0이 입력되면 break로 무한 반복문 탈출 예정
		while(true)
		{
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			// int형 변수 2개에 값을 저장
			int num1 = Integer.parseInt(stz.nextToken());
			int num2 = Integer.parseInt(stz.nextToken());
			
			// 0 0 이면 반복문 종료
			if(num1 == 0 && num2 == 0) break;
			
			String result = num1 % num2 == 0 ? "multiple\n" : num2 % num1 == 0 ? "factor\n" : "neither\n";
			
			bw.write(result);
		}

		bw.flush();
	}
}
