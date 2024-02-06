import java.util.*;
import java.io.*;

public class DiamondCollectorSilver{
    static int[] d;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("diamond.in"));
        PrintWriter out = new PrintWriter(new File("diamond.out"));
        int n = in.nextInt(); k = in.nextInt();
        d = new int[n];

        for (int i = 0; i < n; i++)
        {
            d[i] = in.nextInt();
        }
        Arrays.sort(d);
        int[] s = new int[n];
        for (int i = 0; i < n; i++)
        {
            s[i] = search(d[i] + k, 0, n - 1) - i + 1;
        }
        int[] b = new int[n];
        b[n - 1] = s[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            b[i] = Math.max(s[i], b[i + 1]);
        }

        int a = 0;
        for (int i = 0; i < n - 1; i++)
        {
            int temp = i + s[i];
            if (temp >= n)
                temp = n - 1;
            a = Math.max(a, s[i] + b[temp]);
        }

        out.println(a);
        out.close();
    }

    static int search(int a, int start, int end)
    {
        if (end - start == 1)
        {
            if (d[end] <= a)
                return end;
            return start;
        }
        if (end - start == 2)
        {
            if (d[end] <= a)
                return end;
            if (d[end - 1] <= a)
                return end - 1;
            return start;
        }
        int mid = (start + end)/2;
        if (d[mid] > a)
            return search(a, start, mid);
        else 
            return search(a, mid, end);
    }
}

// public class DiamondCollectorSilver { ill just brute force
//     public static void main(String[] args) throws IOException {
//         Scanner in = new Scanner(new File("diamond.in"));
//         PrintWriter out = new PrintWriter(new File("diamond.out"));
//         int n = in.nextInt(), k = in.nextInt();

//         int[] d = new int[n];
//         for (int i = 0; i < n; i++)
//         {
//             d[i] = in.nextInt();
//         }
//         Arrays.sort(d);

//         int a = 0, i = 0, j = 0, s = 0, e = 0;
//         while(i < n && j < n)
//         {
//             if (d[j] - d[i] <= k)
//             {
//                 if (j - i + 1 > a)
//                 {
//                     s = i;
//                     e = j;
//                     a = j - i + 1;
//                 }
//                 j++;
//             }
//             else 
//                 i++;
//         }
//         int a1 = 0; i = 0; j = 0;
//         while(i < n && j < n)
//         {
//             if (d[j] - d[i] <= k)
//             {
//                 if (count(i, j, s, e) > a1)
//                     a1 = count(i, j, s, e);
//                 j++;
//             }
//             else 
//                 i++;
//         }
//         // System.out.println(Arrays.toString(d));
//         // System.out.println(s + " " + e);
//         out.println(a + a1);
//         out.close();
//     }

//     static int count(int i, int j, int s, int e)
//     {
//         if (e <= j && s >= i)
//             return s - i + j - e;
//         if (e <= j && e >= i)
//             return j - e;
//         if (s <= j && s >= i)
//             return s - i;
//         return j - i + 1;
//     }
// }
