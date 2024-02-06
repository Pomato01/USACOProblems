import java.util.*;
import java.io.*;

public class CowDanceShow { //binary search
    static int[] cows;
    static int n, tMax;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cowdance.in"));
        PrintWriter out = new PrintWriter(new File("cowdance.out"));
        n = in.nextInt(); tMax = in.nextInt();
        cows = new int[n];
        for (int i = 0; i < n; i++)
        {
            cows[i] = in.nextInt();
        }
        out.println(binarySearch(1, n));
        out.close();
    }
    static int binarySearch(int start, int end)
    {
        if (end - start == 1)
        {
            if (works(start))
                return start;
            return end;
        }
        int mid = (start + end)/2;
        if (works(mid))
            return binarySearch(start, mid);
        return binarySearch(mid + 1, end);
    }
    static boolean works(int k)
    {
        PriorityQueue<Integer> stage = new PriorityQueue<>();
        int t = 0;
        stage.add(cows[0]);
        for (int i = 1; i < n; i++)
        {
            if (stage.size() == k)
                t = stage.poll();
            stage.add(t + cows[i]);
        }
        while(!stage.isEmpty())
        {
            t = stage.poll();
        }
        return t <= tMax;
    }
}
