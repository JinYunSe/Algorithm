import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int subin;
	static int brother;
	static int[] visited = new int[100001];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		subin = scanner.nextInt();
		brother = scanner.nextInt();
		scanner.close();
		
		if(subin >= brother) {
			System.out.println(subin- brother);
			return; // 실행 종료
		}//조금이라도 더 빠르게 결과를 찾기 위해 추가
		Queue<Integer> q = new LinkedList<>();
		q.add(subin);
		visited[subin] = 1;
		
		while(!q.isEmpty()) {
			subin = q.poll();
			if(subin == brother) {
				System.out.println(visited[subin] -1);
				break;
			}
			if(subin + 1 <= 100000 && visited[subin+1] == 0) {
				q.add(subin+1);
				visited[subin+1] = visited[subin] + 1;
			}
			if(subin-1 >= 0 && visited[subin-1] == 0) {
				q.add(subin-1);
				visited[subin-1] = visited[subin] + 1;
			}
			if(subin * 2 <= 100000 && visited[subin * 2] == 0) {
				q.add(subin * 2);
				visited[subin * 2] = visited[subin] + 1;
			}
		}
	}
}