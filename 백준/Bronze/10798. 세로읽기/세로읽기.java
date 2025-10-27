import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] temp = new String[5];
		

		int count = 0;
		int maxLength = 0;
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = br.readLine();
			if(maxLength < temp[i].length()) maxLength = temp[i].length();
		}
		
		count = maxLength * temp.length;
		
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].length() < maxLength) temp[i] += " ".repeat((maxLength - temp[i].length()));
		}
		
		String result = "";
		
		for(int i = 0; i < temp[0].length();i++)
		{
			for(int j = 0; j < temp.length; j++)
			{
				char word = temp[j].charAt(i);
				if(word == ' ') continue;
				result += temp[j].charAt(i);
			}
		}

		bw.write(result);
		bw.flush();
	}
}
