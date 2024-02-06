import java.util.*;
import java.io.*;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("speeding.in"));
        PrintWriter out = new PrintWriter(new File("speeding.out"));

        int n = in.nextInt(), m = in.nextInt();
        int a = 0;
        int[] limit = new int[100];
        int[] speed = new int[100];
        int i = 0;
        while (i < 100)
        {
            int len = in.nextInt();
            int val = in.nextInt();
            for (int j = 0; j < len; j++)
            {
                limit[i] = val;
                i++;
            }
        }
        i = 0;
        while (i < 100)
        {
            int len = in.nextInt();
            int val = in.nextInt();
            for (int j = 0; j < len; j++)
            {
                speed[i] = val;
                i++;
            }
        }
        for (int j = 0; j < 100; j++)
        {
            if (speed[j] > limit[j])
            {
                a = Math.max(a, speed[j] - limit[j]);
            }
        }
        out.println(a);
        out.close();
    }
}
