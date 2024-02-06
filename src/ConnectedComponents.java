import java.util.*;
import java.io.*;

public class ConnectedComponents {
    static ArrayList<Integer>[] nc;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); int m = in.nextInt();
        nc = new ArrayList[n];
        visited = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            if (nc[a] == null)
                nc[a] = new ArrayList<>();
            if (nc[b] == null)
                nc[b] = new ArrayList<>();
            nc[a].add(b);
            nc[b].add(a);
        }
        for (int i = 0; i < n; i++)
        {
            int temp = dfs(i);
            if (temp != 0)
                ans.add(temp);
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for (int w : ans)
            System.out.print(w + " ");
    }

    static int dfs(int i)
    {
        if (visited[i])
            return 0;
        visited[i] = true;
        int temp = 1;
        for (int j = 0; j < n; j++)
        {
            if (connected(i, j, 0, nc[i].size() - 1))
                temp += dfs(j);
        }
        return temp;
    }

    static boolean connected(int a, int b, int s, int e){return !nConnected(a, b, s, e);}

    static boolean nConnected(int a, int b, int s, int e)
    {
        if (nc[a] == null || nc[b] == null)
            return true;
        if (s == e)
            return nc[a].get(s) == b;
        if (e - s == 1)
            return nc[a].get(s) == b || nc[a].get(e) == b;
        int mid = (e + s) / 2;
        if (nc[a].get(mid) == b)
            return true;
        else if (nc[a].get(mid) > b)
            return nConnected(a, b, s, mid - 1);
        else
            return nConnected(a, b, mid + 1, e);
    }
}
