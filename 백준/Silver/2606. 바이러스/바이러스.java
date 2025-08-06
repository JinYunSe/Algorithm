import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static boolean[] check;//방문하면 했다고 표시하기
	static int count = 0;
	static int N;//컴퓨터 수
	static int M;//연결된 수
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		check = new boolean[N];
		visited = new boolean[N][N];
		for(int i = 0; i < M; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			visited[x-1][y-1] = true;
			visited[y-1][x-1] = true;
			//if 1과 2가 연결이면 1-2와 2-1이 연결 되어 있음을 의미
		}
		 System.out.println(virus(0));
	}
	public static int virus(int y) {
		check[y] = true;//방문했음을 지정
		if(y != 0) count++;//1은 이미 감염된 컴퓨터 컴퓨터라
		//1을 제외한 감염 컴퓨터 수 증가
		for(int x = 1; x < N;x++) {
			if((visited[x][y] == true) && check[x] == false) {
				virus(x);
			}
		}
		return count;
	}
}