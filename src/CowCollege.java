import java.util.*;

public class CowCollege {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] maxT = new long[n];
        for (int i = 0; i < n; i++)
        {
            maxT[i] = in.nextInt();
        }
        Arrays.sort(maxT);
        long max = 0;
        long tuition = 0;
        for (int i = 0; i < n; i++)
        {
            if (maxT[i] * (n - i) > max)
            {
                max = (maxT[i] * (n-i));
                tuition = maxT[i];
            }
        }
        System.out.println("" + max + " " + tuition);
    }
}
