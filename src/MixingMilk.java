import java.util.*;
import java.io.*;

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("mixmilk.in"));
        PrintWriter out = new PrintWriter(new File("mixmilk.out"));

        int[] c = new int[3];
        int[] m = new int[3];
        for (int i = 0; i < 3; i++)
        {
            c[i] = in.nextInt();
            m[i] = in.nextInt();
        }
        for (int i = 0; i < 100; i++)
        {
            int a;
            int start = i % 3;
            int end = (start + 1) % 3;
            a = Math.min(m[start], c[end] - m[end]);
            m[start] -= a;
            m[end] += a;
        }
        for (int w : m)
        {
            out.println(w);
        }
        out.close();
    }
}
