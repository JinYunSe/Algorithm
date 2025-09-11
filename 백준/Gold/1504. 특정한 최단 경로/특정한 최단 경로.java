import java.io.*;
import java.util.*;

public class Main {
	
	public static int nCount;
	public static int eCount;
	
	public static HashMap<Integer, LinkedList<Node>> map;
	
	public static int v1;
	public static int v2;
	
	// 간선의 개수가 최대 200000이고, 거리 비용이 최대 1000이라
	public static int INF = 200000 * 1000;
	// => 나올 수 있는 최대 비용
	
	
	public static class Node implements Comparable<Node>
	{
		private int point;
		private int cost;
		
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
		
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		nCount = Integer.parseInt(stz.nextToken());
		
		eCount = Integer.parseInt(stz.nextToken());
		
		map = new HashMap<>();
		
		for(int i = 0; i < eCount; i++)
		{
			stz = new StringTokenizer(br.readLine());
			
			int go = Integer.parseInt(stz.nextToken());
			int destination = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			
			if(!map.containsKey(go)) map.put(go, new LinkedList<Node>());
			if(!map.containsKey(destination)) map.put(destination, new LinkedList<Node>());
			
			map.get(go).add(new Node(destination, cost));
			map.get(destination).add(new Node(go, cost));
		}
		
		stz = new StringTokenizer(br.readLine(), " ");
		
		v1 = Integer.parseInt(stz.nextToken());
		v2 = Integer.parseInt(stz.nextToken());
		
		
		int result = Math.min(dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, nCount), dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, nCount));
		System.out.println(result >= INF ? -1 : result);
	}
	
	public static int dijkstra(int go, int destination)
	{
		int[] totalCost = new int[nCount + 1];
		Arrays.fill(totalCost, INF);
		
		totalCost[go] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(go, 0));
		
		while(!queue.isEmpty())
		{
			Node currentNode = queue.poll();
			
			int currentPoint = currentNode.point;
			int currentCost = currentNode.cost;
			
			//queue에 오래 전에 있던 녀석이면 무시하고 다른 것 수행
			if(currentCost > totalCost[currentPoint]) continue;
			
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
		
		return totalCost[destination];
	}
}
