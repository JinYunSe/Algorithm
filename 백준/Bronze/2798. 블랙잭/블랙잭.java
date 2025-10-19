import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		// n과 m 입력 받기
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		
		stz = new StringTokenizer(br.readLine());
		
		// 카드 개수 만큼 배열 형성
		int[] card = new int[n];
		
		// 카드 입력 받기
		for(int i = 0; i < card.length; i++) card[i] = Integer.parseInt(stz.nextToken());
		
		// 전체 결과 값 담을 변수
		int sum = 0;
		
		// 3 중 for 문
		// 마지막 반복 대상이
		// n - 2이라 n - 2로 설정
		// (생각해보면 그렇습니다...)
		for(int i = 0; i < n - 2; i++)
		{
			// 카드 선택은 중복 선택이 안 되므로
			// i + 1부터 시작
			
			// 마지막 반복 대상이
			// n - 1이라 n - 1로 설정
			
			for(int j = i + 1; j < n - 1; j++)
			{
				// 위와 마찬가지 원리로 시작 및 종료 설정
				
				for(int k = j + 1; k < n; k++)
				{
					// 세 카드의 합 구하기
					int temp = card[i] + card[j] + card[k];
					
					// 현재 sum보다 크고 m보다 작거나 같으면 갱신
					if(sum < temp && temp <= m) sum = temp;
				}
			}
		}
		
		bw.write(sum+"\n");
		bw.flush();
	}
}
