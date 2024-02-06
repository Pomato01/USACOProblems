import java.util.*;
import java.io.*;

public class BovineAcrobatics {
    static class Weight implements Comparable<Weight>
    {
        int w, a;
        public Weight(int w, int a)
        {
            this.a = a;
            this.w = w;
        }
        public int compareTo(Weight other)
        {
            return w - other.w;
        }

        public String toString()
        {
            return "[" + w + ", " + a + "]";
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("bovineacrobatics.in"));
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        Weight[] cows = new Weight[n];
        int total = 0;
        
        for (int i = 0; i < n; i++)
        {
            int w = in.nextInt(), a = in.nextInt();
            cows[i] = new Weight(w, a);
        }
        Arrays.sort(cows);

        for (int i = n - 1; i >= 0; i--)
        {
            int gNum = cows[n - 1].a; // get gNum for greedy and mutate
            innerloop:
            for (int j = i - 1; j >= 0; j--)
            {
                if (cows[j].w + k > cows[i].w)
                    continue innerloop;
                int remAmt = Math.min(Math.min(m, gNum), cows[j].a);
                total += remAmt;
                cows[j].a -= remAmt;
            }
            // check for m
            if (m < gNum)
            {
                // total += what they still get from g
                total += m;
                break;
            }
            else 
            {
                total += gNum;
                m -= gNum;
            }
            System.out.println(Arrays.toString(cows));
        }

        System.out.println(total);
    }
}
