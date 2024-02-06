import java.util.*;
import java.io.*;

public class CowTipping {
    static int[][] pState;
    static int[][] state;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cowtip.in"));
        PrintWriter out = new PrintWriter(new File("cowtip.out"));

        n = in.nextInt();
        state = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            char[] temp = in.next().toCharArray();
            for (int j = 0; j < n; j++)
            {
                state[i][j] = Integer.parseInt((String)("" + temp[j]));
            }
        }
        pState = new int[n][n];
        pState[0][0] = state[0][0];
        int a = 0;
        pS();
        while(pState[n-1][n-1] != 0)
        {
            pS();
            int max = 0;
            int maxi = 0;
            int maxj = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (pState[i][j] > max)
                    {
                        max = pState[i][j];
                        maxi = i;
                        maxj = j;
                    }
                }
            }
            update(maxi, maxj);
            for (int i = 0; i < n; i++)
            {
                System.out.println(Arrays.toString(state[i]));
            }
            a++;
        }
        out.println(a);
        out.close();
    }
    static void update(int x, int y)
    {
        for (int i = 0; i <= x; i++)
        {
            for (int j = 0; j <= y; j++)
            {
                if (state[i][j] == 0)
                    state[i][j] = 1;
                else
                    state[i][j] = 0;
            }
        }
    }
    static void pS()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i != 0)
                    pState[i][j] += pState[i - 1][j];
                if (j != 0)
                    pState[i][j] += pState[i][j - 1];
                if (i != 0 && j != 0)
                    pState[i][j] -= pState[i - 1][j - 1];
                pState[i][j] += state[i][j];
            }
        }
    }
}
