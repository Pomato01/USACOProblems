import java.util.*;
import java.io.*;

public class PaintingTheBarnSilver {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("paintbarn.in"));
        PrintWriter out = new PrintWriter(new File("paintbarn.out"));
        
        int[][] c = new int[1001][1001];
        int[][] p = new int[1001][1001];
        int n = in.nextInt(), k = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int left = in.nextInt(), high = in.nextInt(), right = in.nextInt(), low = in.nextInt();
            c[left][high]++;
            // if (right != 1000)
            //     c[right + 1][high]--;
            // if (low != 1000)
            //     c[left][low + 1]--;
            // if (right != 1000 && low != 1000)
            //     c[right + 1][low + 1]++;
            c[right][high]--;
            c[left][low]--;
            c[right][low]++;
        }
        p[0][0] = c[0][0];
        int a = 0;
        for (int i = 0; i < 1001; i++)
        {
            for (int j = 0; j < 1001; j++)
            {
                if (i == 0 && j == 0)
                    {}
                else if (i == 0)
                    p[i][j] = p[i][j - 1] + c[i][j];
                else if (j == 0)
                    p[i][j] = p[i - 1][j] + c[i][j];
                else 
                    p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + c[i][j];
                if (p[i][j] == k)
                    a++;
            }
        }
        // for (int i = 0; i < 10; i++)
        // {
        //     for (int j = 0; j < 10; j++)
        //     {
        //         System.out.print(c[i][j] + ", ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("\n");
        // for (int i = 0; i < 10; i++)
        // {
        //     for (int j = 0; j < 10; j++)
        //     {
        //         System.out.print(p[i][j] + ", ");
        //     }
        //     System.out.println();
        // }
        out.println(a);
        out.close();
    }
}
