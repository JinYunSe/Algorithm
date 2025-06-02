using System;
using System.Linq;
using System.Collections.Generic;

public class Solution 
{
    public int solution(string[,] book_time) 
    {
        List<(TimeSpan checkIn, TimeSpan checkOut)> timeList = new List<(TimeSpan checkIn, TimeSpan checkOut)>();
        
        for(int i = 0; i < book_time.GetLength(0); i++)
        {
            TimeSpan checkIn = TimeSpan.Parse(book_time[i, 0]), checkOut = TimeSpan.Parse(book_time[i, 1]) + TimeSpan.FromMinutes(10);
            timeList.Add((checkIn, checkOut));
        }
        
        timeList = timeList.OrderBy(X=> X.checkIn).ToList();
        
        List<TimeSpan> roomList = new List<TimeSpan>();
        
        foreach((TimeSpan checkIn, TimeSpan checkOut) val in timeList)
        {
            int room = roomList.FindIndex(element => element <= val.checkIn);
            if(room == -1) roomList.Add(val.checkOut);
            else roomList[room] = val.checkOut;
        }
        
        return roomList.Count;
    }
}