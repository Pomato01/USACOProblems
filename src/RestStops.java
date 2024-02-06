import java.util.*;
import java.io.*;

public class RestStops {
    static class Stop implements Comparable<Stop>
    {
        int x, c;
        public Stop (int x, int c)
        {
            this.x = x;
            this.c = c;
        }
        public int compareTo(Stop other)
        {
            return x - other.x;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("reststops.in"));
        PrintWriter out = new PrintWriter(new File("reststops.out"));
        int L = in.nextInt(), N = in.nextInt(), f = in.nextInt(), b = in.nextInt();
        Stop[] stops = new Stop[N];
        int total = L*f - L*b;
        for (int i = 0; i < N; i++)
        {
            stops[i] = new Stop(in.nextInt(), in.nextInt());
        }
        Stop temp = stops[N - 1];
        ArrayList<Stop> lStops = new ArrayList<>();
        lStops.add(temp);
        for (int i = N - 1; i >= 0; i--)
        {
            if (stops[i].c > temp.c)
            {
                temp = stops[i];
                lStops.add(temp);
            }
        }
        System.out.println(L*f + " " + Integer.MAX_VALUE);
        Collections.sort(lStops);
        int sofar = 0;
        int a = 0;
        for (Stop s : lStops)
        {
            int allowed = Math.min(s.x*f - s.x*b - sofar, total); // this line?
            a += allowed * s.c;
            total -= allowed;
            sofar += allowed;
        }
        out.println(a);
        out.close();

    }
}
