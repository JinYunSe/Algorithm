import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int size = Integer.parseInt(br.readLine());
			
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i = 0; i < size; i++)
			{
				int num = Integer.parseInt(br.readLine());
				
				
				switch(num)
				{
				case 0:
					stack.pop();
					break;
				default : 
					stack.add(num);
					break;
				}
			}
			
			
			int sum = 0;
			while(!stack.isEmpty())
			{
				sum += stack.pop();
			}
			
			bw.write("#"+test_case);
			bw.append(" "+sum);
			bw.newLine();
		}
		bw.flush();
	}
}
