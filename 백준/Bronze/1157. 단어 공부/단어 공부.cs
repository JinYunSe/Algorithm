using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToUpper();
            int[] count = new int[26];
            int temp;
            for (int i = 0; i < input.Length; i++)
            {
                temp = Convert.ToInt16(input[i]);
                for(int j =  temp - 65; j <= 90; j++)
                {
                    if ((temp - 65) == j) count[j]++;
                } 
            }
            int max = 0;
            for(int i = 0; i < count.Length; i++)
            {
                if (max < count[i]) max = count[i];
            }
            int check = 0, index = 0;
            for(int i = 0; i < count.Length; i++)
            {
                if (max == count[i])
                {
                    check++;
                    index = i;
                }
            }
            if (check >= 2) Console.WriteLine("?");
            else Console.WriteLine(Convert.ToChar(index + 65));
        }
    }
}
