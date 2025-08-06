using System;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            StringBuilder stringBuilder = new StringBuilder();
            int[] num = new int[count];
            for (int i = 0; i < count; i++) num[i] = int.Parse(Console.ReadLine());
            Array.Sort(num);
            for (int i = 0; i < count; i++) stringBuilder.Append(num[i] + "\n");
            Console.WriteLine(stringBuilder.ToString());
        }
    }
}
