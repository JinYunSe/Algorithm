using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<string> input = new List<string>();
            for (int i = 0; i < n; i++) input.Add(Console.ReadLine());
            input.Sort(compare);
            for (int i = 0; i < input.Count; i++) Console.WriteLine(input[i]);
        }

        private static int compare(string left, string right)
        {
            if (left.Length != right.Length) return left.Length.CompareTo(right.Length);
            int[] sum = new int[2];
            for(int i = 0; i < left.Length; i++)
            {
                int convert = 90;
                if (Char.IsDigit(left[i])) sum[0] += int.Parse(left[i].ToString());
                if (Char.IsDigit(right[i])) sum[1] += int.Parse(right[i].ToString());
            }
            if (sum[0] > sum[1]) return 1;
            else if(sum[0] < sum[1])return -1;
            return left.CompareTo(right);
        }
    }
}