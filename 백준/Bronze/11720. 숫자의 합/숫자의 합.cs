using System;
namespace CodingTest
{
    class Class1
    {
        static void Main(String[] args)
        {
            int input = int.Parse(Console.ReadLine());
            string temp = Console.ReadLine();
            int sum = 0;
            for(int i = 0; i < input; i++)
            {
                sum += int.Parse(temp[i].ToString()); 
            }
            Console.WriteLine(sum);
        }
    }
}
