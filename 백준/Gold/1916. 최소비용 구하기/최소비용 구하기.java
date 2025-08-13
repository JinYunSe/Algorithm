import java.io.*;
import java.util.*;

public class Main {
	
	public static class NextPoint
	{
		private int point;
		private int cost;
		
		public NextPoint(int point, int cost) {
			this.point = point;
			this.cost = cost;
		}
		
		public int getPoint() {
			return point;
		}
		public void setPoint(int point) {
			this.point = point;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, LinkedList<NextPoint>> dict = new HashMap<Integer,LinkedList<NextPoint>>();
		
		int inputInfoCount = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < inputInfoCount; i++)
		{
			int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(!dict.containsKey(info[0])) dict.put(info[0], new LinkedList<NextPoint>());
			
			dict.get(info[0]).add(new NextPoint(info[1], info[2]));
		}
		
		int[] busCost = new int[N + 1];
		Arrays.fill(busCost, Integer.MAX_VALUE);
		
				
		int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		busCost[point[0]] = 0;
		
		
		boolean[] visited = new boolean[N + 1];
		
		for(int i = 0; i < N; i++)
		{
			int min = Integer.MAX_VALUE;
			int curPoint = -1;
			
			for(int j = 1; j <= N; j++)
			{
				if(!visited[j]&& busCost[j] < min)
				{
					min = busCost[j];
					curPoint = j;
				}
			}
			
			if(curPoint == -1) break;
			if(curPoint == point[1]) break;
			
			visited[curPoint] = true;
			
            for (NextPoint np : dict.getOrDefault(curPoint, new LinkedList<>())) {
                int v = np.getPoint();
                int w = np.getCost();
                if (!visited[v] && busCost[curPoint] != Integer.MAX_VALUE
                        && busCost[v] > busCost[curPoint] + w) {
                	busCost[v] = busCost[curPoint] + w;
                }
            }
		}
		
		System.out.println(busCost[point[1]]);
	}
}
