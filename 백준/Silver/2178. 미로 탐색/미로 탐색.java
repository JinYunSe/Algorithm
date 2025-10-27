import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] dy = {-1, 1, 0, 0};
	private static int[] dx = {0, 0, -1, 1};

	public static class Node
	{

		public int row;
		public int column;
		public int cost;
		
		public Node(int row, int column, int cost) 
		{
			this.row = row;
			this.column = column;
			this.cost = cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer stz = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(stz.nextToken());
    	int m = Integer.parseInt(stz.nextToken());
    	
    	int min = Integer.MAX_VALUE;
    	
    	int[][] table = new int[n][m];
    	boolean[][] visited = new boolean[n][m];
    	
    	for(int i = 0; i < table.length; i++)
    	{
    		char[] temp = br.readLine().toCharArray();
    		for(int j = 0; j < table[i].length; j++)
    		{
    			table[i][j] = Integer.parseInt(temp[j] + "");
    		}
    	}
    	
//    	visited[0][0] = true;
//    	DFS(table, visited, 0, 0, 1);
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(new Node(0, 0, 1));
    	visited[0][0] = true;
		
    	
    	while(!queue.isEmpty())
    	{
    		Node currentNode = queue.poll();
    		
    		int currentRow = currentNode.row;
    		int currentColumn = currentNode.column;
    		int currnetCost = currentNode.cost;
    		
    		if(currentRow == n - 1 && currentColumn == m - 1)
    		{
    			min = Math.min(min, currnetCost);
    		}
    		
    		for(int i = 0; i < dy.length; i++)
    		{
    			int nextRow = currentRow + dy[i];
    			int nextColumn = currentColumn + dx[i];
    			int nextCost = currnetCost + 1;
    			
    			if(nextRow < 0 || nextRow >= table.length || nextColumn < 0 || nextColumn >= table[nextRow].length) continue;
    			if(visited[nextRow][nextColumn] || table[nextRow][nextColumn] == 0) continue;
    			
    			visited[nextRow][nextColumn] = true;
    			
    			queue.add(new Node(nextRow, nextColumn, nextCost));
    		}
    	}
    	
    	
    	bw.write(min+"\n");
    	bw.flush();
    }

//	private static void DFS(int[][] table, boolean[][] visited, int currentRow, int currentColumn, int currnetCount) {
//		
//		if(table[currentRow][currentColumn] == 0 || currnetCount > min) return;
//		if(currentRow == n - 1 && currentColumn == m - 1)
//		{
//			min = Math.min(min, currnetCount);
//			return;
//		}
//		
//		for(int i = 0; i < dy.length; i++)
//		{
//			int nextRow = currentRow + dy[i];
//			int nextColumn = currentColumn + dx[i];
//			
//			if(nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= m) continue;
//			if(visited[nextRow][nextColumn]) continue;
//			
//			visited[nextRow][nextColumn] = true;
//			
//			DFS(table, visited, nextRow, nextColumn, currnetCount + 1);
//			
//			visited[nextRow][nextColumn] = false;
//		}
//		
//	}
}
