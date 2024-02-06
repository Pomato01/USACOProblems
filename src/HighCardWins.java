import java.util.*;
import java.io.*;

public class HighCardWins {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("highcard.in"));
        PrintWriter out = new PrintWriter(new File("highcard.out"));

        int n = in.nextInt();
        boolean[] dist = new boolean[2*n];
        for (int i = 0; i < n; i++)
        {
            dist[in.nextInt() - 1] = true;
        }
        int[] b = new int[n];
        int[] e = new int[n];
        int bc = 0, ec = 0;
        for (int i = 0; i < 2*n; i++)
        {
            if (dist[i])
            {
                e[ec] = i + 1;
                ec++;
            }
            else 
            {
                b[bc] = i + 1;
                bc++;
            }
        }
        Arrays.sort(b);
        Arrays.sort(e);
        bc = 0; ec = 0;
        int a = 0;
        while(bc < n && ec < n)
        {
            if (b[bc] > e[ec])
            {
                a++;
                ec++;
            }
            bc++;
        }
        out.println(a);
        out.close();
    }
}
