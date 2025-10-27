import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stz = new StringTokenizer(br.readLine());
		double[] num = new double[stz.countTokens()];
		
		int index = 0;
		while (stz.hasMoreTokens()) {
			num[index++] = Double.parseDouble(stz.nextToken());
		}
		
		// 연립방정식 2개가 주어진다.
		// ┌────────────────────────────┐
		// │  a1*x + b1*y = c1          │
		// │  a2*x + b2*y = c2          │
		// └────────────────────────────┘
		//
		// 여기서 a1, b1, c1, a2, b2, c2는 입력으로 주어진 상수들이다.
		double a1 = num[0], b1 = num[1], c1 = num[2];
		double a2 = num[3], b2 = num[4], c2 = num[5];

		// ─────────────────────────────
		// [1] 행렬식(Determinant) 계산
		// ─────────────────────────────
		// |a1 b1|
		// |a2 b2|   → det = a1*b2 - a2*b1
		//
		// det이 0이 아니면 해가 유일하게 존재한다.
		double det = a1 * b2 - a2 * b1;

		// ─────────────────────────────
		// [2] 크래머 공식 (Cramer's Rule)
		// ─────────────────────────────
		// x = ( |c1 b1| / |a1 b1| ) = (c1*b2 - c2*b1) / det
		//     ( |c2 b2|   |a2 b2| )
		//
		// y = ( |a1 c1| / |a1 b1| ) = (a1*c2 - a2*c1) / det
		//     ( |a2 c2|   |a2 b2| )
		double x = (c1 * b2 - c2 * b1) / det;
		double y = (a1 * c2 - a2 * c1) / det;

		// ─────────────────────────────
		// [3] 문제 조건상 해는 항상 정수
		// ─────────────────────────────
		bw.write((int)x + " " + (int)y);

		bw.flush();
	}
}
