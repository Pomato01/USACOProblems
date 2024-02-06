import java.util.*;

public class BuildingTeams {
    static class Node
    {
        ArrayList<Integer> friends;
        int color;
        public Node(int color)
        {
            this.color = color;
            friends = new ArrayList<Integer>();
        }
    }
    static Node[] p;
    static boolean[] visited;
    static boolean impossible;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        p = new Node[n];
        visited = new boolean[n];
        impossible = false;

        for (int i = 0; i < n; i++)
        {
            p[i] = new Node(0);
        }
        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            p[a].friends.add(b);
            p[b].friends.add(a);
        }
        for (int i = 0; i < n; i++)
        {
            if (p[i].color == 0)
                p[i].color = 1;
            dfs(i);
        }

        if (impossible)
            System.out.print("IMPOSSIBLE");
        else 
        {
            for (Node w : p)
            {
                System.out.print(w.color + " ");
            }
        }
    }

    static void dfs(int i)
    {
        visited[i] = true;
        for (int friend : p[i].friends)
        {
            if (p[friend].color == p[i].color)
            {
                impossible = true;
            }
            else if (!visited[friend])
            {
                if (p[i].color == 1)
                    p[friend].color = 2;
                else 
                    p[friend].color = 1;
                dfs(friend);
            }
        }
    }
}
