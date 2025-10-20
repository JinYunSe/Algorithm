import java.io.*;
import java.util.*;

public class Main {
	
	
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 명령 개수 n개
    	int n = Integer.parseInt(br.readLine());
    	
    	Deque<Integer> queue= new LinkedList<Integer>();
    	
    	for(int i = 0; i < n; i++)
    	{
    		StringTokenizer stz = new StringTokenizer(br.readLine());
    		
    		String order = stz.nextToken();
    		
    		int num = 0;
    		
    		switch(order)
    		{
    		case "push":
    			
    			num = Integer.parseInt(stz.nextToken());
    			queue.add(num);
    			// ( queue.offer(num) add와 동일하게 값을 추가하는 메서드 )
    			
    			break;
    		case "pop":
    			
    			num = queue.isEmpty() ? -1 : queue.poll();
    			bw.write(num+"\n");
    			
    			break;
    		case "size":
    			
    			num = queue.size();
    			bw.write(num+"\n");
    			
    			break;
    		case "empty":
    			
    			num = queue.isEmpty() ? 1 : 0;
    			bw.write(num+"\n");
    			
    			break;
    		case "front":
    			
    			num = queue.isEmpty() ? -1 : queue.peek();
    			bw.write(num+"\n");
    			
    			break;
    		case "back":
    			
    			num = queue.isEmpty() ? -1 : queue.peekLast();
    			bw.write(num+"\n");
    			
    			break;
    		}
    	}
    	
    	// 출력
    	bw.flush();
    }
}
