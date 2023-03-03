import java.util.*;
import java.io.*;

public class Hoofball { //idek
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("hoofball.in"));
        PrintWriter out = new PrintWriter (new File("hoofball.out"));

        int n = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++)
        {
            p[i] = in.nextInt();
        }
        Arrays.sort(p);
        boolean[] right = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                right[i] = true;
                continue;
            }
            if (i == n - 1)
            {
                right[i] = false;
                break;
            }
            if (p[i + 1] - p[i] < p[i] - p[i - 1])
            {
                right[i] = true;
            }
            else
            {
                right[i] = false;
            }
        }
        // boolean[] right = {true, false, false, false, true, false};
        // n = right.length;
        int count = 0;
        if (n < 3)
        {
            out.println(1);
            out.close();
            return;
        }
        int i = 0;
        outerloop:
        while (true)
        {
            count++;
            if (right[i])
            {
                
                while (right[i])
                {
                    i++;
                    if (i == n - 1)
                        break outerloop;
                }
                i++;
                if (i == n - 1)
                    break outerloop;
            }
            else
            {
                while (!right[i])
                {
                    i++;
                    if (i == n - 1)
                        break outerloop;
                }
                if (i == n - 1)
                    break outerloop;
            }
        }
        out.println(count);
        out.close();
    }
}
