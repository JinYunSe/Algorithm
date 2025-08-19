import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for(int i = 0; i < input; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			String order = str.nextToken();
			
			//System.out.println("count : "+str.countTokens());
			
			if(str.countTokens() == 0)
			{
				//System.out.println("order : "+order);
				if(order.equals("empty")) hashSet.clear();
				else if(order.equals("all")) 
				{
					hashSet = new HashSet<Integer>() ;
					for(int j = 1; j <= 20; j++) hashSet.add(j);
				}
				continue;
			}
			int num = Integer.parseInt(str.nextToken());
			
			if(order.equals("add")) hashSet.add(num);
			else if(order.equals("remove")) hashSet.remove(num);
			else if(order.equals("check")) 
			{
				bw.write((hashSet.contains(num) ? 1 : 0)+"");
				bw.newLine();
			}
			else if(order.equals("toggle"))
			{
				if(hashSet.contains(num)) hashSet.remove(num);
				else hashSet.add(num);
			}
		}
		
		bw.flush();
	}
}
