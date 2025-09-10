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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cityCount = Integer.parseInt(br.readLine());
		int edgeCount = Integer.parseInt(br.readLine());
		
		HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
		StringTokenizer stz;
		
		for(int i = 0; i < edgeCount; i++)
		{
			stz = new StringTokenizer(br.readLine());
			
			int goPoint = Integer.parseInt(stz.nextToken()) - 1;
			int destinationPoint = Integer.parseInt(stz.nextToken()) - 1;
			int cost = Integer.parseInt(stz.nextToken());
			
			if(!map.containsKey(goPoint)) map.put(goPoint, new LinkedList<Node>());
			
			map.get(goPoint).add(new Node(destinationPoint, cost));
		}
		
		stz = new StringTokenizer(br.readLine());
		
		int startPoint = Integer.parseInt(stz.nextToken());
		int endPoint = Integer.parseInt(stz.nextToken());
		

		int[] totalCost = new int[cityCount];
		Arrays.fill(totalCost, Integer.MAX_VALUE);
		
		totalCost[startPoint - 1] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		
		queue.add(new Node(startPoint - 1, 0));
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			
			int currentPoint = currentNode.point;
			int cost = currentNode.cost;
			
			if(cost != totalCost[currentPoint]) continue;
			
			if(currentPoint == endPoint - 1) break;
			
			if(!map.containsKey(currentPoint)) continue;
			
			for(Node nextNode : map.get(currentPoint))
			{
				int nextPoint = nextNode.point;
				int changeCost = nextNode.cost + cost;
				
				if(changeCost < totalCost[nextPoint])
				{
					totalCost[nextPoint] = changeCost;
					queue.add(new Node(nextPoint, changeCost));
				}
			}
		}
		
		bw.write(totalCost[endPoint - 1]+"\n");
		bw.flush();
	}
}
