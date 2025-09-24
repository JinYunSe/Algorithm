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
        int edgeCount = (pointCount * (pointCount - 1)) / 2;
        
        parent = new int[pointCount + 1];
        rank = new int[pointCount + 1];
        size = new int[pointCount + 1];
        
        for(int i = 0; i < parent.length; i++)
        {
        	parent[i] = i;
        	rank[i] = 0;
        	size[i] = 1;
        }
        
        
        double[] pointX = new double[pointCount];
        double[] pointY = new double[pointCount];
        
        for(int i = 0; i < pointCount; i++)
        {
        	StringTokenizer stz = new StringTokenizer(br.readLine());
        	
        	pointX[i] = Double.parseDouble(stz.nextToken());
        	pointY[i] = Double.parseDouble(stz.nextToken());
        }
        
        double[][] edgeTable = new double[edgeCount][3];
        
        int k = 0;
        for(int i = 0; i < pointCount - 1; i++)
        {
        	for(int j = i + 1; j < pointCount; j++)
        	{
        		edgeTable[k][0] = i;
        		edgeTable[k][1] = j;
        		edgeTable[k++][2] = Math.sqrt(Math.pow(pointX[i] - pointX[j], 2) + Math.pow(pointY[i] - pointY[j], 2));
        	}
        }
        
//        for(int i = 0; i < edgeTable.length; i++)
//        {
//        	System.out.println(edgeTable[i][0]+" "+edgeTable[i][1]+" "+edgeTable[i][2]);
//        }
        
        Arrays.sort(edgeTable, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1[2], o2[2]);
			}
		});
        
        double totalCost = 0;
        
        for(int i = 0; i < edgeTable.length; i++)
        {
        	int left = (int)edgeTable[i][0], right = (int)edgeTable[i][1];
        	double cost = edgeTable[i][2];
        	
//        	System.out.println(left+" "+right+" "+cost);
        	if(!isConnection(left, right)) {
        		totalCost += edgeTable[i][2];
        		unionRank(left, right);
//        		System.out.println(totalCost);
        	}
        }
        
        bw.write(String.format("%.2f", totalCost));
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