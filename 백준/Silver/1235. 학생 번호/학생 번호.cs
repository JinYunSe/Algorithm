using System;

namespace CodingTest
{
    class Class1
    {
        private static bool CheckNum(string[] temp)
        {
            for(int i = 0; i < temp.Length - 1; i++)
            {
                for(int j = i + 1; j < temp.Length; j++)
                {
                    if (temp[i].Equals(temp[j])) return false;
                }
            }
            return true;
        }
        public static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            string[] student = new string[num];
            string[] temp = new string[num];
            for (int i = 0; i < num; i++) student[i] = Console.ReadLine();
            for(int i = student[0].Length - 1; i >= 0; i--)
            {
                for(int j = 0; j < student.Length; j++)
                {
                    temp[j] += student[j][i];
                }
                if (CheckNum(temp))
                {
                    Console.WriteLine(temp[0].Length);
                    return;
                }
            }
        }
    }
}