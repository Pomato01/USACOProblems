import java.util.*;
import java.io.*;

public class HPS { // 10/10
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("hps.in"));
        PrintWriter out = new PrintWriter(new File("hps.out"));
        int n = in.nextInt();
        char[] J = new char[n];
        for (int i = 0; i < n; i++)
            J[i] = in.next().charAt(0);
        int[] H = new int[n];
        int[] P = new int[n];
        int[] S = new int[n];
        switch(J[0])
        {
            case 'H':
            {
                H[0] = 1;
                break;
            }
            case 'P':
            {
                P[0] = 1;
                break;
            }
            case 'S':
            {
                S[0] = 1;
                break;
            }
        }
        for (int i = 1; i < n; i++)
        {
            H[i] = H[i - 1];
            P[i] = P[i - 1];
            S[i] = S[i - 1];
            switch(J[i])
            {
                
                case 'H':
                {
                    H[i]++;
                    break;
                }
                case 'P':
                {
                    P[i]++;
                    break;
                }
                case 'S':
                {
                    S[i]++;
                    break;
                }
            }
        }
        int a = 0;
        for (int i = 0; i < n; i++)
        {
            int p1 = Math.max(Math.max(H[i], P[i]), S[i]);
            int p2 = Math.max(Math.max(H[n - 1] - H[i], P[n - 1] - P[i]), S[n - 1] - S[i]);
            a = Math.max(a, p1 + p2);
        }
        // System.out.println(Arrays.toString(H));
        // System.out.println(Arrays.toString(P));
        // System.out.println(Arrays.toString(S));
        out.println(a);
        out.close();
    }
}
