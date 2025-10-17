import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		char[] array = br.readLine().toCharArray();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++)
		{
			char changeWord = Character.toUpperCase(array[i]);
			
			if(!map.containsKey(changeWord)) map.put(changeWord, 1);
			else map.replace(changeWord, map.get(changeWord) + 1);
			
			max = Math.max(max, map.get(changeWord));
		}
		
		boolean check = false;
		char word = ' ';
		for(Character key : map.keySet())
		{
			if(map.get(key) == max)
			{
				if(!check) 
				{
					word = key;
					check = true;
				}
				else 
				{
					word = '?';
					break;
				}
			}
		}
		
		bw.write(word);
		bw.flush();
	}
}
