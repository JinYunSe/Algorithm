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
	public static class UnionSet 
	{
		private int[] parent;
		private int[] rank;
		private int[] size;
		
		public UnionSet(int n)
		{
			// 0 ~ n까지 사용해서 공간이 n - 1개 필요하지만
			// 편의상 n + 1개로 생성
			this.parent = new int[n + 1];
			this.rank = new int[n + 1];
			this.size = new int[n + 1];
			
			for(int i = 0; i < n + 1; i++)
			{
				// 부모를 자기 자신으로 초기화
				this.parent[i] = i;
				// 깊이를 0으로 초기화
				this.rank[i] = 0;
				// 집합 개수는 본인만 존재(1)로 초기화
				this.size[i] = 1;
			}
		}
		
		// 최상위 부모 찾기
		// 재귀적 특성을 사용해 x 뿐만 아니라 중간 중간 대상도 부모에 연결
		public int find(int x)
		{
			if(this.parent[x] != x) this.parent[x] = find(this.parent[x]);
			return this.parent[x];
		}
		
		
		// rank를 기반으로 집합 만들기
		public void unionRank(int x, int y)
		{
			// 최상위 부모 가져오기
			int rootX = find(x), rootY = find(y);
			
			// 부모가 같은 경우 함수 종료(집합으로 묶을 필요가 없기 때문)
			if(rootX == rootY) return;
			
			// rootX의 랭크가 rootY 보다 클 경우
			if(this.rank[rootX] > this.rank[rootY])
			{
				//rootY의 부모를 rootX로 설정
				this.parent[rootY] = rootX;
				// rootX에 rootY의 집합 개수 더해주기
				// => rootX의 포함 관계?로 합쳤기 때문
				this.size[rootX] += this.size[rootY];
			}
			// rootY의 랭크가 rootX 보다 클 경우
			else if(this.rank[rootX] < this.rank[rootY] )
			{
				this.parent[rootX] = rootY;
				this.size[rootY] += this.size[rootX];
			}
			else // 두 랭크가 동일한 경우
			{
				//rootX의 부모를 rootY로 변경
				this.parent[rootX] = rootY;
				//rootY의 랭크를 1증가시켜 rootX 보다 큰 랭크로 만듬
				this.rank[rootY]++;
				// rootY에 포함관계로 만들어 rootX개 만큼 사이즈 증가시킴
				this.size[rootY] += this.size[rootX];
			}
		}
		
		// 집합 개수를 바탕으로 집합 합치기
		// 유니온 랭크를 쓰면 되지만 연습용으로 만듬
		public void unionSize(int x, int y)
		{
			int rootX = find(x), rootY = find(y);
			
			if(rootX == rootY) return;
			
			if(this.size[rootX] >= this.size[rootY])
			{
				this.parent[rootY] = rootX;
				this.size[rootX] += this.size[rootY];
			}
			else
			{
				this.parent[rootX] = rootY;
				this.size[rootY] += this.size[rootX];
			}
		}
		
		// 연결 관계 여부
		public boolean isConnected(int x, int y)
		{
			// 최상위 부모가 나올 것이라
			// 같으면 연결된 관계
			// 아니면 다른 관계
			return find(x) == find(y);
		}
		
		// 집합의 개수 구하기
		public int sizeOf(int x)
		{
			return this.size[find(x)]; // 최상위 부모가 가진 개수로 구한다.
		}
	}
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
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			UnionSet union = new UnionSet(input[0]);
			
			for(int i = 0; i < input[1]; i++)
			{
				int[] con = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				union.unionRank(con[0], con[1]);
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i = 1; i <= input[0]; i++)
			{
				int root = union.find(i);
				if(!list.contains(root)) list.add(root);
			}
			
			System.out.println("#"+test_case+" "+list.size());
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}