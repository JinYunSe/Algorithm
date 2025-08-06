using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        private static int SearchFront(int front, List<int> queue)
        {
            int[] temp = new int[front];
            for (int i = 0; i < front; i++) temp[i] = queue[i];
            for (int i = 0; i < front; i++) queue.RemoveAt(0);
            for (int i = 0; i < front; i++) queue.Add(temp[i]);
            queue.RemoveAt(0);
            return front;
        }
        private static int SearchLast(int last, List<int> queue)
        {
            int start = queue.Count;
            int[] temp = new int[start - last];
            for (int i = 0; i < temp.Length; i++) temp[i] = queue[queue.Count - i - 1];
            for(int i = start - 1; i >= last; i--) queue.RemoveAt(i);
            for (int i = 0; i < temp.Length - 1; i++) queue.Insert(0, temp[i]);
            return queue.Count - last + 1;
        }
        public static void Main(string[] args)
        {
            int[] N = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            List<int> queue = new List<int>();
            for (int i = 1; i <= N[0]; i++)
            {
                queue.Add(i);
            }
            int[] search_num = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int count = 0;
            for (int i = 0; i < search_num.Length; i++)
            {
                int front = 0, last = queue.Count - 1, temp = 0;
                for (; front < queue.Count; front++) if (search_num[i] == queue[front]) break;
                for (; last >= 0; last--) if (search_num[i] == queue[last]) break;
                if (front >= queue.Count - last) count += SearchLast(last, queue);
                else if (front < queue.Count - last) count += SearchFront(front, queue);
            }
            Console.WriteLine(count);
        }
    }
}