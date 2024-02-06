import java.util.*;
import java.io.*;

public class CCrossTheRoad {
    public static class Cow implements Comparable<Cow>
    {
        int a;
        int b;
        public Cow(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        public boolean works(int t)
        {
            return t <= b && t >= a;
        }
        public int compareTo(Cow other)
        {
            return b - other.b;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("helpcross.in"));
        PrintWriter out = new PrintWriter(new File("helpcross.out"));

        int c = in.nextInt();
        int n = in.nextInt();
        int[] t = new int[c];
        ArrayList<Cow> cows = new ArrayList<Cow>();
        for (int i = 0; i < c; i++)
        {
            t[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            cows.add(new Cow(in.nextInt(), in.nextInt()));
        }
        Collections.sort(cows);
        Arrays.sort(t);
        int a = 0;
        for (int i = 0; i < c; i++)
        {
            if (t[i] > cows.get(cows.size() - 1).b)
                break;
            for (int j = 0; j < cows.size(); j++)
            {
                if (cows.get(j).works(t[i]))
                {
                    a++;
                    cows.remove(j);
                    break;
                }
            }
        }
        out.println(a);
        out.close();
    }
}
