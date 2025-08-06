import java.io.*;
import java.util.*;

public class Main {
    public static class UnionSet {
        int[] parent;
        int[] rank;
        int[] size;

        public UnionSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void unionRank(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
                size[rootX] += size[rootY];
            }
        }

        public void unionSize(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return;
            if (size[rootX] >= size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(rb.readLine());
        int planCount = Integer.parseInt(rb.readLine());
        UnionSet unionSet = new UnionSet(cityCount);
        boolean[][] canVisited = new boolean[cityCount][cityCount];
        for (int i = 0; i < cityCount; i++) {
            String[] temp = rb.readLine().split(" ");
            for (int j = 0; j < cityCount; j++) {
                canVisited[i][j] = temp[j].equals("1");
            }
        }
        for (int i = 0; i < cityCount; i++) {
            for (int j = 0; j < cityCount; j++) {
                if (canVisited[i][j]) {
                    unionSet.unionRank(i + 1, j + 1);
                }
            }
        }
        int[] checkConnection = Arrays.stream(rb.readLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
        int root = unionSet.find(checkConnection[0]);
        boolean allConnected = true;
        for (int i = 1; i < checkConnection.length; i++) {
            if (unionSet.find(checkConnection[i]) != root) {
                allConnected = false;
                break;
            }
        }
        System.out.println(allConnected ? "YES" : "NO");
    }
}
