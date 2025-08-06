using System;
using System.Linq;

namespace Project
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            int size = int.Parse(Console.ReadLine());
            string temp = Console.ReadLine();
            string[] number = temp.Split(' ');
            
   
            if (size != number.Count()) return;
            int equal = int.Parse(Console.ReadLine());
            int count = 0;
            for(int i = 0; i < number.Length; i++)
            {
                if (number[i].Equals(equal.ToString())) count++;
            }
            Console.WriteLine(count);
        }
    }
}
