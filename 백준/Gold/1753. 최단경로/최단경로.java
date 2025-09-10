import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node implements Comparable<Node>
	{
		int destinationNode;
		int cost;
		
		public Node(int destinationNode, int cost)
		{
			this.destinationNode = destinationNode;
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
		
		int v = Integer.parseInt(stz.nextToken());
		int e = Integer.parseInt(stz.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		Map<Integer, LinkedList<Node>> map = new HashMap<>();
		
		
		for(int i = 0; i < e; i++)
		{
			stz = new StringTokenizer(br.readLine());
			
			int go = Integer.parseInt(stz.nextToken()) - 1;
			int destination = Integer.parseInt(stz.nextToken()) - 1;
			int cost = Integer.parseInt(stz.nextToken());
			
			if(!map.containsKey(go)) map.put(go, new LinkedList<>());
			
			map.get(go).add(new Node(destination, cost));
		}
		
		int[] totalCost = new int[v];
		
		Arrays.fill(totalCost, Integer.MAX_VALUE);
		
		totalCost[k - 1] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		queue.add(new Node(k - 1, 0));
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			
			int currentPoint = currentNode.destinationNode;
			int currentCost = currentNode.cost;
			
			
			if(currentCost != totalCost[currentPoint]) continue;
			
			if(!map.containsKey(currentPoint)) continue;
			
			for(Node nextNode : map.get(currentPoint))
			{
				int nextPoint = nextNode.destinationNode;
				int changeCost = nextNode.cost + currentCost;
				
				if(changeCost  < totalCost[nextPoint])
				{
					totalCost[nextPoint] = changeCost;
					queue.add(new Node(nextPoint, changeCost));
				}
			}
		}
		
		for(int i = 0; i < totalCost.length; i++)
		{
			System.out.println(totalCost[i] == Integer.MAX_VALUE ? "INF" : totalCost[i]);
		}
		
	}
}
