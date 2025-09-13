import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] w = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                w[i] = Integer.parseInt(st.nextToken());
                v[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[K + 1];

            for (int i = 0; i < n; i++) {
                int wi = w[i], vi = v[i];
                for (int c = K; c >= wi; c--) {
                    dp[c] = Math.max(dp[c], dp[c - wi] + vi);
                }
            }

            sb.append('#').append(tc).append(' ').append(dp[K]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
