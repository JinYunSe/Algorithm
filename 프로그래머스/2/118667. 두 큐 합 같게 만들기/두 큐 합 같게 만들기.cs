using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] array1, int[] array2) 
    {
        Queue<int> queue1 = new Queue<int>(array1);
        Queue<int> queue2 = new Queue<int>(array2);
        
        long sum1 = array1.Sum(x => (long)x);
        long sum2 = array2.Sum(x => (long)x);
        
        long total = sum1 + sum2;
        
        if(total % 2 == 1) return -1;
        
        total /= 2;
        
        int count = 0, len = (array1.Length + array2.Length) * 3;
        
        while(count <= len)
        {
            if(sum1 == total) return count;
            
            if(sum1 > total)
            {
                if(queue1.Count == 0) return -1;
                
                int temp = queue1.Dequeue();
                sum1 -= temp;
                
                sum2 += temp;
                queue2.Enqueue(temp);
            }
            else
            {
                if(queue2.Count == 0) return -1;
                
                int temp = queue2.Dequeue();
                sum2 -= temp;
                
                sum1 += temp;
                queue1.Enqueue(temp);
            }
            
            count++;
        }
        
        return -1;
    }
}