import java.io.*;
import java.util.*;

public class Main {
	
	static final int MAX = 100000;
	
	public static class Node implements Comparable<Node>
	{
		int point;
		int time;
		
		public Node(int point, int time)
		{
			this.point = point;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.time, o.time);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(stz.nextToken());
		int end = Integer.parseInt(stz.nextToken());
		
		int[] totalCost = new int[MAX + 1];
		Arrays.fill(totalCost, Integer.MAX_VALUE);
		
		totalCost[start] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			
			int currentPoint = currentNode.point;
			int currentTime = currentNode.time;
			
			if(currentTime != totalCost[currentPoint]) continue;
			if(currentPoint == end) break;
			
			int nextPoint = currentPoint * 2;
			
			if(nextPoint <= MAX && currentTime < totalCost[nextPoint])
			{
				totalCost[nextPoint] = currentTime;
				queue.add(new Node(nextPoint, currentTime));
			}
			
			nextPoint = currentPoint - 1;
			
			if(nextPoint >= 0 && currentTime + 1 < totalCost[nextPoint])
			{
				totalCost[nextPoint] = currentTime + 1;
				queue.add(new Node(nextPoint, currentTime + 1));
			}
			
			nextPoint = currentPoint + 1;
			
			if(nextPoint <= MAX && currentTime + 1 < totalCost[nextPoint])
			{
				totalCost[nextPoint] = currentTime + 1;
				queue.add(new Node(nextPoint, currentTime + 1));
			}
		}
		
		bw.write(totalCost[end]+"\n");
		bw.flush();
	}
}
