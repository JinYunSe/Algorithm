import java.io.*;
import java.util.*;

public class Main {
    
    private final static Long INF = 10000000000L;
    
    public static class Node implements Comparable<Node>
    {
        int point;
        long cost;
        
        public Node(int point, long cost) {
            this.point = point;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return Long.compare(this.cost, o.cost);
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int pointCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());
        
        Map<Integer, LinkedList<Node>> map = new HashMap<>();
        
        StringTokenizer stz;
        
        for(int i = 0; i < edgeCount; i++)
        {
            stz = new StringTokenizer(br.readLine(), " ");
            
            int go = Integer.parseInt(stz.nextToken());
            int destination = Integer.parseInt(stz.nextToken());
            int cost  = Integer.parseInt(stz.nextToken());
            
            if(!map.containsKey(go)) map.put(go, new LinkedList<>());
            
            map.get(go).add(new Node(destination, cost));
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        stz = new StringTokenizer(br.readLine(), " ");
        
        int start = Integer.parseInt(stz.nextToken());
        int end = Integer.parseInt(stz.nextToken());
        
        long[] totalCost = new long[pointCount + 1];
        
        Arrays.fill(totalCost, INF);
        
        int[] prev = new int[pointCount + 1];
        
        Arrays.fill(prev, -1);
        
        totalCost[start] = 0;
        
        queue.add(new Node(start, 0));
        
        while(!queue.isEmpty())
        {
            Node currentNode = queue.poll();
            
            int currentPoint = currentNode.point;
            long currentCost = currentNode.cost;
            
            if(currentCost > totalCost[currentPoint]) continue;
            
            if(!map.containsKey(currentPoint)) continue;
            
            for(Node nextNode : map.get(currentPoint))
            {
                int nextPoint = nextNode.point;
                long changeCost = nextNode.cost + currentCost;
                
                if(changeCost < totalCost[nextPoint])
                {
                    totalCost[nextPoint] = changeCost;
                    prev[nextPoint] = currentPoint;
                    queue.add(new Node(nextPoint, changeCost));
                }
            }
        }
        
        if(totalCost[end] == INF)
        {
        	bw.write("-1\n");
        	bw.flush();
        	return;
        }
        
        LinkedList<Integer> path = new LinkedList<>();
        for(int i = end; i != -1; i = prev[i]) path.addFirst(i);
        
        bw.write(totalCost[end]+"\n");
        bw.write(path.size()+"\n");
        for(int point : path) bw.write(point + " ");
        bw.append("\n");
        bw.flush();
    }
}