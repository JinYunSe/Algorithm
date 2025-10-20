import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	Stack<Integer> stack = new Stack<Integer>();
    
    	for(int i = 0; i < n; i++)
    	{
    		StringTokenizer stz = new StringTokenizer(br.readLine());
    		
    		int order = Integer.parseInt(stz.nextToken());
    		
    		int num = 0;
    		
    		switch(order)
    		{
    		case 1:
    			num = Integer.parseInt(stz.nextToken());
    			stack.add(num);
    			break;
    		case 2:
    			num = stack.isEmpty() ?  -1 : stack.pop();
    			bw.write(num+"\n");
    			break;
    		case 3:
    			bw.write(stack.size()+"\n");
    			break;
    		case 4:
    			num = stack.isEmpty() ? 1 : 0;
    			bw.write(num+"\n");
    			break;
    		case 5:
    			num = stack.isEmpty() ? -1 : stack.peek();
    			bw.write(num+"\n");
    			break;
    		}
    	}
    	
    	// 출력
    	bw.flush();
    }
}
