import java.util.*;
import java.io.*;

public class PaintingTheBarn {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("paintbarn.in"));
        PrintWriter out = new PrintWriter(new File("paintbarn.out"));
        int n = in.nextInt(), k = in.nextInt();
        int[][] P = new int[201][201];

        for (int i = 0; i < n; i++)
        {
            int left = in.nextInt(), bottom = in.nextInt(), right = in.nextInt(), top = in.nextInt();
            P[top][left]++;
            if (right + 1 != 201)
                P[top][right + 1]--;
            if (bottom + 1 != 201)
                P[bottom + 1][left]--;
            if (right + 1 != 201 && bottom + 1 != 201)
                P[bottom + 1][right + 1]++;
        }

        int[][] l = new int[201][201];
        int[][] g = new int[201][201];
        int a = 0;
        for (int i = 0; i < 201; i++)
        {
            for (int j = 0; j < 201; j++)
            {
                if (i == 0 && j == 0)
                    l[i][j] = P[i][j];
                else if (i == 0)
                    l[i][j] = l[i][j - 1] + P[i][j];
                else if (j == 0)
                    l[i][j] = l[i - 1][j] + P[i][j];
                else 
                    l[i][j] = l[i - 1][j] + l[i][j - 1] - l[i - 1][j - 1] + P[i][j];
                if (l[i][j] == k - 1)
                    g[i][j]++;
                if (l[i][j] == k)
                {
                    g[i][j]--;
                    a++;
                }
            }
        }
        int[][] dKl = new int[201][201];
        for (int i = 0; i < 201; i++)
        {
            for (int j = 0; j < 201; j++)
            {
                if (i == 0 && j == 0)
                    dKl[i][j] = g[i][j];
                else if (i == 0)
                    dKl[i][j] = dKl[i][j - 1] + g[i][j];
                else if (j == 0)
                    dKl[i][j] = dKl[i - 1][j] + g[i][j];
                else 
                    dKl[i][j] = dKl[i - 1][j] + dKl[i][j - 1] - dKl[i - 1][j - 1] + g[i][j];
            }
        }
        for (int i = 0; i < 201; i++)
        {
            for (int j = 0; j < 201; j++)
            {
                
            }
        }
    }
}
