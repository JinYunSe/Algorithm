import java.io.*;
import java.util.*;

public class Solution {
	
	// 							상 하 좌 우 이동을 2개의 배열로 표현
	private static int[] dy = { -1, 1, 0, 0};
	private static int[] dx = { 0, 0, -1, 1};
	private static int check;
	
	
	// 위치를 저장할 class
	public static class Node
	{
		// row(행 저장용 변수)
		int row;
		// column(열 저장용 변수)
		int column;
		
		public Node(int row, int column)
		{
			this.row = row;
			this.column = column;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	for(int test_case = 1; test_case <= 10; test_case++)
    	{
    		check = 0;
    		// 현재 테스트 넘버
    		int test = Integer.parseInt(br.readLine());
    		
    		// 미로
    		int[][] table = new int[16][16];
    		
    		// 방문 여부 기록용
    		boolean[][] visited = new boolean[16][16];
    		
    		// 시작 row(행) column(열), 끝 row(행), column(열)
    		int startRow = -1, startColumn = -1, endRow = -1, endColumn = -1;
    		
    		// 미로 입력
    		for(int i = 0; i < table.length; i++)
    		{
    			char[] temp = br.readLine().toCharArray();
    			
    			for(int j = 0; j < table[i].length; j++)
    			{
    				table[i][j] = Integer.parseInt(String.valueOf(temp[j]));
    				
    				// 시작 위치일 경우 해당 위치 저장
    				if(table[i][j] == 2)
    				{
    					startRow = i;
    					startColumn = j;
    				}
    				// 끝 위치일 경우 해당 위치 저장
    				else if(table[i][j] == 3)
    				{
    					endRow = i;
    					endColumn = j;
    				}
    			}
    		}
    		
    		visited[startRow][startColumn] = true;
    		
    		DFS(table, visited, startRow, startColumn, endRow, endColumn);
    		
    		
    		// 결과 출력
    		bw.write("#"+test+" "+check);
    		bw.newLine();
    	}
    	
    	// 출력
    	bw.flush();
    }
    
    // 필요한 매개변수
    // 맵
    // 방문 여부
    // 현재 위치
    // 끝 지점
    
    public static void DFS(int[][] table, boolean[][] visited, int currentRow, int currentColumn, int endRow, int endColumn)
    {
    	if(currentRow == endRow && currentColumn == endColumn)
    	{
    		check = 1;
    		return;
    	}
    	
    	for(int i = 0; i < dy.length; i++)
    	{
    		int nextRow = currentRow + dy[i];
    		int nextColumn = currentColumn + dx[i];
    		
    		if(nextRow < 0 || nextRow >= table.length || nextColumn < 0 || nextColumn >= table[nextRow].length) continue;
    		if(visited[nextRow][nextColumn] || table[currentRow][currentColumn] == 1) continue;
    		
    		visited[nextRow][nextColumn] = true;
    		
    		DFS(table, visited, nextRow, nextColumn, endRow, endColumn);
    		
    		visited[nextRow][nextColumn] = false;
    	}
    }
}
