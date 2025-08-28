import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int findNumber = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < findNumber; i++)
		{
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j < findNumber; j++)
			{
				queue.add(Integer.parseInt(temp[j]));
			}
		}
		
		for(int i = 0; i < findNumber - 1; i++)
		{
			queue.poll();
		}
		
		bw.write(queue.poll()+"");
		bw.flush();
	}
}
