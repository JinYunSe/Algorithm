import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] array = br.readLine().toCharArray();
			
			Set<Character> set = new HashSet<>();
			char before = array[0];
			
			set.add(before);
			
			boolean check = true;
			
			for(int i = 1; i < array.length; i++)
			{
				char current = array[i];
				
				if(before == current) continue;
				
				if(set.contains(current))
				{
					check = false;
					break;
				}
				
				
				before = current;
				set.add(current);
			}
			count += check ? 1 : 0;
		}
		
		bw.write(count+"\n");
		bw.flush();
	}
}
