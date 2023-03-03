import java.util.*;
import java.io.*;

public class SubsSumSeven {
    // public static void main(String[] args) throws IOException {
    //     Scanner in = new Scanner(new File("div7.in"));
    //     PrintWriter out = new PrintWriter(new File("div7.out"));
    //     int n = in.nextInt();
    //     int[] c = new int[n];
    //     for (int i = 0; i < n; i++)
    //     {
    //         c[i] = in.nextInt();
    //     }
    //     int a = 0;
    //     int[] p = new int[n];
    //     p[0] = c[0];
    //     for (int i = 1; i < n; i++)
    //     {
    //         p[i] = c[i] + p[i - 1];
    //     }
    //     for (int i = 0; i < n; i++)
    //     {
    //         for (int j = i; j < n; j++)
    //         {
    //             int sum = p[j] - p[i] + c[i];
    //             if (sum % 7 == 0)
    //             {
    //                 a = Math.max(a, j - i + 1);
    //             }
    //         }
    //     }
    //     out.println(a);
    //     out.close();
    // }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("div7.in"));
        PrintWriter out = new PrintWriter(new File("div7.out"));
        int n = in.nextInt();
        int[] c = new int[n];
        int[] p = new int[n];

        c[0] = in.nextInt() % 7;
        p[0] = c[0] % 7;
        for (int i = 1; i < n; i++)
        {
            c[i] = in.nextInt() % 7;
            p[i] = (p[i - 1] + c[i]) % 7;
        }

        int a = 0;
        for (int i = 0; i < 7; i++)
        {
            boolean e = false;
            int first = 0, last = 0;
            for (int j = 0; j < n; j++)
            {
                if (p[j] == i)
                {
                    first = j;
                    e = true;
                    break;
                }
            }
            for (int j = n - 1; j >= 0; j--)
            {
                if (p[j] == i)
                {
                    last = j;
                    break;
                }
            }
            if (e)
                a = Math.max(a, last - first);
        }
        out.println(a);
        out.close();
    }
}
