import java.util.*;
import java.io.*;

public class Amogus {

    static class Pair
    {
        int x, y;
        public Pair(int x, int y)
        {
            this.x = x; 
            this.y = y;
        }
        @Override
        public String toString()
        {
            return "[" + x + ", " + y + "]";
        }
    }

    static ArrayList<Integer>[] s;
    static ArrayList<Integer>[] o;
    static boolean[] visited;
    static int[] L;
    static boolean impossible;
    static Pair[] a;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt(); 
        for (int z = 0; z < t; z++)
        {
            int n = in.nextInt(), q = in.nextInt();
            s = new ArrayList[n];
            for (int i = 0; i < n; i++){s[i] = new ArrayList<>();}
            o = new ArrayList[n];
            for (int i = 0; i < n; i++){o[i] = new ArrayList<>();}
            visited = new boolean[n];
            L = new int[n];
            a = new Pair[n];
            impossible = false;

            for (int i = 0; i < q; i++)
            {
                int type = in.nextInt(), a = in.nextInt() - 1, b = in.nextInt() - 1;
                if (type == 1)
                {
                    o[a].add(b);
                    o[b].add(a);
                }
                else
                {
                    s[a].add(b);
                    s[b].add(a);
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++)
            {
                a[i] = dfs(i);
            }
            for (int i = 0; i < n; i++)
            {
                ans += Math.max(a[i].x, a[i].y);
            }
            if (impossible)
                System.out.println(-1);
            else 
                System.out.println(ans);
        }
    }

    static Pair dfs(int i)
    {
        if (visited[i])
            return new Pair(0, 0);
        if (s[i].size() == 0 && o[i].size() == 0)
            return new Pair(1, 0);
        
        // temp has values of self plus connected, unvisited nodes
        visited[i] = true;
        Pair temp = new Pair(0, 0);
        if (L[i] == 0)
            L[i] = 1;
        if (L[i] == 1)
            temp.x++;
        else 
            temp.y++;
        for (int c : s[i])
        {
            if (visited[c] && L[c] != L[i])
                impossible = true;
            L[c] = L[i];
            
            if (!visited[c])
            {
                Pair t = dfs(c);
                temp.x += t.x;
                temp.y += t.y;
            }
        }
        for (int c : o[i])
        {
            if (visited[c] && L[c] == L[i])
                impossible = true;
            
            if (L[i] == 1)
                L[c] = 2;
            else 
                L[c] = 1;

            if (!visited[c])
            {
                Pair t = dfs(c);  
                temp.x += t.x;
                temp.y += t.y;
            }
        }
        return temp;
    }
}
