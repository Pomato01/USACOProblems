import java.util.*;
import java.io.*;

public class MilkSum {
    static int[] a;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("milksum.in"));


        int n = in.nextInt();
        a = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
            s[i] = a[i];
        }
        Arrays.sort(a);

        
        int T = a[0];
        for (int i = 1; i < n; i++)
        {
            T += (i + 1) * a[i];
        }

        int[] p = new int[n];
        p[0] = a[0];
        for (int i = 1; i < n; i++)
        {
            p[i] = p[i - 1] + a[i];
        }
        int q = in.nextInt();

        for (int i = 0; i < q; i++)
        {
            int i1 = in.nextInt() - 1;
            int j = in.nextInt();
            int start;
            start = binarySearch(0, n - 1, s[i1]);
            
            int end = binarySearch(0, n - 1, j);
            int add = j * (end + 1);
            int sub = s[i1] * (start + 1);

            System.out.println(add + " " + sub);
            System.out.println(start + " " + end);
            int temp = 0;
            if (end <= start)
            {
                if (end != 0 && end < n)
                {
                    temp += p[end - 1];
                }
                if (start != 0 && start < n)
                {
                    temp -= p[start - 1];
                }
            }
            else 
            {
                if (end < n - 1)
                    temp += p[end];
                if (start < n - 1)
                    temp -= p[start];
            }
            System.out.println(temp);
            sub += temp;

            System.out.println(T + add - sub);
            // System.out.println(start + " " + end);
            // System.out.println(add + " " + sub);
            // if (start != 0)
            //     System.out.println(p[start - 1]);
            // if (end != 0)
            //     System.out.println(p[end - 1]);
            System.out.println();
        }
    }

    static int binarySearch(int a1, int b1, int f)
    {
        int mid = (a1 + b1)/2;
        if (b1 - a1 == 1)
        {
            if (a[a1] == f)
                return a1;
            return b1;
        }
        if (f > a[mid])
            return binarySearch(mid, b1, f);
        if (f < a[mid])
            return binarySearch(a1, mid, f);
        return mid;
    }
}
