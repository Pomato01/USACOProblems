import java.util.*;
import java.io.*;

public class WormholeSort {
    public static ArrayList<HashSet<int[]>> paths;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("wormsort.in"));
        PrintWriter out = new PrintWriter(new File("wormhole.out"));
        int n = in.nextInt(), m = in.nextInt();
        
        int[] p = new int[n];
        for (int i = 0; i < n; i++)
        {
            p[i] = in.nextInt();
        }
        int[] w = new int[m];

        paths = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            paths.add(new HashSet<int[]>());
        }
        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            w[i] = in.nextInt();
            int[] atemp = {a, w[i]};
            int[] btemp = {b, w[i]};
            paths.get(a).add(btemp);
            paths.get(b).add(atemp);
        }
    }

    boolean canReach(int s, int e, int w)
    {
        if (s == e)
            return true;
        if (paths.get(s).size() == 0)
            return false;
        boolean a = false;
        
        return a;
    }
}
