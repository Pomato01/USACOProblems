import java.util.*;
import java.io.*;

public class ComfortableCows {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean[][] grid = new boolean[1001][1001];
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (i != 0)
                a[i] = a[i - 1];
            int x = in.nextInt();
            int y = in.nextInt();
            grid[x][y] = true;
            // comfortability of the square itself
            if (count(grid, x, y) == 3)
            {
                a[i]++;
                //System.out.println(x + "+" + y + " " + i);
            }
            // peripheral subtractions
            if (x - 1 >= 0 && grid[x - 1][y] && count(grid, x - 1, y) == 4)
            {
                a[i]--;
                //System.out.println((x-1) + "-" + y + " " + i);
            }
            if (x + 1 <= 1000 && grid[x + 1][y] && count(grid, x + 1, y) == 4)
            {
                a[i]--;
                //System.out.println((x+1) + "-" + y + " " + i);
            }
            if (y - 1 >= 0 && grid[x][y - 1] && count(grid, x, y - 1) == 4)
            {
                a[i]--;
                //System.out.println(x + "-" + (y-1) + " " + i);
            }
            if (y + 1 <= 1000 && grid[x][y + 1] && count(grid, x, y + 1) == 4)
            {
                a[i]--;
                //System.out.println(x + "-" + (y+1) + " " + i);
            }
            // peripheral additions
            if (x - 1 >= 0 && grid[x - 1][y] && count(grid, x - 1, y) == 3)
            {
                a[i]++;
                //System.out.println((x-1) + "+" + y + " " + i);
            }
            if (x + 1 <= 1000 && grid[x + 1][y] && count(grid, x + 1, y) == 3)
            {
                a[i]++;
                //System.out.println((x+1) + "+" + y + " " + i);
            }
            if (y - 1 >= 0 && grid[x][y - 1] && count(grid, x, y - 1) == 3)
            {
                a[i]++;
                //System.out.println(x + "+" + (y-1) + " " + i);
            }
            if (y + 1 <= 1000 && grid[x][y + 1] && count(grid, x, y + 1) == 3)
            {
                a[i]++;
                //System.out.println(x + "+" + (y+1) + " " + i);
            }
        }
        for (int w : a)
        {
            System.out.println(w);
        }
        // bruh
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int[] a = new int[n];
        // int[] adjacent = new int[n];
        // int[][] cows = new int[n][2];
        // for (int i = 0; i < n; i++)
        // {
        //     for (int j = 0; j < 2; j++)
        //     {
        //         cows[i][j] = in.nextInt();
        //     }
        // }
        // for (int i = 0; i < n; i++)
        // {
        //     if (i != 0)
        //         a[i] = a[i - 1];
        //     for (int j = 0; j < i; j++)
        //     {
        //         if ((cows[i][0] == cows[j][0] && (cows[j][1] - 1 == cows[i][1] || cows[j][1] + 1 == cows[i][1])) || (cows[i][1] == cows[j][1] && (cows[j][0] - 1 == cows[i][0] || cows[j][0] + 1 == cows[i][0])))
        //         {
        //             adjacent[i]++;
        //             adjacent[j]++;
        //             if (adjacent[i] == 3)
        //             {
        //                 a[i]++;
        //             }
        //             else if (adjacent[i] == 4)
        //             {
        //                 a[i]--;
        //             }
        //             if (adjacent[j] == 3)
        //             {
        //                 a[i]++;
        //             }
        //             else if (adjacent[j] == 4)
        //             {
        //                 a[i]--;
        //             }
        //         }

        //     }
        // }
        // for (int w : a)
        // {
        //     System.out.println(w);
        // }
    }

    public static int count (boolean[][] grid, int x, int y)
    {
        int sum = 0;
        if (x - 1 >= 0 && grid[x - 1][y])
            sum++;
        if (x + 1 <= 1000 && grid[x + 1][y])
            sum++;
        if (y - 1 >= 0 && grid[x][y - 1])
            sum++;
        if (y + 1 <= 1000 && grid[x][y + 1])
            sum++;
        return sum;
    }
}
