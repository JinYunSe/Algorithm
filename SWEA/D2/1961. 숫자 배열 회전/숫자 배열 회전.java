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
			
			String[][] result = new String[size][size];
			
			for(int i = 0; i < result.length; i++)
			{
				result[i] = br.readLine().split(" ");
			}
			
			bw.write("#"+test_case);
			
			bw.newLine();
			
			for(int i = 0; i < result.length; i++)
			{
				String[] temp = new String[3];
				Arrays.fill(temp, "");
				
				for(int j = result.length - 1; j >= 0; j--) temp[0] += result[j][i];
				for(int j = result.length - 1; j >= 0; j--) temp[1] += result[result.length - i - 1][j];
				for(int j = result.length - 1; j >= 0; j--) temp[2] += result[result.length - j - 1][result.length - i - 1];
				
				bw.write(temp[0]+" "+temp[1]+" "+temp[2]);
				bw.newLine();
			}
		}
		bw.flush();
	}
}
