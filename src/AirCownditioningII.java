import java.util.*;
import java.io.*;

public class AirCownditioningII { // works
    static int cost = Integer.MAX_VALUE;
    static int[] s;
    static int[] t;
    static int[] c;
    static int[] a;
    static int[] b;
    static int[] p;
    static int[] m;
    static int n, M;
    public static void main(String[] args) throws IOException { // m is 10 at most so complete search with O(n2^n)
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); 
        M = in.nextInt();
        s = new int[n];
        t = new int[n];
        c = new int[n];
        a = new int[M];
        b = new int[M];
        p = new int[M];
        m = new int[M];
        int[] temps = new int[100];
        for (int i = 0; i < n; i++)
        {
            s[i] = in.nextInt() - 1;
            t[i] = in.nextInt() - 1;
            c[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++)
        {
            a[i] = in.nextInt() - 1;
            b[i] = in.nextInt() - 1;
            p[i] = in.nextInt();
            m[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = s[i]; j <= t[i]; j++)
            {
                temps[j] += c[i];
            }
        }
        checkAll(temps.clone(), 0, true, 0);
        checkAll(temps.clone(), 0, false, 0);
        System.out.println(cost);
    }
    static void checkAll(int[] a1, int i, boolean state, int cCost)
    {
        if (i == M)
        {
            boolean add = true;
            for (int j = 0; j < a1.length; j++)
            {
                if (a1[j] > 0)
                    add = false;
            }
            if (add)
                cost = Math.min(cost, cCost);
            return;
        }
        if (state)
        {
            cCost += m[i];
            for (int j = a[i]; j <= b[i]; j++)
            {
                a1[j] -= p[i];
            }
        }
        // if (i == M - 1)
        //     System.out.println(Arrays.toString(a1));
        checkAll(a1.clone(), i + 1, true, cCost);
        checkAll(a1.clone(), i + 1, false, cCost);
    }
}
