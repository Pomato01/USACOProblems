import java.util.*;
import java.io.*;

public class DaisyChains {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        int a = 0;
        for (int i = 0; i < n; i++)
        {
            p[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                a += count(p, i, j);
            }
        }
        System.out.println(a);
    }

    static int count(int[] p, int a, int b)
    {
        double avg = 0;
        for (int i = a; i <= b; i++)
        {
            avg += p[i];
        }
        avg /= (b - a + 1);
        for (int i = a; i <= b; i++)
        {
            if (p[i] == avg)
                return 1;
        }
        return 0;
    }
}
