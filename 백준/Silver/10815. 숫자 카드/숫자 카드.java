import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		String[] nInput = br.readLine().split(" ");
		for(int i = 0; i < n; i++) hashSet.add(Integer.parseInt(nInput[i]));
		
		int m = Integer.parseInt(br.readLine());
		
		int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		
		int[] result = new int[m];
		for(int i = 0; i < m; i++) System.out.print((hashSet.contains(num[i]) ? 1 : 0) + " "); 
	}
}
