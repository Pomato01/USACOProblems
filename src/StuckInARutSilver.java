import java.util.*;

public class StuckInARutSilver {
    static char[] d;
    static int[] x;
    static int[] y;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        d = new char[n];
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (x[j] + y[j] > x[i] + y[i])
                    swap(i, j);
            }
        }
    }
    static void swap (int a, int b)
    {
        char temp = d[a];
        int temp1 = x[a];
        int temp2 = y[a];
        d[a] = d[b];
        x[a] = x[b];
        y[a] = y[b];
        d[b] = temp;
        x[b] = temp1;
        y[b] = temp2;
    }
}
