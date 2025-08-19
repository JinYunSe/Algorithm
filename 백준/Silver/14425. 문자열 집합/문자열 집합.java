import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<String> hashSet = new HashSet<String>();
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		
		for(int i = 0; i < n; i++)
		{
			hashSet.add(br.readLine());
		}
		
		int count = 0;
		for(int i = 0; i < m; i++)
		{
			String temp = br.readLine();
			if(hashSet.contains(temp)) count++; 
		}
		
		wr.write(count+"");
		wr.flush();
	}
}
