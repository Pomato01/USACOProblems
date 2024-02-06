import java.util.*;
import java.io.*;

public class IcyPerimeter {

    static class Pair implements Comparable<Pair>
    {
        int area, peri;
        public Pair(int area, int peri)
        {
            this.area = area;
            this.peri = peri;
        }
        public int compareTo(Pair other)
        {
            int c = area - other.area;
            if (c == 0)
            {
                if (peri < other.peri)
                    return 1;
                return -1;
            }
            return c;
        }
    }

    static boolean[][] visited;
    static char[][] grid;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("perimeter.in"));
        PrintWriter out = new PrintWriter(new File("perimeter.out"));
        n = in.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++)
        {
            grid[i] = in.next().toCharArray();
        }
        visited = new boolean[n][n];
        Pair max = new Pair(0, 0);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                Pair temp = dfs(i, j);
                if (temp.compareTo(max) > 0)
                {
                    max = temp;
                }
            }
        }
        out.println(max.area + " " + max.peri);
        out.close();
    }

    static Pair dfs(int i, int j)
    {
        if (i >= n || i < 0 || j >= n || j < 0 || visited[i][j] || grid[i][j] != '#')
            return new Pair(0, 0);
        Pair temp = new Pair(1, 0);
        visited[i][j] = true;
        if (i - 1 >= 0)
        {
            if (grid[i - 1][j] == '.')
                temp.peri++;
            else{
                Pair top = dfs(i - 1, j);
                temp.area += top.area;
                temp.peri += top.peri;
            }
        }
        else 
            temp.peri++;
        if (i + 1 < n)
        {
            if (grid[i + 1][j] == '.')
                temp.peri++;
            else{
                Pair bottom = dfs(i + 1, j);
                temp.area += bottom.area;
                temp.peri += bottom.peri;
            }
        }
        else 
            temp.peri++;
        if (j - 1 >= 0)
        {
            if (grid[i][j - 1] == '.')
                temp.peri++;
            else{
                Pair left = dfs(i, j - 1);
                temp.area += left.area;
                temp.peri += left.peri;
            }
        }
        else 
            temp.peri++;
        if (j + 1 < n)
        {
            if (grid[i][j + 1] == '.')
                temp.peri++;
            else{
                Pair right = dfs(i, j + 1);
                temp.area += right.area;
                temp.peri += right.peri;
            }
        }
        else 
            temp.peri++;
        return temp;
    }
}
