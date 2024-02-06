import java.util.*;
import java.io.*;

public class CircularBarn {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cbarn.in"));
        PrintWriter out = new PrintWriter(new File("cbarn.out"));
        int min = Integer.MAX_VALUE;
        int n = in.nextInt();
        int[] r = new int[n];

        for (int i = 0; i < n; i++)
        {
            r[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++)
        {
            int ttotal = 0;
            for (int j = 0; j < n; j++)
            {
                int distance = (j - i);
                if (distance < 0)
                    distance += n;
                ttotal += distance * r[j];
            }
            min = Math.min(min, ttotal);
        }
        out.println(min);
        out.close();
    }
}
