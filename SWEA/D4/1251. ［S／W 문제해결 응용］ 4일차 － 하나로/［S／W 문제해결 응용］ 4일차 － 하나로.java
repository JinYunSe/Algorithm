/////////////////////////////////////////////////////////////////////////////////////////////
//기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
//아래 표준 입출력 예제 필요시 참고하세요.
//표준 입력 예제
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
//표준 출력 예제
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
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
class Solution {
	
	private static int parent[];
	private static int rank[];
	
	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
//System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = Integer.parseInt(br.readLine());
			int edgeCount = num * (num - 1) / 2;
			int[] x = new int[num];
			int[] y = new int[num];
			
			parent = new int[num];
			rank = new int[num];
			
			for(int i = 0; i < parent.length; i++)
			{
				parent[i] = i;
				rank[i] = 0;
			}
			
			
			String[] xTemp = br.readLine().split(" ");
			String[] yTemp = br.readLine().split(" ");
			
			for(int i = 0; i < x.length; i++)
			{
				x[i] = Integer.parseInt(xTemp[i]);
				y[i] = Integer.parseInt(yTemp[i]);
			}
			
			
			double e = Double.parseDouble(br.readLine());
			

			long[][] edge = new long[edgeCount][3];
			makeLoadLength(x, y, e, edge);

			Arrays.sort(edge, (e1, e2)-> Long.compare(e1[2], e2[2]));
			
			long cost = serach(edge);
			
			System.out.println("#"+test_case+" "+Math.round(cost * e));
/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
	
	private static long serach(long[][] edge) {
		// TODO Auto-generated method stub
		long cost = 0;
		for(int i = 0; i < edge.length; i++)
		{
			if(find(edge[i][0])!= find(edge[i][1]))
			{
				cost += edge[i][2];
				union(edge[i][0], edge[i][1]);
			}
			
		}
		return cost;
	}

	private static int find(double x)
	{
		if(parent[(int)x] != x) parent[(int)x] = find(parent[(int)x]);
		return parent[(int)x];
	}
	
	private static void union(double x, double y)
	{
		int rootX = find(x), rootY = find(y);
		
		if(rootX == rootY) return;
		
		if(rank[rootX] > rank[rootY])
		{
			parent[rootY] = rootX;
		}
		else if(rank[rootY] > rank[rootX])
		{
			parent[rootX] = rootY;
		}
		else
		{
			parent[rootY] = rootX;
			rank[rootX]++;
		}
	}

	//point 중심이 아닌 간선 중심으로 point to point와 가중치 구하기
	private static void makeLoadLength(int[] x, int[] y, double e,long[][] edge) {
		
		int index = 0;
		for(int i = 0; i < x.length - 1; i++)
		{
			for(int j = i + 1; j < x.length; j++)
			{
				// 왼쪽에 붙어 있는 point에 번호 붙이기
				edge[index][0] = i; 
				// 오른쪽에 붙어 있는 point에 번호 붙어기
				edge[index][1] = j;
				// 간선의 가중치 구하기
				edge[index++][2] = (long)(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
			}
		}
	}
}
