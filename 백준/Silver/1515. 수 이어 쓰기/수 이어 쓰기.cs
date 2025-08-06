using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            string n = Console.ReadLine();
            int count = 1, index = 0;
            while (index < n.Length)
            {
                for(int i = 0; i < count.ToString().Length && index < n.Length; i++) if (count.ToString()[i].ToString().Contains(n[index].ToString())) index++;
                count++;
            }
            Console.WriteLine(count - 1);
        }
    }
}