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
    		
    		int n = Integer.parseInt(stz.nextToken());
    		int m = Integer.parseInt(stz.nextToken());
    		
    		BigInteger numerator = BigInteger.ONE;
    		
    		for(int i = n + 1; i <= m; i++)
    		{
    			numerator = numerator.multiply(BigInteger.valueOf(i));
    		}
    		
    		BigInteger denominator = BigInteger.ONE;
    		
    		for(int i = 1; i <= (m - n); i++)
    		{
    			denominator = denominator.multiply(BigInteger.valueOf(i));
    		}
    		
    		
    		bw.write(numerator.divide(denominator)+"\n");
    	}
    	bw.flush();
    }
}
