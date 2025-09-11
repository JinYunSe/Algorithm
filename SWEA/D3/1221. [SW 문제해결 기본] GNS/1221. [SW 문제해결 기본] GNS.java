import java.io.*;
import java.util.*;

public class Solution {
	
	public static String[] numberStr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <=T; test_case++)
		{
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			String testNum = stz.nextToken();
			
			int StrNum = Integer.parseInt(stz.nextToken());
			
			stz = new StringTokenizer(br.readLine());
			
			TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
			
			while(stz.hasMoreTokens())
			{
				String key = stz.nextToken();
				if(!treeMap.containsKey(key)) treeMap.put(key, 1);
				else treeMap.replace(key, treeMap.get(key) + 1);
			}
			
			bw.write(testNum+"\n");
			
			for(int i = 0; i < numberStr.length; i++)
			{
				String key = numberStr[i];
				if(!treeMap.containsKey(key)) continue;
				for(int j = 0; j < treeMap.get(key); j++)
				{
					bw.write(key+" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
