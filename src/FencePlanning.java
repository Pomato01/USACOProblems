import java.util.*;
import java.io.*;

public class FencePlanning {

    static Cow[] cows;
    static boolean[] visited;

    static class Cow
    {
        int x;
        int y;
        ArrayList<Integer> adjacent;
        public Cow(int x, int y)
        {
            this.x = x;
            this.y = y;
            adjacent = new ArrayList<Integer>();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("fenceplan.in"));
        PrintWriter out = new PrintWriter(new File("fenceplan.out"));
        int n = in.nextInt(), m = in.nextInt();
        cows = new Cow[n];
        for (int i = 0; i < n; i++)
        {
            cows[i] = new Cow(in.nextInt(), in.nextInt());
        }
        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            cows[a].adjacent.add(b);
            cows[b].adjacent.add(a);
        }
        visited = new boolean[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
                ans = Math.min(ans, dfs(i, cows[i].x, cows[i].x, cows[i].y, cows[i].y));
        }
        out.println(ans);
        out.close();
    }
    static int dfs(int i, int maxX, int minX, int maxY, int minY)
    {
        maxX = Math.max(cows[i].x, maxX);
        minX = Math.min(cows[i].x, minX);
        maxY = Math.max(cows[i].y, maxY);
        minY = Math.min(cows[i].y, minY);
        int a = 2 * (maxX - minX + maxY - minY);
        
        // bruh idk
        // nvm it worked
        
        visited[i] = true;
        for (int curr : cows[i].adjacent)
        {
            if (!visited[curr])
            {
                a = Math.max(dfs(curr, maxX, minX, maxY, minY), a);
            }
        }
        return a;
    }
}
