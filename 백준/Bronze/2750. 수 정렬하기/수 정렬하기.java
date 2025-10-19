import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		
		for(int i = 0; i < num.length;i++) num[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(num);
		
		for(int i = 0; i < num.length; i++) bw.write(num[i]+"\n");
		
		bw.flush();
	}
}
