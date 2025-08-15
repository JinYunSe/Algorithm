/////////////////////////////////////////////////////////////////////////////////////////////
//기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
//아래 표준 입출력 예제 필요시 참고하세요.
//표준 입력 예제
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
//표준 출력 예제
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution {
	
	private static int[] dy = { -1, 1, 0, 0};
	private static int[] dx = { 0, 0, -1, 1};
	
	public static class Node
	{
		// 입력에 따른 저장을 위해 만듬
		// 이름 뭘로 지어야 할지 몰라서 그냥 data로 함 ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		private int hole;
		
		// 경로 통과 비용 저장 용도
		private int cost;
		
		private int currentRow;
		private int currentColumn;
		
		public Node(int hole, int cost, int currentRow, int currentColumn) {
			
			this.hole = hole;
			this.cost = cost;
			
			this.currentRow = currentRow;
			this.currentColumn = currentColumn;
		}
		
		public int getHole() {
			return hole;
		}

		public void setHole(int hole) {
			this.hole = hole;
		}

		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}

		public int getCurrentRow() {
			return currentRow;
		}

		public void setCurrentRow(int currentRow) {
			this.currentRow = currentRow;
		}

		public int getCurrentColumn() {
			return currentColumn;
		}

		public void setCurrentColumn(int currentColumn) {
			this.currentColumn = currentColumn;
		}
	}
	
	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
//System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int size = Integer.parseInt(br.readLine());
			
			// 비용, 현재 row, 현재 column 저장할 공간
			Node[][] table = new Node[size][size];
			// 방문 여부 기록
			boolean[][] visited = new boolean[size][size];
			
			for(int i = 0; i < table.length; i++)
			{
				char[] temp = br.readLine().toCharArray();
				
				for(int j = 0; j < temp.length; j++)
				{	
					// 입력 값 , 초기에 모든 비용은 int 최대값, i, j는 본인 위치
					table[i][j] = new Node(Integer.parseInt(temp[j]+""),Integer.MAX_VALUE, i, j);
				}
			}
			
			// 시작 주소, 끝 주소
			int startRow = 0, startColumn = 0, endRow = size - 1, endColumn = size - 1;
			
			// 비용이 낮은 순으로 queue에서 나오게 설정
			PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1.getCost(), o2.getCost());
				}
			});
			
			// 시작 비용 0으로 변경
			table[startRow][startColumn].setHole(0);
			table[startRow][startColumn].setCost(0);
			
			// 시작 노드 제공
			queue.offer(table[startRow][startColumn]);
			
			// queue가 비어있지 않으면 계속 진행
			while(!queue.isEmpty())
			{
				// 현재 node 가져오기
				Node currentNode = queue.poll();
				
				// 현재 비용, row, column 위치 가져오기
				int currentCost = currentNode.getCost();
				int currentRow = currentNode.getCurrentRow();
				int currentColumn = currentNode.getCurrentColumn();
				
				if(currentRow == endRow && currentColumn == endColumn) break;
				// 방문 했던 node이면 다음 진행
				if(visited[currentRow][currentColumn]) continue;
				
				// 방문 처리
				visited[currentRow][currentColumn] = true;
				
				for(int i = 0; i < dy.length; i++)
				{
					int nextRow = currentRow + dy[i];
					int nextColumn = currentColumn + dx[i];
					
					// 범위 이탈은 방지
					if(nextRow < 0 || nextRow >= table.length || nextColumn < 0 || nextColumn >= table[currentColumn].length) continue;
					
					int changeCost = currentCost + table[nextRow][nextColumn].getHole();
					if(changeCost < table[nextRow][nextColumn].getCost()) 
					{
						table[nextRow][nextColumn].setCost(changeCost);
					}
					queue.add(table[nextRow][nextColumn]);
				}
			}
			
			System.out.println("#"+test_case+" "+table[endRow][endColumn].getCost());
			
/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}
