import java.util.*;
import java.io.*;

public class RectangularPasture {
    static class Pair implements Comparable<Pair>
    {
        int a, b;
        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair other)
        {
            return a - other.a;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Pair[] x = new Pair[n];
        Pair[] y = new Pair[n];
        Integer[] yToX = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            x[i] = new Pair(in.nextInt(), i);
            y[i] = new Pair(in.nextInt(), i);
            // yToX[y[i].a] = x[i].a;
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < n; i++)
        {
            x[i].a = i;
            y[i].a = i;
        }
        // for (int i = 0; i < n; i++)
        //     yToX[y[i].a] = x[i].a;
        int[][] cows = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            cows[x[i].b][0] = x[i].a;
            cows[y[i].b][1] = y[i].a;
        }
        boolean[][] grid = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            grid[cows[i][0]][cows[i][1]] = true;
            
            for (int j = 0; j < n; j++)
            {
                if (x[i].b == y[j].b)
                    yToX[x[i].a] = y[j].a;
            }
        }
        int[][] p = new int[n][n];
        if (grid[0][0])
            p[0][0]++;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0)
                {}
                else if (i == 0)
                    p[i][j] = p[i][j - 1];
                else if (j == 0)
                    p[i][j] = p[i - 1][j];
                else 
                    p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1];
                if (grid[i][j])
                    p[i][j]++;
            }
        }
        int a = n + 1;
        for (int i = 0; i < n; i++)
        {
            if (yToX[i] == null)
                continue;
            for (int j = i + 1; j < n; j++)
            {
                if (yToX[i] == null)
                    continue;
                
                int l = Math.min(yToX[i], yToX[j]);
                int r = Math.max(yToX[i], yToX[j]);
                // let amt on left be a1 and on right be b1. increment by (x+1)(y+1)
                // for i = 0 & j = 1, r = 1, l = 0
                int a1 = 0;
                if (l != 0 && j != 0)
                    a1 = p[j - 1][l - 1];
                if (i != 0 && l != 0)
                    a1 -= p[i - 1][l - 1];
                int b1 = p[j][n - 1]; //2
                if (i != 0)
                    b1 -= p[i - 1][n - 1]; 
                b1 -= p[j][r]; 
                if (i != 0 && r != 0)
                    b1 += p[i - 1][r - 1]; 
                a += (a1 + 1)*(b1 + 1);
                // System.out.println(i + " " + j + " " + a1 + " " + b1);
            }
        }
        // for (int i = 0; i < n; i++)
        // {
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        // System.out.println();
        // System.out.println(Arrays.toString(yToX));
        // for (int i = 0; i < n; i++)
        // {
        //     System.out.println(Arrays.toString(p[i]));
        // }
        // System.out.println();
        System.out.println(a);
    }
}
