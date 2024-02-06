import java.util.*;
import java.io.*;

public class ConventionII {
    static class Cow implements Comparable<Cow>
    {
        int seniority;
        int arrival;
        int duration;
        public Cow(int seniority, int arrival, int duration)
        {
            this.seniority = seniority;
            this.arrival = arrival;
            this.duration = duration;
        }
        public int compareTo (Cow other)
        {
            return other.seniority - seniority;
        }
    }

    static class timeCow implements Comparable<timeCow>
    {
        int s, a, d;
        public timeCow(int s, int a, int d)
        {
            this.s = s;
            this.a = a;
            this.d = d;
        }

        public int compareTo(timeCow other)
        {
            return a - other.a;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("convention2.in"));
        PrintWriter out = new PrintWriter(new File("convention2.out"));
        // first make array of timecows then sort and add to waiting as cows
        int n = in.nextInt();
        PriorityQueue<Cow> waiting = new PriorityQueue<Cow>();
        timeCow[] order = new timeCow[n];
        
        for (int i = 0; i < n; i++)
        {
            int a = in.nextInt(), t = in.nextInt();
            order[i] = new timeCow(-1 * i, a, t);
        }

        Arrays.sort(order);
        Cow current = new Cow(order[0].s, order[0].a, order[0].d);
        int t = order[0].a;
        boolean[] added = new boolean[n];
        added[0] = true;
        int count = 0;
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            
            t += current.duration;
            for (int j = count; order[j].a <= t; j++)
            {
                if (!added[j])
                    waiting.add(new Cow(order[j].s, order[j].a, order[j].d));
                added[j] = true;
                count = j;
            }
            ans = Math.max(ans, t - current.arrival);
            current = waiting.poll();
        }
        out.println(ans);
        out.close();
    }
}
