using System;
using System.Linq;
using System.Collections.Generic;

public class Solution 
{
    public int solution(int n, int[] lost, int[] reserve) 
    {
        List<int> realLost = lost.Where(element => !reserve.Contains(element)).OrderBy(element=>element).ToList();
        List<int> realReserve = reserve.Where(element => !lost.Contains(element)).OrderBy(element=>element).ToList();
        
        int result = n - realLost.Count;
        
        foreach (int lostPerson in realLost)
        {
            // 앞 번호 학생이 여벌 체육복을 가지고 있는지 확인
            if (realReserve.Contains(lostPerson - 1))
            {
                realReserve.Remove(lostPerson - 1);
                result++;
                continue;
            }
            // 뒷 번호 학생이 여벌 체육복을 가지고 있는지 확인
            else if (realReserve.Contains(lostPerson + 1))
            {
                realReserve.Remove(lostPerson + 1);
                result++;
                continue;
            }
        }
        
        return result;
    }
}