import java.util.*;
import java.io.*;

public class Convention { //binary search
    static int[] cows;
    static int n, m, c;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("convention.in"));
        PrintWriter out = new PrintWriter(new File("convention.out"));
        n = in.nextInt(); m = in.nextInt(); c = in.nextInt();

    }

    static int binarySearch(int s, int e)
    {
        if (e - s == 1)
        {
            if (works(e))
                return e;
            return s;
        }
        int mid = (s + e)/2;
        if (works(mid))
            return binarySearch(s, mid);
        return binarySearch(mid + 1, e);
    }

    static boolean works(int max)
    {
        return true;
    }
}
