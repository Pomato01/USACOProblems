import java.util.*;
import java.io.*;

public class MoocastGold {
    public static class CDist implements Comparable<CDist>
    {
        int cow;
        int dist;
        public CDist(int cow, int dist)
        {
            this.cow = cow;
            this.dist = dist;
        }
        public int compareTo(CDist other)
        {
            return dist - other.dist;
        }
    }
    public static class Cow
    {
        int x;
        int y;
        CDist[] d;
        public Cow (int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[] visited;
    static Cow[] cows;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("moocast.in"));
        // get all the distances in an array then sort and when dfsing go through each possible distance and return once it works
        PrintWriter out = new PrintWriter(new File("moocast.out"));
        
        n = in.nextInt();
        cows = new Cow[n];
        for (int i = 0; i < n; i++)
        {
            cows[i] = new Cow(in.nextInt(), in.nextInt());
        }
        for (int i = 0; i < n; i++)
        {
            CDist[] temp = new CDist[n];
            for (int j = 0; j < n; j++)
            {
                temp[j] = new CDist(j, (int)Math.pow(cows[i].x - cows[j].x, 2) + (int)Math.pow(cows[i].y - cows[j].y, 2));
            }
            Arrays.sort(temp);
            cows[i].d = temp;
        }
        int a = 0;
        // for (int i = 0; true; i++)
        // {
        //     visited = new boolean[n];
        //     if (dfs(0, i) == n)
        //     {
        //         a = i;
        //         break;
        //     }
        // }
        visited = new boolean[n];
        int s = 2 * (int)Math.pow(25000, 2);
        a = binarySearch(0, s);
        out.println(a);
        out.close();
        
        
    }

    static int binarySearch (int start, int end)
    {
        int mid = (start + end)/2;
        if (end - start == 2)
        {
            visited = new boolean[n];
            boolean a = dfs(0, mid - 1) == n;
            visited = new boolean[n];
            boolean b = dfs(0, mid) == n;
            visited = new boolean[n];
            boolean c = dfs(0, mid + 1) == n;
            visited = new boolean[n];
            boolean d = dfs(0, mid + 2) == n;
            if (a)
                return mid - 1;
            if (b) 
                return mid;
            if (c)
                return mid + 1;
            else 
                return mid + 2;
        }
        if (end - start == 1)
        {
            visited = new boolean[n];
            boolean a = dfs(0, start) == n;
            if (a)
                return start;
            else 
                return end;
        }
        visited = new boolean[n];
        if (dfs(0, mid) == n)
            return binarySearch(start, mid);
        else 
            return binarySearch(mid + 1, end);
    }

    static int dfs (int i, int x)
    {
        visited[i] = true;
        int r = 1;
        for (int j = 0; j < cows[i].d.length; j++)
        {
            if (cows[i].d[j].dist > x)
                break;
            if (!visited[cows[i].d[j].cow])
                r += dfs(cows[i].d[j].cow, x);
        }
        return r;
    }
}
