import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[][] table;
	private static double max;
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			max = Integer.MIN_VALUE;
			
			int peo = Integer.parseInt(br.readLine());

			double[][] percent = new double[peo][peo];
			boolean[] visited = new boolean[peo];
			
			for(int i = 0; i < percent.length; i++)
			{
				String[] temp = br.readLine().split(" ");
				for(int j = 0; j < percent[i].length; j++)
				{
					int numTemp = Integer.parseInt(temp[j]);
					if((numTemp+"").length() == 1) 
					{
						percent[i][j] = Double.parseDouble("0.0"+numTemp);
					}
					else if((numTemp+"").length() == 2) 
					{
						percent[i][j] = Double.parseDouble("0."+numTemp);
					}
					else percent[i][j] = 1;
				}
			}
			
			double result = 1;
			
			DFS(0, peo, percent, visited, result);
			
			bw.write("#"+test_case+" "+String.format("%.6f", max * 100)+'\n');
		}
		bw.flush();
	}
	
	
	// 필요한 매개변수
	// 시작 index
	// 현재 깊이
	// 종료 깊이
	// percent 배열
	// 방문 배열
	// 결과
	public static void DFS(int depth, int end, double[][] percent, boolean[] visited, double currentResult)
	{
		if(currentResult < max) return;
		
		if(depth == end)
		{
			max = Math.max(currentResult, max);
			return;
		}

		for(int i = 0; i < percent[depth].length; i++)
		{
			if(visited[i]) continue;
			if(percent[depth][i] == 0.0) continue;
			
			visited[i] = true;
			
			DFS(depth + 1, end, percent, visited, currentResult * percent[depth][i]);
			
			visited[i] = false;
		}
	}
}
