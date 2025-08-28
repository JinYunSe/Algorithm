import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1) == Math.abs(o2))
				{
					return Integer.compare(o1,o2);
				}
				else
				{
					return Integer.compare(Math.abs(o1), Math.abs(o2));
				}
			}
		});
		
		int findNumber = Integer.parseInt(br.readLine());

		for(int i = 0; i < findNumber;i++)
		{
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) bw.write((queue.isEmpty() ? 0 : queue.poll())+"\n");
			else queue.add(num);
		}
		
		bw.flush();
	}
}
