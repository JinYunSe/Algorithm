import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node implements Comparable<Node>
	{
		int point;
		int cost;
		
		public Node(int point, int cost)
		{
			this.point = point;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int pointCount = Integer.parseInt(stz.nextToken());
		int edgeCount = Integer.parseInt(stz.nextToken());
		
		Map<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
		
		for(int i = 0; i < edgeCount; i++)
		{
			stz = new StringTokenizer(br.readLine());
			
			int go = Integer.parseInt(stz.nextToken());
			int destination = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			
			
			if(!map.containsKey(go)) map.put(go, new LinkedList<Node>());
			if(!map.containsKey(destination)) map.put(destination, new LinkedList<Node>());
			
			map.get(go).add(new Node(destination, cost));
			map.get(destination).add(new Node(go,cost));	
		}
		
		int[] totalCost = new int[pointCount + 1];
		Arrays.fill(totalCost, Integer.MAX_VALUE);
		
		int start = 1;
		totalCost[start] = 0;
		
		int[] prev = new int[pointCount + 1];
		Arrays.fill(prev, -1);
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0));
		
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			
			int currentPoint = currentNode.point;
			int currentCost = currentNode.cost;
			
			
			if(currentCost > totalCost[currentPoint]) continue;
			
			if(!map.containsKey(currentPoint)) continue;
			
			for(Node nextNode : map.get(currentPoint))
			{
				int nextPoint = nextNode.point;
				int changeCost = nextNode.cost + currentCost;
				
				if(changeCost < totalCost[nextPoint])
				{
					
					prev[nextPoint] = currentPoint;
					totalCost[nextPoint] = changeCost;
					queue.add(new Node(nextPoint, changeCost));
				}
			}
		}
		
		bw.write(pointCount - 1+"");bw.append("\n");
		
		for(int v = 2; v <= pointCount; v++)
		{
			bw.write(v+""); bw.append(" ").append(prev[v]+"").append("\n");
		}
		
		bw.flush();
	}
}
