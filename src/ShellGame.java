import java.util.*;
import java.io.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("shell.in"));
        PrintWriter out = new PrintWriter(new File("shell.out"));
        int n = in.nextInt(), temp, check;
        int[][] s = new int[n][3];

        int[] c = {0, 0, 0};
        int[] sim = {1, 2, 3};
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                s[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < s.length; i++)
        {
            temp = sim[s[i][0] - 1];
            sim[s[i][0] - 1] = sim[s[i][1] - 1];
            sim[s[i][1] - 1] = temp;

            check = sim[s[i][2] - 1];
            c[check - 1]++;
        }
        Arrays.sort(c);
        out.println(c[2]);
        out.close();
    }
}
