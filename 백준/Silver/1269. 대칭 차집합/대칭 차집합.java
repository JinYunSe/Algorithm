import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int aNum = Integer.parseInt(str.nextToken());
		int bNum = Integer.parseInt(str.nextToken());
		
		
		HashSet<Integer> a = new HashSet<Integer>();

		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < aNum; i++)
		{
			a.add(Integer.parseInt(str.nextToken()));
		}
		
		HashSet<Integer> b = new HashSet<Integer>();
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < bNum; i++)
		{
			b.add(Integer.parseInt(str.nextToken()));
		}
		
		HashSet<Integer> remainA = new HashSet<Integer>();
		HashSet<Integer> remainB = new HashSet<Integer>();
		
		for(Integer num : b)
		{
			if(!a.contains(num)) remainA.add(num);
		}
		
		for(Integer num : a)
		{
			if(!b.contains(num)) remainB.add(num);	
		}
		
		bw.write(remainA.size()+remainB.size()+"");
		bw.flush();
	}
}
