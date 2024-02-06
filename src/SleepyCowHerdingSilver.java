import java.util.*;
import java.io.*;

public class SleepyCowHerdingSilver {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("herding.in"));
        PrintWriter out = new PrintWriter(new File("herding.out"));
        int n = in.nextInt();

        int[] c = new int[n];
        for (int i = 0; i < n; i++)
        {
            c[i] = in.nextInt();
        }
        Arrays.sort(c);

        //min
        int i = 0, j = 0, a = 0;
        while (j < n)
        {
            if (c[j] - c[i] <= n)
            {
                a = Math.max(a, j - i + 1);
                j++;
            }
            else 
            {
                i++;
            }
        }
        out.println(n - a);
        
        //max
        int w = Math.max(c[n - 2] - c[0], c[n - 1] - c[1]);
        out.println(w - n + 2);
        out.close();
    }
}
