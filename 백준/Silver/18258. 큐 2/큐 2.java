import java.io.*;
import java.util.*;

public class Main {
	
	static class MyDeque
	{
		private List<Integer> list;
		
		MyDeque()
		{
			this.list = new LinkedList<Integer>();
		}
		
		public void add(int value)
		{
			this.list.add(value);
		}
		
		public int pop()
		{
			if(this.isEmpty()) return -1;
			
			int num = this.list.get(list.size() - 1);
			this.list.remove(this.size() - 1);
			
			return num;
		}
		
		public int size()
		{
			return this.list.size();
		}
		
		public int peek()
		{
			if(this.isEmpty()) return -1;
			
			return this.list.get(0);
		}
		
		public int back()
		{
			if(this.isEmpty()) return -1;
			
			return this.list.get(this.size() - 1);
		}
		
		public boolean isEmpty()
		{
			return this.list.isEmpty();
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 명령 개수 n개
    	int n = Integer.parseInt(br.readLine());
    	
    	// Java 라이브러리에 있는
    	// Deque(Dequeue) 양방향 Queue
    	// Queue는 무조건 FIFO인데 
    	// Deque는 FIFO과 LIFO을 둘 다 지원하는 자료구조이다.
    	// 이유 : 양방향 연결 리스트로 구현 돼 있기 때문에
    	// (사진 참고)
    	Deque<Integer> queue= new LinkedList<Integer>();
    	
    	for(int i = 0; i < n; i++)
    	{
    		StringTokenizer stz = new StringTokenizer(br.readLine());
    		
    		String order = stz.nextToken();
    		
    		int num = 0;
    		
    		// switch는 사용 방법은 stack을 참고해주세요
    		// int와 동일하게 문자열을 비교 가능
    		// equals() 없이 비교 가능하기 때문에 코드가 간결해진다.
    		switch(order)
    		{
    		case "push":
    			
    			// queue에 삽입
    			num = Integer.parseInt(stz.nextToken());
    			queue.add(num);
    			// ( queue.offer(num) add와 동일하게 값을 추가하는 메서드 )
    			
    			break;
    		case "pop":
    			
    			// isEmpty() Queue에 요소가 있는지 확인 
    			// 없으면 true, 있으면 false
    			
    			// 삼항 연산자로 없으면 -1,
    			// queue.poll()을 사용해 있으면 가장 앞에 있는 요소를 꺼냄
    			num = queue.isEmpty() ? -1 : queue.poll();
    			bw.write(num+"\n");
    			
    			break;
    		case "size":
    			
    			// queue.size() Queue의 요소 개수 출력
    			num = queue.size();
    			bw.write(num+"\n");
    			
    			break;
    		case "empty":
    			
    			// Queue에 요소가 없으면 1, 있으면 0
    			num = queue.isEmpty() ? 1 : 0;
    			bw.write(num+"\n");
    			
    			break;
    		case "front":
    			
    			// 큐에 요소가 있을 경우 가장 앞에 있는 요소 가져오기
    			num = queue.isEmpty() ? -1 : queue.peek();
    			bw.write(num+"\n");
    			
    			break;
    		case "back":
    			
    			// 큐에서 요소가 있을 경우 가장 뒤에 있는 요소 가져오기
    			num = queue.isEmpty() ? -1 : queue.peekLast();
    			bw.write(num+"\n");
    			
    			break;
    		}
    	}
    	
    	// 출력
    	bw.flush();
    }
}
