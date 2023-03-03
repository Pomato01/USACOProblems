import java.util.Scanner;
import java.util.Arrays;
public class DiamondCollector {
    public static void main(String[] args) {
        // easy af
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = in.nextInt();
        Arrays.sort(d);
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < d.length - 1)
        {
            if (d[j + 1] - d[i] <= k)
                j++;
            else
                i++;
            if (j - i + 1 > max)
                max = j - i + 1;
        }
        System.out.println(max);
    }
}
