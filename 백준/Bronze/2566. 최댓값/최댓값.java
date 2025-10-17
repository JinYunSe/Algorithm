import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int row = 1, column = 1;
    	int[][] table = new int[9][9];
    	
    	int max = 0;
    	
    	for(int i = 0; i < table.length; i++)
    	{
    		StringTokenizer stz = new StringTokenizer(br.readLine());
    		
    		for(int j = 0; j < table[i].length; j++)
    		{
    			int num = Integer.parseInt(stz.nextToken());
    			if(num > max)
    			{
    				max = num;
    				row = i + 1;
    				column = j + 1;
    			}
    		}
    	}
    	
    	System.out.println(max);
    	System.out.println(row+" "+column);
    }
}
