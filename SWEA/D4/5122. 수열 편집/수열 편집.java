package ssafy13501SequenceEditing;

import java.io.*;
import java.util.*;

import com.sun.jdi.Value;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stz.nextToken());
			int m = Integer.parseInt(stz.nextToken());
			int l = Integer.parseInt(stz.nextToken());
			
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			String[] input = br.readLine().split(" ");
			
			for(int i = 0; i < n; i++) list.add(Integer.parseInt(input[i]));
			
			for(int i = 0; i < m; i++)
			{
				stz = new StringTokenizer(br.readLine());
				
				char order = stz.nextToken().charAt(0);

				int index = Integer.parseInt(stz.nextToken());
				if(order == 'I')
				{
					int value = Integer.parseInt(stz.nextToken());
					
					list.add(index, value);
				}
				else if(order == 'D')
				{
					list.remove(index);
				}
				else if(order == 'C')
				{
					int value = Integer.parseInt(stz.nextToken());
					list.remove(index);
					list.add(index, value);
				}
			}
			
			bw.write("#"+test_case+" "+ (l >= list.size() ? -1 : list.get(l))+"\n");
		}
		bw.flush();
	}
}
