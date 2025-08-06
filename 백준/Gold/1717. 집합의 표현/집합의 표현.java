import java.io.*;
import java.util.*;

public class Main {
	
	public static class UnionSet
	{
		int[] parent;
		int[] rank;
		
		public UnionSet(int n)
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
			if(x != this.parent[x]) this.parent[x] = find(this.parent[x]);
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
			else if(this.rank[rootY] > this.rank[rootX])
			{
				this.parent[rootX] = rootY;
			}
			else
			{
				this.parent[rootX] = rootY;
				this.rank[rootY]++; 
			}
		}
		
		public boolean isConnected(int x, int y)
		{
			return find(x) == find(y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(rb.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		UnionSet unionSet = new UnionSet(input[0]);
		for(int i = 0; i < input[1]; i++)
		{
			
			int[] temp = Arrays.stream(rb.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(temp[0] == 0)
			{
				unionSet.union(temp[1],temp[2]);
			}
			else
			{
				System.out.println(unionSet.isConnected(temp[1], temp[2]) ? "YES" : "NO");
			}
		}
		
	}
}
