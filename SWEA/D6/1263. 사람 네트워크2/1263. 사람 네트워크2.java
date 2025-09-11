import java.io.*;
import java.util.*;
 
public class Solution {
     
    public static class Node
    {
        int endNode;
        int cost;
         
        public Node(int endNode, int cost)
        {
            this.endNode = endNode;
            this.cost = cost;
        }
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
             
            int size = Integer.parseInt(stz.nextToken());
             
            int[][] dist = new int[size][size];
             
            for(int i = 0; i < dist.length; i++)
            {
                for(int j = 0; j < dist[i].length; j++)
                {
                    if(i == j) dist[i][j] = Integer.parseInt(stz.nextToken());
                    else dist[i][j] = Integer.parseInt(stz.nextToken()) == 0 ? Integer.MAX_VALUE : 1;
                }
            }
             
            for(int k = 0; k < dist.length; k++)
            {
                for(int i = 0; i < dist.length; i++)
                {
                    for(int j = 0; j < dist[i].length; j++)
                    {
                        if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
             
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < dist.length; i++)
            {
                int sum = 0;
                for(int j = 0; j < dist[i].length; j++)
                {
                    sum += dist[i][j];
                }
                min = Math.min(min, sum);
            }
            bw.write("#"+test_case+" "+min+"\n");
        }
        bw.flush();
    }
}