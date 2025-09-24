import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] parent;
    private static int[] rank;
    private static int[] size;
    
    public static class Edge
    {
    	int left;
    	int right;
    	int cost;
    	
		public Edge(int left, int right, int cost) {
			this.left = left;
			this.right = right;
			this.cost = cost;
		}

		public int getLeft() {
			return left;
		}

		public void setLeft(int left) {
			this.left = left;
		}

		public int getRight() {
			return right;
		}

		public void setRigth(int right) {
			this.right = right;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int pointCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());
        
        parent = new int[pointCount + 1];
        rank = new int[pointCount + 1];
        size = new int[pointCount + 1];
        
        for(int i = 0; i < parent.length; i++)
        {
        	parent[i] = i;
        	rank[i] = 0;
        	size[i] = 1;
        }
        
        List<Edge> list = new ArrayList<Edge>();
        
        for(int i = 0; i < edgeCount; i++)
        {
        	StringTokenizer stz = new StringTokenizer(br.readLine());
        	
        	int left = Integer.parseInt(stz.nextToken());
        	int right = Integer.parseInt(stz.nextToken());
        	int cost = Integer.parseInt(stz.nextToken());
        	
        	if(left == right) continue;
        	list.add(new Edge(left, right, cost));
        }
        
        Collections.sort(list, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.cost, o2.cost);
			}
		});
        
        int totalCost = 0;
        for(Edge edge : list)
        {
        	int left = edge.left;
        	int right = edge.right;
        	int cost = edge.cost;
        	
        	if(!isConnection(left, right))
        	{
        		totalCost += cost;
        		unionRank(left,right);
        	}
        }
        
        bw.write(totalCost +"\n");
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
    
    public static boolean isConnection(int x, int y)
    {
    	return find(x) == find(y);
    }
}
