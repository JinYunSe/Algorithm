using System;
using System.Linq;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            StringBuilder stringBuilder = new StringBuilder();
            while (true)
            {
                bool check = false;
                int[] temp = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                if (temp.Sum() == 0) break;
                Array.Sort(temp);
                string str_temp = temp[2] == Math.Sqrt(Math.Pow(temp[0], 2) + Math.Pow(temp[1], 2)) ? "right":"wrong";
                stringBuilder.Append(str_temp + "\n");
            }
            Console.Write(stringBuilder.ToString());
        }
    }
}
