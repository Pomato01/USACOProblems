import java.util.*;
import java.io.*;

public class WDTCCTR2 { // 11/11
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("maxcross.in"));
        PrintWriter out = new PrintWriter(new File("maxcross.out"));
        int n = in.nextInt(), k = in.nextInt(), b = in.nextInt();
        boolean[] state = new boolean[n];
        for (int i = 0; i < b; i++)
        {
            state[in.nextInt() - 1] = true;
        }
        int[] pSum = new int[n];
        if (state[0])
            pSum[0] = 1;
        for (int i = 1; i < n; i++)
        {
            pSum[i] = pSum[i - 1];
            if (state[i])
                pSum[i]++;
        }
        int a = pSum[k - 1];
        for (int i = 0; i < n - k; i++)
        {
            a = Math.min(a, pSum[i + k] - pSum[i]);
        }
        out.println(a);
        out.close();
    }
}
