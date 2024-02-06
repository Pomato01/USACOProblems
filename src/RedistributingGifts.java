import java.util.*;
import java.io.*;

public class RedistributingGifts {
    
    static int[][] wishlists;
    static boolean[] visited;
    static int n;
    static List<Integer> path;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("redistgifts.in"));
        n = in.nextInt();
        wishlists = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                wishlists[i][j] = in.nextInt() - 1;
            }
        }
        for (int i = 0; i < n; i++)
        {
            visited = new boolean[n];
            path = new ArrayList<Integer>();
            System.out.println(dfs(i, i) + 1);
        }
    }

    static int dfs(int curr, int i)
    {
        visited[curr] = true;
        path.add(curr);
        for (int j = 0; j < n; j++)
        {
            if (prefers(j, curr, wishlists[curr]) && !visited[j])
            {
                if (i == j)
                    return path.get(1);
                else
                    return dfs(j, i);
            }
        }
        return i;
    }

    static boolean prefers(int a, int b, int[] c) // whether cow c prefers a over b
    {
        return binarySearch(a, c, 0, c.length - 1) < binarySearch(b, c, 0, c.length - 1);
    }

    static int binarySearch(int v, int[] a, int s, int e)
    {
        int mid = (e + s)/2;
        if (e - s == 1)
        {
            if (a[s] == v)
                return s;
            if (a[e] == v)
                return e;
            return -1;
        }
        if (a[mid] < v)
            return binarySearch(v, a, mid, e);
        if (a[mid] > v)
            return binarySearch(v, a, s, mid);
        return mid;
    }
}
