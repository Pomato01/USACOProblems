import java.util.*;
import java.io.*;

public class JustStalling {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++)
        {
            c[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            s[i] = in.nextInt();
        }
        Arrays.sort(c);
        Arrays.sort(s);
        int[] o = new int[n];
        int counter = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            o[i] = inL(s, c[i]) - counter;
            counter++;
        }
        long a = 1;
        for (int i = 0; i < n; i++)
        {
            a *= o[i];
        }
        // System.out.println(Arrays.toString(c));
        // System.out.println(Arrays.toString(s));
        // System.out.println(Arrays.toString(o));
        System.out.println(a);
    }
    static int inL (int[] s, int c)
    {
        if (s[0] >= c)
        {
            return s.length;
        }
        for (int i = s.length - 1; i >= 0; i--)
        {
            if (c > s[i])
            {
                return s.length - 1 - i;
            }
        }
        return 0;
    }
}
