import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < inputNum; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			List<String> list = new ArrayList<String>();
		
			while(str.hasMoreTokens())
			{
				list.add(str.nextToken());
			}
			
			Set<String> set = new HashSet<String>();
			
			while(true)
			{
				String anotherSound = br.readLine();
				if(anotherSound.equals("what does the fox say?")) break;
				
				String[] temp = anotherSound.split(" ");
				
				set.add(temp[2]);
			}
			
			list.removeAll(set);
			
			for(String wantSound : list) bw.write(wantSound+" ");
			bw.flush();
		}
	}
}