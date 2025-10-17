import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	boolean[][] table = new boolean[100][100];
    	
    	int T = Integer.parseInt(br.readLine());
    	
    
    	for(int test_case = 0; test_case < T; test_case++)
    	{
    		String temp = br.readLine();
    		
    		String[] point = temp.split(" ");
    		
    		int row = Integer.parseInt(point[0]);
    		int column = Integer.parseInt(point[1]);
    		
    		for(int i = row; i < row + 10; i++)
    		{
    			for(int j = column; j < column + 10; j++)
    			{
    				table[i][j] = true;
    			}
    		}
    	}
    	
    	int count = 0;
    	for(int i = 0; i < table.length; i++)
    	{
    		for(int j = 0; j < table[i].length; j++)
    		{
    			if(table[i][j]) count++;
    		}
    	}
    	
    	bw.write(count+"\n");
    	bw.flush();
    }
}
