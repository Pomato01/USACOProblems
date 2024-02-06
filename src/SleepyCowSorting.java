import java.util.*;
import java.io.*;

public class SleepyCowSorting {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("sleepy.in"));
        PrintWriter out = new PrintWriter(new File("sleepy.out"));

        int N = in.nextInt();
        int[] line = new int[N];
        for (int i = 0; i < N; i++)
        {
            line[i] = in.nextInt();
        }
        int lastUnsorted = N - 1;
        for (int i = 1; i < N; i++)
        {
            if (line[i] < line[i - 1])
                lastUnsorted = i;
        }
        
        out.println(lastUnsorted);
        out.close();
    }
}
