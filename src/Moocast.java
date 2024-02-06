import java.util.*;
import java.io.*;

public class Moocast {
    static class Cow
    {
        int x;
        int y;
        int p;
        ArrayList<Integer> connected;
        public Cow (int x, int y, int p)
        {
            this.x = x;
            this.y = y;
            this.p = p;
            connected = new ArrayList<>();
        }
        boolean reaches(Cow other)
        {
            return Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2) <= Math.pow(p, 2);
        }
    }
    static Cow[] cows;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("moocast.in"));
        PrintWriter out = new PrintWriter (new File("moocast.out"));
        
        int n = in.nextInt();
        cows = new Cow[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            int x = in.nextInt(), y = in.nextInt(), p = in.nextInt();
            cows[i] = new Cow(x, y, p);
            for (int j = 0; j < i; j++)
            {
                if (cows[j].reaches(cows[i]))
                    cows[j].connected.add(i);
                if (cows[i].reaches(cows[j]))
                    cows[i].connected.add(j);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++)
        {
            visited = new boolean[n];
            max = Math.max(dfs(i), max);
        }
        out.println(max);
        out.close();
    }

    static int dfs(int a)
    {
        int r = 1;
        visited[a] = true;
        for (int i : cows[a].connected)
        {
            if (!visited[i])
                r += dfs(i);
        }
        return r;
    }
}
