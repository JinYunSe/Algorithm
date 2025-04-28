using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] sequence, int k) 
    {
        int left = 0, right = 0, sum = sequence[0];
        int minLength = int.MaxValue;
        int[] answer = new int[2];
        
        while(right < sequence.Length)
        {
            // 더한 값이 같은 경우
            if(sum == k)
            {
                // 연산에 사용된 최소 개수 비교
                if((right - left) < minLength)
                {
                    // 현재 최소 개수 저장 및 index 기록
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right;   
                }
                
                // 다른 sum == k 인 경우가 존재할 수 있기 때문에 왼쪽 범위 줄이기
                sum -= sequence[left++];
            }
            // sum이 k 보다 작을 경우
            else if(sum < k)
            {
                // 범위 늘리기
                right++;
                
                // 범위를 벗어나지 않게 하기 위한 조건문
                if (right < sequence.Length)
                    sum += sequence[right];
            }
            // sum이 클 경우 왼쪽에서 부터 범위 줄이기
            else
            {
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}