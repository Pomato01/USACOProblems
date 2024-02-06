import java.util.*;
import java.io.*;

public class SwapitySwap { // kinda ez
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("swap.in"));
        PrintWriter out = new PrintWriter (new File("swap.out"));
        int n = in.nextInt(), k = in.nextInt();
        int a1 = in.nextInt(), a2 = in.nextInt();
        int b1 = in.nextInt(), b2 = in.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i < n; i++)
        {
            cows[i] = i + 1;
        }
        if (a2 < b1 || b2 < a1)
        {
            if (k % 2 == 0)
            {

            }
            else
            {
                swap(a1, a2, cows);
                swap(b1, b2, cows);
            }
        }
        else if (a1 == b1 && a2 == b2)
        {

        }
        else
        {
            int r = -1;
            for (int i = 0; i < k; i++)
            {
                swap(a1, a2, cows);
                swap(b1, b2, cows);
                if (inO(cows))
                {
                    r = i + 1;
                    break;
                }
            }
            if (r != -1)
            {
                for (int i = 0; i < n; i++)
                {
                    cows[i] = i + 1;
                }
                int re = k % r;
                for (int i = 0; i < re; i++)
                {
                    swap(a1, a2, cows);
                    swap(b1, b2, cows);
                }
            }
        }
        for (int w : cows)
        {
            out.println(w);
        }
        out.close();
    }
    static boolean inO (int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != i + 1)
                return false;
        }
        return true;
    }
    static void swap (int p1, int p2, int[] cows)
    {
        p1--;
        p2--;
        for (int i = 0; i <= (p2 - p1) / 2; i++)
        {
            swap(cows, i + p1, p2 - i);
        }
    }
    static void swap(int[] a, int c, int b)
    {
        int temp = a[c];
        a[c] = a[b];
        a[b] = temp;
    }
}
