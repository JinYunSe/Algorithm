import java.io.*;
import java.util.*;

public class Main {
	
	static class MyStack<Integer>
	{
		List<Integer> list;
		MyStack()
		{
			this.list = new LinkedList<Integer>();
		}
		
		public void add(Integer num)
		{
			this.list.add(num);
		}
		
		public int pop()
		{
			if(this.isEmpty()) return -1;
			
			int temp = (int)list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return temp;
		}
		
		public int size()
		{
			return list.size();
		}
		
		public int peek()
		{
			if(this.isEmpty()) return -1;
			return (int)list.get(list.size() - 1);
		}
		
		public boolean isEmpty()
		{
			return list.isEmpty();
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 명령 개수 n개
    	int n = Integer.parseInt(br.readLine());
    	
    	// 스택 구조를 이해했고, 메서드의 동작을 이해 및 사용할 수 있다면
    	// Java 라이브러리의 Stack을 사용하면 좋다
    	// => 아래와 같이 Stack을 객체 생성 및 사용할 수 있다.
    	MyStack<Integer> stack = new MyStack<Integer>();
    
    	// n번 반복
    	for(int i = 0; i < n; i++)
    	{
    		// 명령 저장
    		StringTokenizer stz = new StringTokenizer(br.readLine());
    		
    		// 명령 추출
    		int order = Integer.parseInt(stz.nextToken());
    		
    		// 임시 변수
    		int num = 0;
    		
    		// if문을 사용해도 좋지만
    		// switch문을 사용해
    		// 각각의 case에 대해 간략하게 작성할 수 있다.
    		// switch문에서는 case - break;로 각 케이스의 기능을 작성할 수 있다,
    		// 만약, 각각의 case에 break를 주지 않을 경우 그 아래 case로 빠지게 돼
    		// 원하지 않는 기능이 수행될 수 있다.(그 결과, 원하지 않는 값이 저장될 수 있다)
    		// 하지만, 잘 활용하면 아래와 같이
    		// case 1: case 2: break; 1과 2의 경우를 동일한 기능으로 동작하게 만들 수도 있다.
    		
    		// 추가적으로,
    		// case에 없는 경우를 작성하고 한다면(else에 해당)
    		// default: (기능) break;
    		// 로 else문과 동일한 기능을 작성 및 동작하게 할 수 있다.
    		switch(order)
    		{
    		case 1:
    			num = Integer.parseInt(stz.nextToken());
    			// stack.add()에 요소 추가
    			stack.add(num);
    			break;
    		case 2:
    			// stack.isEmpty() 스택에 요소 있는지 여부 확인
    			// true(없다), false(있다) 반환
    			
    			// 조건부 연산자(삼항 연산자)를 활용해 요소가 없다면 -1,
    			// 있으면 해당 요소를 stack.pop()으로 스택에서 꺼냄
    			num = stack.isEmpty() ?  -1 : stack.pop();
    			bw.write(num+"\n");
    			break;
    		case 3:
    			// stack.size() 스택의 사이즈 반환
    			bw.write(stack.size()+"\n");
    			break;
    		case 4:
    			num = stack.isEmpty() ? 1 : 0;
    			bw.write(num+"\n");
    			break;
    		case 5:
    			// stack.peek()는 스택에 가장 위에 있는 요소를 확인하는 메서드
    			// pop()과 달리 꺼내지는 않는다.
    			num = stack.isEmpty() ? -1 : stack.peek();
    			bw.write(num+"\n");
    			break;
    		}
    	}
    	
    	// 출력
    	bw.flush();
    }
}
