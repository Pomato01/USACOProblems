import java.util.*;
import java.io.*;

public class Cowlibi {
    static class Event implements Comparable<Event>
    {
        int x;
        int y;
        int t;
        public Event (int x, int y, int t)
        {
            this.x = x;
            this.y = y;
            this.t = t;
        }
        public int compareTo(Event other)
        {
            return t - other.t;
        }
    }
    static Event[] grazings;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cowlibi.in"));
        int g = in.nextInt(), n = in.nextInt();
        grazings = new Event[g];
        int a = 0;
        for (int i = 0; i < g; i++)
        {
            grazings[i] = new Event(in.nextInt(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(grazings);
        for (int i = 0; i < n; i++)
        {
            Event temp = new Event(in.nextInt(), in.nextInt(), in.nextInt());
            if (reaches(temp))
                a++;
        }
        System.out.println(a);
    }

    static boolean reaches (Event a) 
    {
        if (a.t > grazings[grazings.length - 1].t)
        {
            return r1(grazings[grazings.length - 1], a);
        }
        else if (a.t < grazings[0].t)
        {
            return r1(a, grazings[0]);
        }
        else
        {
            int p = binarySearch(0, grazings.length, a.t);
            return r2(grazings[p], a, grazings[p + 1]);
        }
    }
    
    static boolean r1 (Event a, Event b)
    {
        double d = (int)Math.pow(b.x - a.x, 2) + (int)Math.pow(b.y - a.y, 2);
        double t = b.t - a.t;
        return Math.pow(t, 2) >= d;
    }

    static boolean r2(Event a, Event b, Event c)
    {
        return r1(a, b) && r1(b, c);
    }

    static int binarySearch(int a, int b, int t)
    {
        int mid = (a + b)/2;
        if (b - a == 1)
        {
            
        }
        if (t > grazings[mid].t)
        {
            return binarySearch(mid, b, t);
        }
        if (t < grazings[mid].t)
        {
            return binarySearch(a, mid - 1, t);
        }
        return mid - 1;
    }
}
