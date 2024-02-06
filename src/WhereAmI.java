import java.util.Scanner;
import java.io.*;

public class WhereAmI {
    public static void main(String[] args) throws IOException {
        // not best complexity (O(n^3)), but got the job done easily
        Scanner in = new Scanner (new File("whereami.in"));
        PrintWriter out = new PrintWriter(new File("whereami.out"));
        int n = in.nextInt();
        String f = in.next();
        int max = 1;
        String temp = f.substring(0, 1);
        for (int i = 0; i <= n / 2; i++)
        {
            for (int j = 0; j <= n - i; j++)
            {
                for (int k = 0; k < j - i; k++)
                {
                    if (f.substring(j, j + i).equals(f.substring(k, k + i)))
                        max = i + 1;
                }
            }
        }
        out.println(max);
        out.close();
    }
}
