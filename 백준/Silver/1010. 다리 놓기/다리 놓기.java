import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int test_case = 1; test_case <= T; test_case++)
    	{
    		StringTokenizer stz = new StringTokenizer(br.readLine());
    		
    		// n과 m은 1 ~ 30의 정수라 int
    		int n = Integer.parseInt(stz.nextToken());
    		int m = Integer.parseInt(stz.nextToken());
    		
    		// 30 ~ 1까지 모두 곱할 경우 unsigned long을 초과하는 자료가 된다.
    		// unsigend long은 (0 ~ 2 * 9.22 * 10^18)의 범위로 부호가 없는 long 타입 언어이다.
    		// (long : -9.22 * 10^18 ~ 9.22 * 10^18)의 범위이다.
    		
    		// Java에서 unsigned long을 사용하기 위해선 BigInteger(클래스)를 사용해야 한다.
    		// BigInteger의 객체 생성 방법은
    		
    		// BigInteger num = new BigInteger("문자열로 표현된 숫자");
    		
    		// BigInteger num = BigInteger.ONE;
    		// 값이 1인 BigInteger형 변수
    		
    		// BigInteger num = BigInteger.TWO;
    		// 값이 2인 BigInteger형 변수
    		
    		// => 로 값을 생성할 수 있다.
    		
    		BigInteger numerator = BigInteger.ONE;
    		
    		// BigInteger의 사칙 연산은
    		// BigInteger.add() : 더하기
    		// BigInteger.subtract() : 빼기
    		// BigInteger.multiply() : 곱하기
    		// BigInteger.divide() : 나누기
    		// Biginteger.remainder() : 나머지 구하기
    		// 로 사친연산을 수행해야 한다.
    		
    		
    		// 문제 : 이 문제는 m개 중에서 n개를 뽑는 조합 문제이다.
    		
    		// 조합 공식
    		
    		/*
    		
    		(현재 우리 문제 m, n에 대한 정리)
    		 m! / (m - n)!(n)!
    		
    		 이다
    		*/
    		
    		//이를 조금만 정리하면
    		// n + 1 ~ m까지 곱한 값이 분자가 되는 것을 확인할 수 있다.
    	
    		for(int i = n + 1; i <= m; i++) numerator = numerator.multiply(BigInteger.valueOf(i));
    		
    		
    		BigInteger denominator = BigInteger.ONE;
    		
    		// 그리고, 분모는 1 ~ (m - n)까지의 곱한 값이 분모가 되는 것을 확인할 수 있다.
    		for(int i = 1; i <= (m - n); i++) denominator = denominator.multiply(BigInteger.valueOf(i));
    		
    		
    		// 마지막으로, 분자 / 분모로 결과를 도출할 수 있다.
    		bw.write(numerator.divide(denominator)+"\n");
    	}
    	bw.flush();
    }
}
