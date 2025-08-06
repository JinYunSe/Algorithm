using System;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            StringBuilder stringBuilder = new StringBuilder();
            int n = int.Parse(Console.ReadLine());
            for(int i = 0; i < n; i++)
            {
                double[] circle = Array.ConvertAll(Console.ReadLine().Split(), double.Parse);
                
                double p2p_len = (double)Math.Sqrt(Math.Pow(circle[3] - circle[0], 2) + Math.Pow(circle[4] - circle[1], 2));
                double sum = circle[2] + circle[5];
                double minus = Math.Abs(circle[2] - circle[5]);
                if (p2p_len != 0)
                {
                    if ((sum == p2p_len) || (minus == p2p_len)) stringBuilder.Append("1\n");
                    else if ((sum < p2p_len) || (minus > p2p_len)) stringBuilder.Append("0\n");
                    else stringBuilder.Append("2\n");
                }
                else
                {
                    if (circle[2] == circle[5]) stringBuilder.Append("-1\n");
                    else stringBuilder.Append("0\n");
                }
            }
            Console.WriteLine(stringBuilder.ToString());
        }
    }
}