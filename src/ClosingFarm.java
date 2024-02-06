import java.util.*;
import java.io.*;

public class ClosingFarm {
    static class Farm 
    {
        ArrayList<Integer> connected;
        public Farm()
        {
            connected = new ArrayList<Integer>();
        }
    }
    static int count;
    static int n;
    static Farm[] farms;
    static boolean[] open;
    static boolean[] visited;
    static int size;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("closing.in"));
        PrintWriter out = new PrintWriter (new File("closing.out"));
        n = in.nextInt();
        int m = in.nextInt();
        farms = new Farm[n];
        open = new boolean[n];
        visited = new boolean[n];
        int[] order = new int[n];
        for (int i = 0; i < n; i++)
        {
            farms[i] = new Farm();
            open[i] = true;
        }
        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            farms[a].connected.add(b);
            farms[b].connected.add(a);
        }
        for (int i = 0; i < n; i++)
        {
            order[i] = in.nextInt() - 1;
        }
        int last = order[n-1];
        for (int i = 0; i < n; i++)
        {
            visited = new boolean[n];
            size = n - i;
            count = 0;
            if (dfs(last))
                out.println("YES");
            else
                out.println("NO");
            open[order[i]] = false;
        }
        out.close();
    }

    static boolean dfs(int a)
    {
        if (!visited[a])
            count++;
        visited[a] = true;
        if (count >= size)
            return true;
        for (int i : farms[a].connected)
        {
            if(!visited[i] && open[i])
            {
                if (dfs(i))
                    return true;
            }
        }
        return false;
    }
}
