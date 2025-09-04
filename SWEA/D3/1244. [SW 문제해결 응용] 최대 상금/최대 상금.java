/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	private static ArrayList<Integer> resultList;
	private static HashSet<Integer>[] visited;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			resultList = new ArrayList<>();
			
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			String[] temp = stz.nextToken().split("");
			int swapCount = Integer.parseInt(stz.nextToken());
			
			int[] num = new int[temp.length];
			
			for(int i = 0; i < temp.length; i++) num[i] = Integer.parseInt(temp[i]);
			
			visited = new HashSet[swapCount + 1];
			
			for(int i = 0; i <= swapCount; i++) visited[i] = new HashSet<>();
			DFS(0, swapCount, num);

			int max = Integer.MIN_VALUE;
			for(int n : resultList)
			{
				max = Math.max(n, max);
			}
			
			System.out.println("#"+test_case+" "+max);
		}
	}
	
	private static void DFS(int start, int end, int[] num) {
		// TODO Auto-generated method stub
		int result = currentNumber(num);
		
		if(visited[start].contains(result)) return;
		visited[start].add(result);
		
		if(start == end) 
		{
			resultList.add(result);
			return;
		}
		
		for(int i = 0; i < num.length - 1; i++)
		{
			for(int j = i + 1; j < num.length; j++)
			{
				// 스왑
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				
				DFS(start + 1, end, num);
				
				// 원상 복구
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
	
	private static int currentNumber(int[] num)
	{
		int result = 0;
		
		for(int n : num)
		{
			result += n;
			result *= 10;
		}
		result /= 10;
		
		return result;
	}
}