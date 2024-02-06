import java.util.*;
import java.io.*;

public class BerryPicking {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("berries.in"));
        PrintWriter out = new PrintWriter(new File("berries.out"));

        int n = in.nextInt(), k = in.nextInt();
        int[] b = new int[n];
        int bmax = 0;
        for (int i = 0; i < n; i++)
        {
            b[i] = in.nextInt();
            bmax = Math.max(bmax, b[i]);
        }
        Arrays.sort(b);
        int a, baskets;
        int max = 0;
        int[] temp;
        for (int i = 0; i <= bmax; i++)
        {
            a = 0;
            baskets = k;
            temp = b.clone();
            int numb = 0;
            for (int j = 0; j < n; j++)
            {
                if (b[j] >= i)
                {
                    numb = n - j;
                    break;
                }
            }
            a += Math.min(numb, baskets) * i;
            baskets -= numb;
            if (baskets < 1)
            {
                max = Math.max(max, a);
                continue;
            }
            for (int j = n - numb; j < n; j++)
            {
                temp[j] -= i;
            }
            Arrays.sort(temp);
            for (int j = n - 1; j >= 0; j--)
            {
                a += temp[j];
                baskets--;
                if (baskets == 0)
                    break;
            }
            max = Math.max(max, a);
        }
        out.println(max);
        out.close();
    }
}
