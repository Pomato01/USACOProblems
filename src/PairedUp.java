import java.util.*;
import java.io.*;

public class PairedUp {
    static class Pair implements Comparable<Pair>
    {
        int amt, milk;
        public Pair(int x, int y)
        {
            this.amt = x;
            this.milk = y;
        }

        public int compareTo(Pair other)
        {
            return milk - other.milk;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("pairup.in"));
        PrintWriter out = new PrintWriter(new File("pairup.out"));

        int n = in.nextInt(), a = 0;
        Pair[] cows = new Pair[n];
        for (int i = 0; i < n; i++)
        {
            cows[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(cows);
        int i = 0, j = n - 1;
        while(j > i)
        {
            int f = Math.min(cows[i].amt, cows[j].amt);
            a = Math.max(a, cows[i].milk + cows[j].milk);
            cows[i].amt -= f;
            cows[j].amt -= f;
            if (cows[i].amt == 0)
                i++;
            if (cows[j].amt == 0)
                j--;
        }

        out.println(a);
        out.close();
    }
}
