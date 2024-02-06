import java.util.*;
import java.io.*;

public class WormholeSort {
    static class Dest implements Comparable<Dest>
    {
        int d;
        int w;
        public Dest(int d, int w)
        {
            this.d = d;
            this.w = w;
        }
        public int compareTo(Dest other)
        {
            return w - other.w;
        }
        @Override
        public String toString()
        {
            return "(" + d + " , " + w + ")";
        }
    }
    static int[] order;
    static int n;
    static int[] ws; 
    static boolean[] visited;
    static ArrayList<Dest>[] connections;
    static int[] findU;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("wormsort.in"));
        PrintWriter out = new PrintWriter(new File("wormsort.out"));
        n = in.nextInt();
        int m = in.nextInt();
        connections = new ArrayList[n];
        ws = new int[m];
        order = new int[n];
        for (int i = 0; i < n; i++)
        {
            order[i] = in.nextInt() - 1;
            connections[i] = new ArrayList<Dest>();
        }
        int a, b, w;
        for (int i = 0; i < m; i++)
        {
            a = in.nextInt() - 1;
            b = in.nextInt() - 1;
            w = in.nextInt();
            connections[a].add(new Dest(b, w));
            connections[b].add(new Dest(a, w));
            ws[i] = w;
        }
        Arrays.sort(ws);
        // for (int i = 0; i < n; i++)
        // {
        //     Collections.sort(connections[i]);
        // }
        if (sorted(order))
            out.println(-1);
        else
            out.println(binarySearch(0, m - 1));
        out.close();
    }
    static boolean sorted (int[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }
    static int binarySearch(int a, int b)
    {
        if (b - a == 1)
        {
            if (works(ws[a]))
            {
                return ws[a];
            }
            return ws[b];
        }
        int mid = (a + b)/2;
        if (works(ws[mid]))
            return binarySearch(mid, b);
        else 
            return binarySearch(a, mid);
    }
    
    static boolean works(int w)
    {
        visited = new boolean[n];
        findU = new int[n];
        for (int i = 0; i < n; i++)
        {
            dfs(i, i, w);
        }
        //System.out.println(w + "\n" + Arrays.toString(findU));
        for (int i = 0; i < n; i++)
        {
            if (findU[i] != findU[order[i]])
                return false;
        }
        return true;
    }

    static void dfs(int i, int l, int w)
    {
        if (visited[i])
            return;
        visited[i] = true;
        findU[i] = l;
        if (w == 3)
            System.out.println(l + " " + Arrays.toString(visited));
        for (int x = 0; x < connections[i].size(); x++)
        {
            if (connections[i].get(x).w >= w && !visited[connections[i].get(x).d])
            {
                dfs(connections[i].get(x).d, l, w);
            }
        }
    }
}


