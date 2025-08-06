using System;

namespace CodingTest
{
    class Class1
    {
        static bool HanSu(int input)
        {
            bool check = false;
            if (input < 100) check = true;
            else if(input < 1000)
            {
                string temp = input.ToString();
                if (int.Parse(temp[0].ToString()) + int.Parse(temp[2].ToString()) == int.Parse(temp[1].ToString()) * 2) check = true;
            }
            return check;
        }
        static void Main(String[] args)
        {
            int input = int.Parse(Console.ReadLine());
            int count = 0;
            for(int i = 1; i <= input; i++)
            {
                if (HanSu(i) == true) count++;
            }
            Console.WriteLine(count);
        }
    }
}
