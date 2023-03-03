import java.util.*;
import java.io.*;

public class Race {
    // public static void main(String[] args) throws IOException {
    //     Scanner in = new Scanner(new File("race.in"));
    //     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("race.out"))));

    //     int k = in.nextInt();
    //     int n = in.nextInt();
    //     int p = 0;
    //     for (int i = 0; i < n; i++)
    //     {
    //         int x = in.nextInt();
    //         int t = race(p, k, 0, 0, x);
    //         out.println(t);
    //     }
    //     out.close();
    // }
    // static int race(int p, int k, int s, int t, int x)
    // {
    //     if (s < 0)
    //         return Integer.MAX_VALUE;
    //     if (p >= k)
    //     {
    //         if (s > x)
    //             return Integer.MAX_VALUE;
    //         else
    //             return t;
    //     }
    //     int decrease = race(p + s - 1, k, s - 1, t + 1, x);
    //     int same;
    //     if (s != 0)
    //         same = race(p + s, k, s, t + 1, x);
    //     else
    //         same = Integer.MAX_VALUE;
    //     int increase = race(p + s + 1, k, s + 1, t + 1, x);
    //     return Math.min(decrease, Math.min(same, increase));
    // }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("race.in"));
        PrintWriter out = new PrintWriter(new File("race.out"));
        int k = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            out.println(solve(k, in.nextInt()));
        }
        out.close();
    }
    public static int solve(int k, int x)
    {
        int ltravel = 0, rtravel = 0, time = 0; 
        for (int curr = 1; true; curr++)
        {
            ltravel += curr;
            time++;
            if (ltravel + rtravel >= k)
                return time;
            if (curr >= x)
            {
                rtravel += curr;
                time++;
                if (ltravel + rtravel >= k)
                    return time;
            }
        }
    }
}
