import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true)
		{
			StringTokenizer stz = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(stz.nextToken());
			int num2 = Integer.parseInt(stz.nextToken());
			
			if(num1 == 0 && num2 == 0) break;
			
			boolean check = true;
			if(num1 >= num2) 
			{
				check = num1 % num2 == 0;
				if(check) bw.write("multiple\n");
			}
			else 
			{
				check = num2 % num1 == 0;	
				if(check) bw.write("factor\n");
			}	
			
			if(!check) bw.write("neither\n");
		}

		bw.flush();
	}
}
