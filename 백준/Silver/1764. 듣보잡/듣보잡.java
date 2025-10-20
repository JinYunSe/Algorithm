import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer stz = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(stz.nextToken());
    	int m = Integer.parseInt(stz.nextToken());
    	
    	HashSet<String> map = new HashSet<String>();
    	
    	for(int i = 0; i < n; i++) map.add(br.readLine());
    	
    	List<String> result = new ArrayList<String>();
    	for(int i = 0; i < m; i++) 
    	{
    		String temp = br.readLine();
    		if(map.contains(temp)) result.add(temp);
    	}
    	    
    	Collections.sort(result);
    	
    	bw.write(result.size()+"\n");
    	
    	for(String name : result)
    	{
    		bw.write(name+"\n");
    	}
    	
    	bw.flush();
    }
}
