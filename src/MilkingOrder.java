import java.util.*;
import java.io.*;

public class MilkingOrder { // literally copied from the solution
    static boolean[] usedCows = new boolean[100];
    static boolean[] usedPos = new boolean[100];
    static int[] pos = new int[100];
    static int[] order = new int[100];
    static int[] cFixed = new int[101];
    static int[] pFixed = new int[101];
    static int N, M, K;
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("milkorder.in"));
        PrintWriter out = new PrintWriter(new File("milkorder.out"));
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();

        for (int  i = 0; i < M; i++)
        {
            order[i] = in.nextInt() - 1;
        }
        for (int i = 0; i < K; i++)
        {
            cFixed[i] = in.nextInt() - 1;
            pFixed[i] = in.nextInt() - 1;
        }
        for (int i = 0; i < N; i++)
        {
            cFixed[K] = 0;
            pFixed[K] = i;
            if (works())
            {
                out.println(i + 1);
                out.close();
                return;
            }
        }
        out.close();
    }
    public static boolean works()
    {
        for (int i = 0; i < N; i++)
        {
            usedCows[i] = false;
            usedPos[i] = false;
        }
        for (int i = 0; i < K + 1; i++)
        {
            if (usedCows[cFixed[i]] && pos[cFixed[i]] == pFixed[i])
            {
                continue;
            }
            if (usedCows[cFixed[i]] || usedPos[pFixed[i]])
                return false;
            usedCows[cFixed[i]] = true;
            usedPos[pFixed[i]] = true;
            pos[cFixed[i]] = pFixed[i];
        }
        int j = 0;
        for (int i = 0; i < M; i++)
        {
            int cow = order[i];
            if (usedCows[cow])
            {
                if (j > pos[cow])
                    return false;
                j = pos[cow];
                continue;
            }
            while (usedPos[j])
            {
                j++;
                if (j == N)
                    return false;
            }
            usedPos[j] = true;
            pos[cow] = j;
        }
        return true;
    }
}
