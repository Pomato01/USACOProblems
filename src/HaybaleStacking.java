import java.util.*;
import java.io.*;

public class HaybaleStacking {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("stacking.in"));
        PrintWriter out = new PrintWriter(new File("stacking.out"));
        int n = in.nextInt(), k = in.nextInt();

        int[] c = new int[n];
        for (int i = 0; i < k; i++)
        {
            int A = in.nextInt(), B = in.nextInt();
            c[A]++;
            if (B < n - 1)
                c[B + 1]--;
        }
        int[] p = new int[n];
        p[0] = c[0];
        for (int i = 1; i < n; i++)
        {
            p[i] = p[i - 1] + c[i];
        }
        Arrays.sort(p);
        out.println(p[p.length / 2]);
        out.close();
    }
}
