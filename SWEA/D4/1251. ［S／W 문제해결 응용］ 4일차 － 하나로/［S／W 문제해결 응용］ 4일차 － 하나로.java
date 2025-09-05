import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[] rank;
	private static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());

			parent = new int[size];
			rank = new int[size];
			
			for(int i = 0; i < parent.length; i++)
			{
				parent[i] = i;
				rank[i] = 0;
			}

			int edgeCount = (size - 1) * size / 2;
			
			int[] x = new int[size];
			
			StringTokenizer stz = new StringTokenizer(br.readLine());
			for(int i = 0; i < x.length; i++)
			{
				x[i] = Integer.parseInt(stz.nextToken());
			}
			
			int[] y = new int[size];
			
			stz = new StringTokenizer(br.readLine());
			for(int i = 0; i < y.length; i++)
			{
				y[i] = Integer.parseInt(stz.nextToken());
			}
			
			long[][] table = new long[edgeCount][3];

			
			int z = 0;
			
			for(int i = 0; i < size - 1; i++)
			{
				for(int j = i + 1; j < size; j++)
				{
					table[z][0] = i;
					table[z][1] = j;
					table[z][2] = (long) (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
					z++;
				}
			}
			
			double e = Double.parseDouble(br.readLine());
			
			long cost = 0;
			
			
			Arrays.sort(table, new Comparator<long[]>() {

				@Override
				public int compare(long[] o1, long[] o2) {
					// TODO Auto-generated method stub
					return Long.compare(o1[2], o2[2]);
				}
			});
			
			for(int i = 0; i < table.length; i++)
			{
				int left = (int)table[i][0];
				int right = (int)table[i][1];
				
				if(find(left) != find(right))
				{
					cost += table[i][2];
					union(left, right);
				}
			}
			
			System.out.println("#"+test_case+" "+Math.round((e * cost)));
		}
	}
	
    // 부모 찾는 메서드
	public static int find(int x)
	{
        // 조건문 : 나 자신 스스로가 부모(최상위 root 노드)인가?
        // 아니면 부모의 부모를 계속 찾아감
        // => 결국 (최상위 root 노드)를 찾게 됨
		if(x != parent[x]) parent[x] = find(parent[x]);
        //최상위 root 노드 반환
		return (int) parent[x];
	}
	
    // 서로 다른 집합을 하나의 집합으로 만드는 메서드
	public static void union(int x, int y)
	{
        // x의 최상위 root 노드, y의 최상위 root 노드 가져오기
		int rootX = find(x), rootY = find(y);
		
		if(rootX == rootY) return;
		
        // rank[rootX] > rank[rootY]로
        // rank(높이)가 누가 높은지 비교
		if(rank[rootX] > rank[rootY])
		{
            // rootX가 높으므로 rootY의 부모를 rootX로 지정
			parent[rootY] = rootX;
		}
		else if(parent[rootY] > parent[rootX])
		{
            // rootY가 높으므로 rootX의 부모를 rootY로 지정
			parent[rootX] = rootY;
		}
        // 높이가 같으므로 한 대상 잡고 rank를 증가시켜주고
        // rank를 증가시키지 않은 대상의 부모를 rank를 증사키신 대상으로 만듬
		else 
		{
			parent[rootY] = rootX;
			rank[rootX]++;
		}
	}
}