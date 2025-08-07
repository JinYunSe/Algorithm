import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	public static class UnionFind
	{
		private int[] parent;
		private int[] rank;
		
		public UnionFind(int n)
		{
			this.parent = new int[n + 1];
			this.rank = new int[n + 1];
			
			for(int i = 0; i < this.parent.length; i++)
			{
				this.parent[i] = i;
				this.rank[i] = 0;
			}
		}
		
		public int find(int x)
		{
			if(this.parent[x] != x) this.parent[x] = find(this.parent[x]);
			return this.parent[x];
		}
		
		public void union(int x, int y)
		{
			int rootX = find(x), rootY = find(y);
			
			if(rootX == rootY) return;
			
			if(this.rank[rootX] > this.rank[rootY])
			{
				this.parent[rootY] = rootX;
			}
			else if(this.rank[rootX] > this.rank[rootY])
			{
				this.parent[rootX] = rootY;
			}
			else
			{
				this.parent[rootY] = rootX;
				this.rank[rootX]++;
			}
		}
		
		public boolean isConnected(int x, int y)
		{
			return find(x) == find(y);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(rb.readLine());
		
		for(int test_case = 1; test_case <=T; test_case++)
		{
			int input = Integer.parseInt(rb.readLine());
			
			int[] x = new int[input];
			
			String[] tempX = rb.readLine().split(" ");
			
			for(int i = 0; i < x.length; i++)
			{
				x[i] = Integer.parseInt(tempX[i]);
			}
			
			int[] y = new int[input];
			
			String[] tempY = rb.readLine().split(" ");
			
			for(int i = 0; i < y.length; i++)
			{
				y[i] = Integer.parseInt(tempY[i]);
			}
			
			double e = Double.parseDouble(rb.readLine());

			int edgeCount = (input * (input - 1)) / 2;
			long[][] edge = new long[edgeCount][3];
			makeEdgeAndWeight(x, y, e, edge);
			
			Arrays.sort(edge, new Comparator<long[]>() {

				@Override
				public int compare(long[] o1, long[] o2) {
					// TODO Auto-generated method stub
					return Long.compare(o1[2], o2[2]);
				}
			});
			
			long cost = kruskalSearch(edge, input);
			
			System.out.println("#"+test_case+" "+Math.round((double)cost * e));
		}
	}
	
	public static void makeEdgeAndWeight(int[] x, int[] y, double e, long[][] edge)
	{
		int z = 0;
		for(int i = 0; i < x.length - 1; i++)
		{
			for(int j = i + 1; j < y.length; j++)
			{
				edge[z][0] = i;
				edge[z][1] = j;
				edge[z++][2] = (long) (Math.pow((x[i] - x[j]), 2) + Math.pow((y[i] - y[j]), 2));
			}
		}
	}
	
	public static long kruskalSearch(long[][] edge, int input)
	{
		UnionFind union = new UnionFind(input);
		long cost = 0;
		for(int i = 0; i < edge.length; i++)
		{
			if(!union.isConnected((int)edge[i][0], (int)edge[i][1]))
			{
				union.union((int)edge[i][0], (int)edge[i][1]);
				cost += edge[i][2];
			}
		}
		return cost;
	}
}
