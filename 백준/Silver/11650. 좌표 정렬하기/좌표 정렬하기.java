import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] table = new int[T][2];
		
		for(int i = 0; i < table.length; i++)
		{
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(stz.nextToken());
			int y = Integer.parseInt(stz.nextToken());
			
			table[i][0] = x;
			table[i][1] = y;
		}
		
		Arrays.sort(table, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]) == 0 ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i = 0; i < table.length; i++)
		{
			bw.write(table[i][0]+" "+table[i][1]+"\n");
		}
		
		bw.flush();
	}
}
