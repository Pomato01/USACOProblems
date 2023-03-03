import java.util.*;
import java.io.*;

public class CowntractTracing {
    public static int[][] shakes;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("tracing.in"));
        PrintWriter out = new PrintWriter(new File("tracing.out"));
        int n = in.nextInt(), t = in.nextInt();
        char[] state = in.next().toCharArray();
        shakes = new int[t][3];

        for (int i = 0; i < t; i++)
        {
            shakes[i][0] = in.nextInt();
            shakes[i][1] = in.nextInt() - 1;
            shakes[i][2] = in.nextInt() - 1;
        }

        sort();

        int x = 0, y = 100, z = 0; // input is t, x, y
        for (int i = 0; i < n; i++)
        {
            boolean s = false;
            for (int K = 0; K <= t; K++)
            {
                int[] turns = new int[n];
                boolean[] cstate = new boolean[n];
                cstate[i] = true;
                for (int l = 0; l < turns.length; l++)
                {
                    turns[l] = K;
                }
                for (int l = 0; l < t; l++)
                {
                    if (cstate[shakes[l][1]] && cstate[shakes[l][2]])
                    {
                        if (turns[shakes[l][1]] > 0)
                            turns[shakes[l][1]]--;
                        if (turns[shakes[l][2]] > 0)
                            turns[shakes[l][2]]--;
                    }
                    else if (cstate[shakes[l][1]])
                    {
                        if (turns[shakes[l][1]] > 0)
                        {
                            cstate[shakes[l][2]] = true;
                            turns[shakes[l][1]]--;
                        }
                    }
                    else if (cstate[shakes[l][2]])
                    {
                        if (turns[shakes[l][2]] > 0)
                        {
                            cstate[shakes[l][1]] = true;
                            turns[shakes[l][2]]--;
                        }
                    }
                }
                if (equals(cstate, state))
                {
                    s = true;
                    y = Math.min(y, K);
                    z = Math.max(z, K);
                }
            }
            if (s)
            {
                x++;
            }
        }
        out.print(x + " " + y + " ");
        if (z == t)
        {
            out.println("Infinity");
        }
        else
        {
            out.println(z);
        }
        out.close();
    }

    public static boolean equals(boolean[] b, char[] c)
    {
        for (int i = 0; i < c.length; i++)
        {
            if (!(b[i] && c[i] == '1' || !b[i] && c[i] == '0'))
            {
                return false;
            }
        }
        return true;
    }
    public static void sort() // O(n^2) complexity bc lazy
    {
        for (int i = 0; i < shakes.length; i++)
        {
            for (int j = 0; j < shakes.length - 1; j++)
            {
                if (shakes[j][0] > shakes[j + 1][0])
                {
                    swap(j, j + 1);
                }
            }
        }
    }

    public static void swap(int a, int b)
    {
        int[] temp = shakes[a].clone();
        shakes[a] = shakes[b].clone();
        shakes[b] = temp.clone();

    }
}
