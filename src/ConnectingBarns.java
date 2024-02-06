import java.util.*;

public class ConnectingBarns {
    static boolean[] visited;
    static List<Integer>[] paths;
    static int[] findU;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        paths = new List[n];
        findU = new int[n];
        
        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            paths[a].add(b);
            paths[b].add(a);
        }
        visited = new boolean[n];

    }

    void getU (int i)
    {
        
    }
}
