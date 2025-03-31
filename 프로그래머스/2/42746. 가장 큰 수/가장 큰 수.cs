using System;
using System.Linq;

public class Solution {    
    public string solution(int[] numbers) {
        
        // 정수 배열을 문자열 배열로 변환
        string[] stringNumbers = numbers.Select(element => element.ToString()).ToArray();
        
        // 정렬을 할 것인데
        // b + a로 두 요소를 연결한 문자열 숫자와
        // a + b로 두 요소를 연결한 문자열 숫자를
        // CompareTo로 비교 
        
        // b + a가 a + b 보다 크면 1, 작으면 -1, 같으면 0
        // => 내림 차순 정렬
        Array.Sort(stringNumbers, (a, b)=> (b + a).CompareTo(a + b));
        // add ) (a + b).CompareTo(b + a) => 오름 차순 정렬
        
        // 문자열 배열을 하나의 문자열로 붙이기
        string result = string.Join("", stringNumbers);
        
        // "00" 같은 문자열 배열이면 "0"으로 변경
        return result[0] == '0' ? "0" : result;
    }
}