import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public class SleepyCowHerding {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new FileReader("herding.in")));
        PrintWriter out = new PrintWriter(new FileWriter("herding.out"));
        int[] a = new int[3];
        for (int i = 0; i < 3; i++)
            a[i] = in.nextInt();
        Arrays.sort(a);
        out.println(countMin(a[0], a[1], a[2]));
        out.println(countMax(a[0], a[1], a[2]));
        out.close();
    }
    
    public static int countMax (int a, int b, int c)
    {
        /* 
        if (b - a == 1 && c - b == 1)
        {
            return 0;
        }
        else if (b - a > c - b)
        {
            c = a + 1;
            return 1 + countMax(a, c, b);
        }
        else
        {
            a = c - 1;
            return 1 + countMax(b, a, c);
        }*/
        return Math.max(b - a, c - b) - 1;
    }

    public static int countMin (int a, int b, int c)
    {
        if (b - a == 1 && c - b == 1)
            return 0;
        else if (b - a == 2 || c - b == 2)
            return 1;
        else
            return 2;
    }
}
