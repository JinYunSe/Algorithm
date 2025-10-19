import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		double A = Double.parseDouble(stz.nextToken());
		double B = Double.parseDouble(stz.nextToken());
		double V = Double.parseDouble(stz.nextToken());
		
		
		// 마지막 날은 밤에 미끄러지지 않기 때문에
		// 마지막에 한 번 올라가는 A를 미리 빼준다.
		V -= A;
		
		// 하루에 실제 올라가는 높이만큼 나눠 며칠이 걸리는지 계산
		V /= (A - B);
		
		// 소수점 올림과 마지막 날 1일을 더해줘 결과를 구한다.
		// (위에서 올라가는 계산함)
		System.out.println((int)Math.ceil(V)+1);
	}
}
