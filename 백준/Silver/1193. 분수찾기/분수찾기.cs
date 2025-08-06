using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            int increase = 1, behind = 1,limit_line = 1;
            bool check = false;
            while (limit_line < input)
            {
                increase += 1;
                limit_line += increase;
                check = increase % 2 == 0 ? false : true;
            }
            behind = limit_line - increase;
            limit_line = 1;
            for (int i = behind + 1; i < input; i++)
            {
                increase -= 1;
                limit_line += 1;
            }
            if (check) Console.WriteLine(increase + "/" + limit_line);
            else Console.WriteLine(limit_line + "/" + increase);
            
        }
    }
}
