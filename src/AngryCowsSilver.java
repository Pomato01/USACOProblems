import java.util.*;
import java.io.*;

public class AngryCowsSilver
{
    static int[] p;
    static int n, k;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("angry.in"));
        PrintWriter out = new PrintWriter(new File("angry.out"));
        n = in.nextInt(); k = in.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++)
        {
            p[i] = in.nextInt();
        }
        Arrays.sort(p);
        out.println(binarySearch(0, (int)1e6));
        out.close();
    }

    static int binarySearch(int s, int e)
    {
        int mid = (s + e)/2;
        if (e - s == 1)
        {
            if (works(e))
                return e;
            return s;
        }
        if (works(mid) && !works(mid - 1))
        {
            return mid;
        }
        else if (works(mid))
        {
            return binarySearch(s, mid);
        }
        else 
            return binarySearch(mid, e);
    }

    static boolean works(int r)
    {
        int curr = p[0] + r;
        int count = 1;
        for (int i = 0; i < n; i++)
        {
            if (p[i] > curr + r)
            {
                curr = p[i] + r;
                count++;
            }
        }
        return count <= k;
    }
}