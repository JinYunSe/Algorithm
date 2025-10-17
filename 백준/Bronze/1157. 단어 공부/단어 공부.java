import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 문자열 입력에 따른 문자 전체를 대문자로 변형
        String input = br.readLine().toUpperCase();
        
        // A ~ Z 까지는 총 26개(알아두면 좋아요)
        
        // 단어의 횟수 증가용 배열
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) 
        {
            int temp = input.charAt(i);
            
            // A : 65(외우면 좋음)
            // a : 97(외우면 좋음)
            // Z : 65 + 25 => 90
            // A, a만 외우면 Z, z는 A, a에서 25만 더하면 됨
            
            // 해당 단어 - 65 = 0 ~ 25까지의 정수가 된다.
            // => count의 index로 활용할 수 있게 됨
            for (int j = temp - 'A'; j <= 'Z'; j++) 
            {
            	
            	// 등장한 단어의 횟수 증가
                if ((temp - 'A') == j) count[j]++;
            }
        }

        // 최대 등장 횟수 저장용 변수
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < count.length; i++) 
        {
            max = Math.max(max,count[i]);
        }

        // 최대 단어 여러 개인지 확인
        boolean check = false;
        // 단어 저장용 변수
        char word  = ' ';
        
        for (int i = 0; i < count.length; i++)
        {
        	// 등장 횟수 단어가 최대 횟수이면
            if (max == count[i]) 
            {
            	// 최대 단어가 여러 개가 아니라면
            	if(!check)
            	{
            		// 해당 단어 저장
            		// i : 0 ~ 25
            		// A : 65
            		// i + A : 0 ~ 90
            		// 0 ~ 90 : A ~ Z의 단어
            		word = (char)(i + 'A');
            		
            		// 다음 등장 단어를 위해 check 변경
            		check = true;
            	}
            	// 최대 단어가 여러 번 등장
            	else
            	{
            		// ?로 변경
            		word = '?';
            		break;
            	}
            }
        }
        
        bw.write(word);
        bw.flush();
    }
}
