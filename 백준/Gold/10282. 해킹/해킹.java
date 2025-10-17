import java.io.*;
import java.util.*;

public class Main {
	
	static class Node
	{
		private int point;
		private int cost;
		
		public Node(int point, int cost)
		{
			this.point = point;
			this.cost = cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	StringTokenizer stz = new StringTokenizer(br.readLine());
        	
        	int n = Integer.parseInt(stz.nextToken());
        	int d = Integer.parseInt(stz.nextToken());
        	int c = Integer.parseInt(stz.nextToken());
        	
        	HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
        	
        	for(int i = 0; i < d; i++)
        	{
        		stz = new StringTokenizer(br.readLine());
        		
        		int endPonit =  Integer.parseInt(stz.nextToken());
        		int startPoint = Integer.parseInt(stz.nextToken());
        		int cost = Integer.parseInt(stz.nextToken());
        		
        		if(!map.containsKey(startPoint)) map.put(startPoint, new LinkedList<>());
        		
        		map.get(startPoint).add(new Node(endPonit, cost));
        	}
        	
        	int[] totalCost = new int[n + 1];
        	Arrays.fill(totalCost, Integer.MAX_VALUE);
        	
        	totalCost[c] = 0;
        	
        	PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.cost, o2.cost);
				}
			});
        	
        	
        	queue.add(new Node(c, 0));
        	
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
        			int nextCost = nextNode.cost + currentCost;
        			
        			if(nextCost < totalCost[nextPoint])
        			{
        				totalCost[nextPoint] = nextCost;
        				queue.add(new Node(nextPoint, nextCost));
        			}
        		}
        	}
        	
        	int count = 0;
        	int maxTime = Integer.MIN_VALUE;
        	
        	for(int i = 1; i < totalCost.length; i++)
        	{
        		if(totalCost[i] != Integer.MAX_VALUE)
        		{
        			count++;
        			maxTime = Math.max(totalCost[i], maxTime);
        		}
        	}
        	
        	bw.write(count+" "+maxTime);
        	bw.append('\n');
        }
        bw.flush();
    }
}
