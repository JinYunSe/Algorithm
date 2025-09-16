import java.io.*;
import java.util.*;

public class Main {
	
	private static int max;
	
	static class Node
	{
		int point;
		int cost;
		
		public Node(int point, int cost)
		{
			this.point = point;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		int x = Integer.parseInt(stz.nextToken());
		
		max =  Integer.MIN_VALUE;
		HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer,LinkedList<Node>>();
		HashMap<Integer, LinkedList<Node>> backMap = new HashMap<Integer,LinkedList<Node>>();
		for(int i = 0; i < m; i++)
		{
			stz = new StringTokenizer(br.readLine());
			
			int go = Integer.parseInt(stz.nextToken());
			int destination = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			
			if(!map.containsKey(go)) map.put(go, new LinkedList<Node>());
			if(!backMap.containsKey(destination)) backMap.put(destination, new LinkedList<Node>());
			
			map.get(go).add(new Node(destination, cost));
			backMap.get(destination).add(new Node(go,cost));
		}
		
		for(int i = 1; i <= n; i++)
		{
			if(i == x) continue;
			int sum = getCost(x, i, n, map) + getCost(i, x, n, map);
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	}
	
	public static int getCost(int start, int end, int n, HashMap<Integer, LinkedList<Node>> map)
	{
		int sum = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		int[] totalCost = new int[n + 1];
		Arrays.fill(totalCost, Integer.MAX_VALUE);
		
		totalCost[start] = 0;
		
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			
			int currentPoint = currentNode.point;
			int currentCost = currentNode.cost;
			
			
			if(currentPoint == end)
			{
				sum += currentCost;
				break;
			}
			
			if(!map.containsKey(currentPoint)) continue;
			
			for(Node nextNode : map.get(currentPoint))
			{
				int nextPoint = nextNode.point;
				int changeCost = nextNode.cost + currentCost;
				
				if(changeCost < totalCost[nextPoint])
				{
					totalCost[nextPoint] = changeCost;
					queue.add(new Node(nextPoint, changeCost));
				}
			}
		}
		
		return sum;
	}
}
