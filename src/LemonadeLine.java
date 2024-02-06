import java.util.*;
import java.io.*;

public class LemonadeLine {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("lemonade.in"));
        PrintWriter out = new PrintWriter(new File("lemonade.out"));

        int n = in.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i < n; i++)
        {
            cows[i] = in.nextInt();
        }
        Arrays.sort(cows);
        int a = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            if(cows[i] >= n - 1 - i)
                a++;
            else 
                break;
        }
        out.println(a);
        out.close();
    }
}
