import java.util.*;
import java.io.*;

public class TheGreatRevegetation {
    static class Pair
    {
        char type;
        int val;
        public Pair(char type, int val)
        {
            this.type = type;
            this.val = val;
        }
    }
    static class Node
    {
        int color;
        ArrayList<Pair> f;
        public Node(int color)
        {
            this.color = color;
            f = new ArrayList<>();
        }
    }
    static int a;
    static boolean impossible;
    static boolean[] visited;
    static Node[] p;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("revegetate.in"));
        PrintWriter out = new PrintWriter(new File("revegetate.out"));
        int n = in.nextInt(), m = in.nextInt();
        
        impossible = false;
        visited = new boolean[n];
        p = new Node[n];
        for (int i = 0; i < n; i++)
        {
            p[i] = new Node(0);
        }
        for (int i = 0; i < m; i++)
        {
            char t = in.next().charAt(0);
            int x = in.nextInt() - 1, y = in.nextInt() - 1;
            p[x].f.add(new Pair(t, y));
            p[y].f.add(new Pair(t, x));
        }
        int a = n;
        for (int i = 0; i < n; i++)
        {
            if (visited[i])
                a--;
            dfs(i);
        }
        if (impossible)
            out.print("0");
        else 
        {
            out.print("1");
            for (int i = 0; i < a; i++)
            {
                out.print("0");
            }
        }
        out.close();
    }

    static void dfs(int i)
    {
        visited[i] = true;
        if (p[i].color == 0)
            p[i].color = 1;
        for (Pair j : p[i].f)
        {
            if (j.type == 'S')
            {
                if (visited[j.val] && p[j.val].color != p[i].color)
                {
                    impossible = true;
                }
                if (!visited[j.val])
                {
                    p[j.val].color = p[i].color;
                    dfs(j.val);
                }
            }
            else 
            {
                if (visited[j.val] && p[j.val].color == p[i].color)
                {
                    impossible = true;
                }
                if (!visited[j.val])
                {
                    if (p[i].color == 1)
                        p[j.val].color = 2;
                    else 
                        p[j.val].color = 1;
                    dfs(j.val);
                }
            }
        }
    }
}
