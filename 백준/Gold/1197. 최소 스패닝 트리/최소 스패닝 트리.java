import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] parent;
    private static int[] rank;
    private static int[] size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stz = new StringTokenizer(br.readLine());
        
        int pointCount = Integer.parseInt(stz.nextToken());
        int edgeCount = Integer.parseInt(stz.nextToken());
        
        parent = new int[pointCount + 1];
        rank = new int[pointCount + 1];
        size = new int[pointCount + 1];
        
        for(int i = 0; i < parent.length; i++)
        {
        	parent[i] = i;
        	rank[i] = 0;
        	size[i] = 1;
        }
        
        int[][] table = new int[edgeCount][3];
        
        for(int i = 0; i < table.length; i++)
        {
        	stz = new StringTokenizer(br.readLine());
        	table[i][0] = Integer.parseInt(stz.nextToken());
        	table[i][1] = Integer.parseInt(stz.nextToken());
        	table[i][2] = Integer.parseInt(stz.nextToken());
        }
        
        Arrays.sort(table, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
        
        int cost = 0;
        
        for(int i = 0; i < table.length; i++)
        {
        	if(!isCollectioned(table[i][0],table[i][1]))
        	{
        		cost += table[i][2];
        		unionRank(table[i][0], table[i][1]);
        	}
        }
        
        bw.write(cost+"\n");
        
        bw.flush();
    }
    
    public static int find(int x)
    {
        if(x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public static void unionRank(int x, int y)
    {
        int rootX = find(x), rootY = find(y);
        
        if(rootX == rootY) return;
        
        if(rank[rootX] > rank[rootY])
        {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        else if(rank[rootY] > rank[rootX])
        {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        else
        {

            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            rank[rootX]++;
        }
    }
    
    public static boolean isCollectioned(int x, int y)
    {
    	return find(x) == find(y);
    }
    
}
