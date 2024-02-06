import java.io.*;
import java.util.*;

public class Mootube {
    static class Pair 
    {
        int vid, relevance;
        public Pair(int vid, int relevance)
        {
            this.vid = vid;
            this.relevance = relevance;
        }
        @Override
        public boolean equals(Object other)
        {
            return ((Pair)other).vid == vid && ((Pair)other).relevance == relevance;
        }
    }
    static List<List<Pair>> relevance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("mootube.in"));
        PrintWriter out = new PrintWriter(new File("mootube.out"));
        int n = in.nextInt(), q = in.nextInt();
        relevance = new ArrayList<>();

        for (int i = 0; i < n; i++)
            relevance.add(new ArrayList<Pair>());
        
        for (int i = 0; i < n - 1; i++)
        {
            int a = in.nextInt() - 1, b = in.nextInt() - 1, c = in.nextInt();
            relevance.get(a).add(new Pair(b, c));
            relevance.get(b).add(new Pair(a, c));
        }

        for (int i = 0; i < q; i++)
        {
            int k = in.nextInt(), a = in.nextInt() - 1;
            visited = new boolean[n];
            out.println(search(a, k, Integer.MAX_VALUE) - 1);
        }
        out.close();
    }

    static int search(int a, int k, int r)
    {
        if (visited[a] || r < k)
            return 0;
        visited[a] = true;
        int c = 1;
        for (Pair x : relevance.get(a))
        {
            c += search(x.vid, k, Math.min(x.relevance, r));
        }
        return c;
    }
}
