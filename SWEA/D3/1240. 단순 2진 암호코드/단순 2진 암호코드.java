import java.io.*;
import java.util.*;

public class Solution {
	
	private static String[] binaryArray = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011" };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(stz.nextToken());
			int c = Integer.parseInt(stz.nextToken());
			
			String[] table = new String[r];
			
			int findIndex = -1;
			boolean check = true;
			for(int i  = 0; i < r; i++)
			{
				String temp = br.readLine();
				table[i] = temp;
				
				if(table[i].contains("1") && check)
				{
					findIndex = i;
					check = false;
				}
			}
			
			StringBuilder sb = new StringBuilder(table[findIndex]);
			
			int endColumn = -1;
			
			for(int i = table[findIndex].length() - 1; i >= 0 ; i--)
			{
				if(table[findIndex].charAt(i) == '1') 
				{
					endColumn = i;
					break;
				}
			}
			
			int odd = 0, even = 0;
					
			int startIndex = endColumn - 55;
			
			//System.out.println(startIndex);
			
			for(int i = 0; i < 8; i++)
			{
				String temp = sb.substring(startIndex + i * 7, startIndex + (i + 1) * 7);
				
				//System.out.println(temp);
				
				for(int j = 0; j < binaryArray.length; j++)
				{
					if(binaryArray[j].equals(temp))
					{
						if(i % 2 == 0) even += j;
						else odd+= j;
					}
				}
			}
			
			//System.out.println("#"+test_case+" "+odd +" "+even);
			System.out.println("#"+test_case+" "+((odd + even * 3) % 10 == 0 ? even + odd : 0));
		}
	}
}
