import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int input = Integer.parseInt(br.readLine());
    	
    	int increase = 1, behind = 1, limitLine = 1;
    	
    	boolean check = false;
    	
    	while(limitLine < input)
    	{
    		increase += 1;
    		limitLine += increase;
    		check = increase % 2 == 0 ? false : true;
    	}
    	
    	behind = limitLine - increase;
    	limitLine = 1;
    	
    	for(int i = behind + 1; i < input; i++)
    	{
    		increase -= 1;
    		limitLine += 1;
    	}
    	
    	if(check) bw.write(increase+"/"+limitLine+"\n");
    	else bw.write(limitLine+"/"+increase+"\n");
    	
    	bw.flush();
    }
}
