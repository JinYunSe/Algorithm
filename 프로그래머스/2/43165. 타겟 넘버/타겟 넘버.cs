using System;

public class Solution {

    //결과를 개수 변수
    public int count = 0;
    
    //필요한 매개변수
    //숫자 배열
    //타겟 넘버
    //현재 index
    //현재 숫자 결과
    public void DFS(int[] numbers, int target, int currentIndex, int currentResult)
    {
        if(numbers.Length == currentIndex) 
        {
            if(currentResult == target) count++;
            return;
        }
        DFS(numbers, target, currentIndex + 1, currentResult + numbers[currentIndex]);
        DFS(numbers, target, currentIndex + 1,currentResult - numbers[currentIndex]);
    }
    
    public int solution(int[] numbers, int target) 
    {
        DFS(numbers, target, 0, 0);
        return count;
    }
}