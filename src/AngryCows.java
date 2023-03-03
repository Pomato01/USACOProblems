import java.util.*;
import java.io.*;

public class AngryCows {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("angry.in"));
        PrintWriter out = new PrintWriter(new File("angry.out"));

        int n = in.nextInt();
        int max = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);

        for (int i = 0; i < n; i++)
        {
            int blast = 1;
            int front = i;
            int back = i;
            int score = 1;
            while (blast != 0)
            {
                int ifront = front;
                for (int j = ifront + 1; j < a.length && a[j] <= a[ifront] + blast; j++)
                {
                    score++;
                    //System.out.println("" + i + " " + j);
                    front = j;
                }
                if (ifront == front)
                    blast = 0;
                else
                    blast++;
            }
            blast = 1;
            while (blast != 0)
            {
                int iback = back;
                for (int j = iback - 1; j >= 0 && a[j] >= a[iback] - blast; j--)
                {
                    score++;
                    //System.out.println("" + i + " " + j);
                    back = j;
                }
                if (iback == back)
                    blast = 0;
                else
                    blast++;
            }
            // if (score >= max)
            //     System.out.println(i + " " + score);
            max = Math.max(score, max);
        }
        out.println(max);
        out.close();
    }
}
