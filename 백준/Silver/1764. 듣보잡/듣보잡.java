import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < n + m; i++)
		{
			String temp = br.readLine();
			if(!dict.containsKey(temp)) dict.put(temp, 1);
			else list.add(temp);
		}
		
		Collections.sort(list);
		
		bw.write(list.size()+"");
		bw.newLine();
		for(String temp : list)
		{
			bw.write(temp);
			bw.newLine();
		}
		bw.flush();
	}
}
