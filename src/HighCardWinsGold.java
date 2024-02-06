import java.util.*;
import java.io.*;

public class HighCardWinsGold {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cardgame.in"));
        PrintWriter out = new PrintWriter(new File("cardgame.out"));

        int n = in.nextInt();
        int[] ef = new int[n/2];
        int[] el = new int[n/2];
        int[] bf = new int[n/2];
        int[] bl = new int[n/2];
        boolean[] e = new boolean[2*n];
        int[] b = new int[n];
        for (int i = 0; i < n / 2; i++)
        {
            int t = in.nextInt() - 1;
            e[t] = true;
            ef[i] = t;
        }
        for (int i = 0; i < n / 2; i++)
        {
            int t = in.nextInt() - 1;
            e[t] = true;
            el[i] = t;
        }
        int c = 0;
        for (int i = 0; i < 2*n; i++)
        {
            if (!e[i])
            {
                b[c] = i;
                c++;
            }
        }
        Arrays.sort(b);
        for (int i = 0; i < n / 2; i++)
        {
            bl[i] = b[i];
            bf[i] = b[i + (n / 2)];
        }
        int a = 0;
        Arrays.sort(ef);
        Arrays.sort(el);
        int bfc = 0, efc = 0;
        while (bfc < n / 2 && efc < n / 2)
        {
            if (bf[bfc] > ef[efc])
            {
                a++;
                efc++;
            }
            bfc++;
        }
        bfc = n / 2 - 1; efc = n / 2 - 1;
        while (bfc >= 0 && efc >= 0)
        {
            if (bl[bfc] < el[efc])
            {
                a++;
                efc--;
            }
            bfc--;
        }
        out.println(a);
        out.close();
    }
}
