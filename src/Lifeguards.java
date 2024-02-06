import java.util.*;
import java.io.*;

public class Lifeguards {
    static class Event implements Comparable<Event>
    {
        int t;
        int guard;
        boolean start;
        public Event(int guard, int t, boolean start)
        {
            this.t = t;
            this.guard = guard;
            this.start = start;
        }
        public int compareTo(Event other)
        {
            return t - other.t;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new File("lifeguards.out"));

        int n = in.nextInt();
        Event[] shifts = new Event[n * 2];
        for (int i = 0; i < n; i++)
        {
            shifts[i * 2] = new Event(i, in.nextInt(), true);
            shifts[i * 2 + 1] = new Event(i, in.nextInt(), false);
        }
        int[] a = new int[n];
        Arrays.sort(shifts);
        ArrayList<Integer> currL = new ArrayList<Integer>();
        int totalCover = 0;
        for (int i = 0; i < shifts.length; i++)
        {
            if (currL.size() == 1)
                a[currL.get(0)] += shifts[i].t - shifts[i - 1].t;
            if (currL.size() != 0)
                totalCover += shifts[i].t - shifts[i - 1].t;
            if (shifts[i].start)
                currL.add(shifts[i].guard);
            else
            {
                int g = shifts[i].guard;
                for (int j = 0; j < currL.size(); j++)
                {
                    if (currL.get(j) == g)
                    {
                        currL.remove(j);
                        break;
                    }
                }
            }
        }

        Arrays.sort(a);
        out.println(totalCover - a[0]);
        out.close();

        // int n = in.nextInt();

        // int[][] shifts = new int[n][2];
        // for (int i = 0; i < n; i++)
        // {
        //     shifts[i][0] = in.nextInt();
        //     shifts[i][1] = in.nextInt();
        // }

        // int[] prel = new int[1000000001];
        // int[] l = new int[1000000001];
        
        // for (int i = 0; i < n; i++)
        // {
        //     prel[shifts[i][0]]++;
        //     prel[shifts[i][1]]--;
        // }
        // l[0] = prel[0];
        // int[] preLoss = new int[1000000001];
        // int a = 0;
        
        // for (int i = 1; i < l.length; i++)
        // {
        //     l[i] = l[i - 1] + prel[i];
        // }
        
        // for (int i = 0; i < l.length; i++)
        // {
        //     if (l[i] > 0)
        //         a++;
        // }
        
        // for (int i = 0; i < l.length; i++)
        // {
        //     if (l[i] == 1)
        //     {
        //         preLoss[i]++;
        //     }
        // }
        // int[] loss = new int[l.length];
        // loss[0] = preLoss[0];
        // for (int i = 1; i < loss.length; i++)
        // {
        //     loss[i] = loss[i - 1] + preLoss[i];
        // }
        // int minLoss = a;
        // for (int i = 0; i < n; i++)
        // {
        //     int start = shifts[i][0];
        //     int end = shifts[i][1];
        //     if (start == 0)
        //         minLoss = Math.min(loss[end - 1], minLoss);
        //     else
        //         minLoss = Math.min(loss[end - 1] - loss[start - 1], minLoss);
        // }
        
        
        // System.out.println(a + " " + minLoss);
        // for (int i = 0; i < 10; i++)
        // {
        //     System.out.print(loss[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < 10; i++)
        // {
        //     System.out.print(preLoss[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < 10; i++)
        // {
        //     System.out.print(l[i] + " ");
        // }
        // System.out.println();

        
    }
}
