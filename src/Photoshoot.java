import java.util.*;
import java.io.*;

public class Photoshoot { //ez
    static int[] d;
    static int[] a;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("photo.in"));
        PrintWriter out = new PrintWriter(new File("photo.out"));
        n = in.nextInt();
        d = new int[n - 1];
        a = new int[n];

        for (int i = 0; i < n - 1; i++)
        {
            d[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++)
        {
            if (check(i))
                break;
        }
        for (int i = 0; i < a.length; i++)
        {
            out.print(a[i]);
            if (i != n - 1)
                out.print(" ");
        }
        out.close();
    }

    static boolean check (int start)
    {
        HashSet<Integer> used = new HashSet<>();
        a = new int[n];
        a[0] = start;
        for (int i = 1; i < n; i++)
        {
            a[i] = d[i - 1] - a[i - 1];
            if (used.contains(a[i]) || a[i] > n)
                return false;
            else
                used.add(a[i]);
        }
        return true;
    }
}
