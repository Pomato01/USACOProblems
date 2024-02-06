import java.util.*;
import java.io.*;

public class Bakery{
    static class Triple implements Comparable<Triple>
    {
        int x, y, t;
        public Triple(int x, int y, int t)
        {
            this.x = x;
            this.y = y;
            this.t = t;
        }

        public int compareTo(Triple other)
        {
            return t - other.t;
        }
    }

    static boolean possible(Triple a, Triple b)
    {
        int sDistance = (int)(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        int sTime = (int)(Math.pow(a.t - b.t, 2));
        return sTime >= sDistance;
    }

    static Triple[] grazings;
    // returns the first of two incidents to be compared
    static int search (int start, int end, int t)
    {
        if (t <= grazings[0].t)
            return 0;
        if (t >= grazings[grazings.length - 1].t)
            return grazings.length - 1;
        int mid = (start  + end)/2;
        if (grazings[mid].t <= t && grazings[mid + 1].t >= t)
            return mid;
        else if (t > grazings[mid].t)
            return search(mid + 1, end, t);
        else 
            return search(start, mid - 1, t);
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt(), n = in.nextInt();
        grazings = new Triple[g];
        int answer = 0;
        for (int i = 0; i < g; i++)
        {
            grazings[i] = new Triple(in.nextInt(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(grazings);
        for (int i = 0; i < n; i++)
        {
            Triple Cow = new Triple(in.nextInt(), in.nextInt(), in.nextInt());
            int ind = search(0, g - 1, Cow.t);
            if (ind == g - 1 && possible(Cow, grazings[ind]))
                answer++;
            else if (possible(grazings[ind], Cow) && possible(grazings[ind + 1], Cow))
                answer++;
        }
        System.out.println(n - answer);
        in.close();
    }
}
// public class Bakery {
//     static class Cow implements Comparable<Cow>
//     {
//         int x;
//         int y;
//         int t;
//         public Cow (int x, int y, int t)
//         {
//             this.x = x;
//             this.y = y;
//             this.t = t;
//         }

//         public int compareTo(Cow other)
//         {
//             return other.t - this.t;
//         }
        
//     }
//     static Cow[] grazings;
//     static Cow[] cows;
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         int g = in.nextInt(), n = in.nextInt();
//         grazings = new Cow[g];
//         cows = new Cow[n];
//         boolean[] proven = new boolean[n];

//         for (int i = 0; i < g; i++)
//         {
//             grazings[i] = new Cow(in.nextInt(), in.nextInt(), in.nextInt());
//         }
//         for (int i = 0; i < n; i++)
//         {
//             cows[i] = new Cow(in.nextInt(), in.nextInt(), in.nextInt());
//         }

//         Arrays.sort(grazings);
//         Arrays.sort(cows);
//         int a = 0;
        
//         for (int i = 0; i < n; i++)
//         {
//             int start = startSearch(cows[i].t);
//             int end = startSearch(cows[i].t);
//             boolean p;
//             if (start == -1)
//             {
//                 p = possible(cows[i], grazings[0], grazings[0]);
//             }
//             else if (end == -1)
//             {
//                 p = possible(grazings[grazings.length - 1], cows[i], cows[i]);
//             }
//             else
//             {
//                 p = possible(grazings[start], cows[i], grazings[end]);
//             }
//             if (p && !proven[i])
//             {
//                 proven[i] = true;
//                 a++;
//             }
//         }
//         System.out.println(a);
//     }

//     static int startSearch(int a)
//     {
//         for (int i = 0; i < grazings.length; i++)
//         {
//             if (grazings[i].t >= i)
//             {
//                 return i - 1;
//             }
//         }
//         return grazings.length - 1;
//     }
//     static int endSearch(int a)
//     {
//         int s = startSearch(a);
//         if (s == grazings.length - 1)
//         {
//             return -1;
//         }
//         return s + 1;
//     }

//     static boolean possible(Cow a, Cow b, Cow c)
//     {
//         double distance = Math.pow(a.x - b.x, 2) + Math.pow(a.y-b.y, 2);
//         distance += Math.pow(b.x-c.x,2) + Math.pow(b.y-c.y,2);
//         double possibleD = Math.pow(c.t - a.t, 2);
//         return distance <= possibleD;
//     }
// }
