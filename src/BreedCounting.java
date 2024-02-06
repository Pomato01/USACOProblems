import java.util.*;
import java.io.*;

public class BreedCounting {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("bcount.in"));
        PrintWriter out = new PrintWriter(new File("bcount.out"));
        int n = in.nextInt(), q = in.nextInt();
        int[] h = new int[n];
        int[] g = new int[n];
        int[] j = new int[n];
        h[0] = 0; g[0] = 0; j[0] = 0;
        switch(in.nextInt())
        {
            case 1: 
                h[0]++;
                break;
            case 2: 
                g[0]++;
                break;
            case 3: 
                j[0]++;
                break;
        }
        for (int i = 1; i < n; i++)
        {
            h[i] = h[i - 1];
            g[i] = g[i - 1];
            j[i] = j[i - 1];
            switch(in.nextInt())
            {
                case 1: 
                    h[i]++;
                    break;
                case 2: 
                    g[i]++;
                    break;
                case 3: 
                    j[i]++;
                    break;
            }
        }
        for (int i = 0; i < q; i++)
        {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            if (a == 0)
            {
                out.print(h[b] + " ");
                out.print(g[b] + " ");
                out.println(j[b]);
            }
            else 
            {
                out.print(h[b] - h[a - 1] + " ");
                out.print(g[b] - g[a - 1] + " ");
                out.println(j[b] - j[a - 1]);
            }
        }
        out.close();
    }
}
