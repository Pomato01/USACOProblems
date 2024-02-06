import java.util.*;
import java.io.*;

public class WDTCCTR3 {
    static class Pair implements Comparable<Pair>
    {
        int x, y;
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair other)
        {
            if (other.x == x && other.y == y)
                return 0;
            else if (other.x == x)
                return y - other.y;
            return x - other.x;
        }
        @Override
        public int hashCode()
        {
            return (x * n) + y;
        }
        @Override
        public String toString()
        {
            return "(" + x + ", " + y + ")";
        }
        @Override
        public boolean equals(Object other)
        {
            Pair o = (Pair)other;
            return o.x == x && o.y == y;
        }
    }
    static int n;
    static boolean[][] visited;
    static boolean[][] cow;
    static HashSet<Pair>[][] roads;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("countcross.in"));
        PrintWriter out = new PrintWriter(new File("countcross.out"));
        n = in.nextInt();
        int k = in.nextInt(), r = in.nextInt();

        ArrayList<Integer> groups = new ArrayList<Integer>();
        roads = new HashSet[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                roads[i][j] = new HashSet<Pair>();
            }
        }
        for (int i = 0; i < r; i++)
        {
            int a = in.nextInt() - 1, b = in.nextInt() - 1, c = in.nextInt() - 1,
                d = in.nextInt() - 1;
            roads[a][b].add(new Pair(c, d));
            roads[c][d].add(new Pair(a, b));
        }
        cow = new boolean[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < k; i++)
        {
            cow[in.nextInt() - 1][in.nextInt() - 1] = true;
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int c = dfs(i, j);
                if (c != 0)
                    groups.add(c);
            }
        }
        
        int a = 0;
        for (int w : groups)
        {
            a += w * (k - w);
        }
        out.println(a/2);
        out.close();
        // for (boolean[] x : visited)
        // {
        //     System.out.println(Arrays.toString(x));
        // }
        // for (boolean[] y : cow)
        // {
        //     System.out.println(Arrays.toString(y));
        // }
        // for (HashSet[] z : roads)
        // {
        //     System.out.println(Arrays.toString(z));
        // }
        // System.out.println(Arrays.toString(groups.toArray()));
        // System.out.println(roads[2][2].contains(new Pair(1, 2)));
    }
    static int dfs(int i, int j)
    {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j])
            return 0;
        visited[i][j] = true;
        int a = 0;
        if (cow[i][j])
            a = 1;
        if (!roads[i][j].contains(new Pair(i - 1, j)))
            a += dfs(i - 1, j);
        if (!roads[i][j].contains(new Pair(i + 1, j)))
            a += dfs(i + 1, j);
        if (!roads[i][j].contains(new Pair(i, j - 1)))
            a += dfs(i, j - 1);
        if (!roads[i][j].contains(new Pair(i, j + 1)))
            a += dfs(i, j + 1);
        return a;
    }
}
