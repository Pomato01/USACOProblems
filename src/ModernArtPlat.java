import java.util.*;
import java.io.*;

public class ModernArtPlat {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("art.in"));
        PrintWriter out = new PrintWriter(new File("art.out"));
        int n = in.nextInt();

        int[] top = new int[n*n];
        int[] bottom = new int[n*n];
        int[] left = new int[n*n];
        int[] right = new int[n*n];
        int[][] canvas = new int[n][n];
        int[][] P = new int[n][n];
        int[][] psum = new int[n][n];

        for (int i = 0; i < n*n; i++)
        {
            top[i] = Integer.MAX_VALUE;
            left[i] = Integer.MAX_VALUE;
        }
        for(int x = 0; x < n; x++)
        {
            for(int y = 0; y < n; y++)
            {
                canvas[x][y] = in.nextInt();
                if (canvas[x][y] == 0)
                {
                    continue;
                }
                top[canvas[x][y] - 1] = Math.min(top[canvas[x][y] - 1], x);
                left[canvas[x][y] - 1] = Math.min(left[canvas[x][y] - 1], y);
                bottom[canvas[x][y] - 1] = x;
                right[canvas[x][y] - 1] = Math.max(right[canvas[x][y] - 1], y);
            }
        }
        // int[] check = {2, 3, 7};
        // for (int i = 0; i < check.length; i++)
        // {
        //     int ind = check[i] - 1;
        //     System.out.println(top[ind] + " " + bottom[ind] + " " + right[ind] + " " + left[ind]);
        // }
        for (int i = 0; i < n*n; i++)
        {
            if (top[i] == Integer.MAX_VALUE)
                continue;
            P[top[i]][left[i]]++;
            if (right[i] + 1 != n)
                P[top[i]][right[i] + 1]--;
            if (bottom[i] + 1 != n)
                P[bottom[i] + 1][left[i]]--;
            if (right[i] + 1 != n && bottom[i] + 1 != n)
                P[bottom[i] + 1][right[i] + 1]++;
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 && j == 0)
                    psum[i][j] = P[i][j];
                else if (i == 0)
                    psum[i][j] = psum[i][j - 1] + P[i][j];
                else if (j == 0)
                    psum[i][j] = psum[i - 1][j] + P[i][j];
                else 
                    psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + P[i][j];
            }
        }
        boolean[] notF = new boolean[n*n];
        int counter = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (psum[i][j] > 1 && !notF[canvas[i][j] - 1])
                {
                    counter++;
                    notF[canvas[i][j] - 1] = true;
                }
            }
        }
        // P, psum, canvas
        // for (int i = 0; i < P.length; i++)
        // {
        //     System.out.println(Arrays.toString(P[i]));
        // }
        // System.out.println();
        // for (int i = 0; i < psum.length; i++)
        // {
        //     System.out.println(Arrays.toString(psum[i]));
        // }
        out.println((n*n-counter));
        out.close();
    }
}
