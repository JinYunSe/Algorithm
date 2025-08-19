import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Set<String> hashSet = new HashSet<String>();
		
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++)
		{
			String[] order = br.readLine().split(" ");
			
			if(order[1].equals("enter")) hashSet.add(order[0]);
			else hashSet.remove(order[0]);
		}

		List<String> temp = new ArrayList<>(hashSet);
		
		Collections.sort(temp);
		Collections.reverse(temp);
		
		
		for(String name : temp)
		{
			bw.write(name);
			bw.newLine();
		}
		bw.flush();
	}
}
