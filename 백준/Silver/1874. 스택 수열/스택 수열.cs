using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] want = new int[n];
            for (int i = 0; i < want.Length; i++) want[i] = int.Parse(Console.ReadLine());
            int num = 1, index = 0;
            StringBuilder stringBuilder = new StringBuilder();
            Stack<int> stack = new Stack<int>();
            stack.Push(num);
            stringBuilder.Append("+\n");
            while (index != want.Length)
            {
                while (true)
                {
                    if (stack.Count != 0 && want[index] == stack.Peek())
                    {
                        int temp = stack.Pop();
                        stringBuilder.Append("-\n");
                        num = Math.Max(temp, num);
                        break;
                    }
                    else
                    {
                        stack.Push(++num);
                        stringBuilder.Append("+\n");
                    }
                    if(num > n)
                    {
                        Console.WriteLine("NO");
                        return;
                    }
                }
                index++;
            }
            Console.WriteLine(stringBuilder.ToString());
        }
    }
}