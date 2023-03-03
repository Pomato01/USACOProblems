import java.util.*;
import java.io.*;

public class MountainView {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("mountains.in"));
        PrintWriter out = new PrintWriter(new File("mountains.out"));
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int a = 0;
        for (int i = 0; i < n; i++)
        {
            boolean covered = false;
            for (int j = 0; j < n; j++)
            {
                if (covered(x[i], y[i], x[j], y[j]) && i != j)
                {
                    covered = true;
                    break;
                }
            }
            if (!covered)
                a++;
        }
        out.println(a);
        out.close();
    }

    static boolean covered (int x1, int y1, int x2, int y2)
    {
        return x1 - y1 >= x2 - y2 && x1 + y1 <= x2 + y2;
    }
}
