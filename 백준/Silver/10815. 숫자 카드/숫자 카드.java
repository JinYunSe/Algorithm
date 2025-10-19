import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int firstCount = Integer.parseInt(br.readLine());
    	
    	HashSet<Integer> firstCard = new HashSet<Integer>();

    	StringTokenizer stz = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < firstCount; i++) firstCard.add(Integer.parseInt(stz.nextToken()));
    	
    	int secondCount = Integer.parseInt(br.readLine());
    	
    	stz = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i < secondCount; i++)
    	{
    		int temp = Integer.parseInt(stz.nextToken());
    		int result = firstCard.contains(temp) ? 1 : 0;
    		
    		bw.write(result+" ");
    	}
    	bw.flush();
    }
}
