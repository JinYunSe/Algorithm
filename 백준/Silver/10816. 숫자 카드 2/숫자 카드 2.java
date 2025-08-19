import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int nInput = Integer.parseInt(br.readLine());
		
		String[] nTemp = br.readLine().split(" ");
		
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nInput; i++)
		{
			int num = Integer.parseInt(nTemp[i]);
			
			if(!dict.containsKey(num)) dict.put(num, 1);
			else dict.replace(num, dict.get(num) + 1);
		}
		
		int mInput = Integer.parseInt(br.readLine());
		
		String[] mTemp = br.readLine().split(" ");
		
		for(int i = 0; i < mInput; i++)
		{
			int num = Integer.parseInt(mTemp[i]);
			bw.write((dict.containsKey(num) ? dict.get(num) : 0)+" ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}
