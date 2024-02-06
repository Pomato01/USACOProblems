import java.util.*;
import java.io.*;

public class CycleCorrespondence {
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new File("cycorr.in"));
        n = in.nextInt(); k = in.nextInt();
        boolean[] used = new boolean[n];
        int[] aPos = new int[n];
        int[] bPos = new int[n];
        int total = n;
        int added = 0;
        Arrays.fill(aPos, -1);
        Arrays.fill(bPos, -1);
        

        for (int i = 0; i < k; i++)
        {
            int barn = in.nextInt() - 1;
            aPos[barn] = i;
            if (!used[barn])
                total --;
            used[barn] = true;
        }
        for (int i = 0; i < k; i++)
        {
            int barn = in.nextInt() - 1;
            bPos[barn] = i;
            if (!used[barn])
                total --;
            used[barn] = true;
        }

        int[] shifts = shiftsM(aPos, bPos);
        added = max(shifts);

        // System.out.println(Arrays.toString(shifts));

        Collections.reverse(Arrays.asList(bPos));

        shifts = shiftsM(aPos, bPos);
        added = Math.max(added, max(shifts));

        // System.out.println(Arrays.toString(shifts));

        System.out.println(total + added);
        // System.out.println(Arrays.toString(aPos));
        // System.out.println(Arrays.toString(bPos));
        // int[] a = {0, 1, 2, -1, -1, -1};
        // int[] b = {2, 0, 1, -1, -1, -1};
        // System.out.println(Arrays.toString(shiftsM(a, b)));
    }
    static int[] shiftsM (int[] aPos, int[] bPos)
    {
        int[] shifts = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (aPos[i] == -1 || bPos[i] == -1)
                continue;
            int shift = 0;
            if (aPos[i] > bPos[i])
                shift += k; // changed from n
            shift += bPos[i] - aPos[i];
            shifts[shift]++;
        }
        return shifts;
    }
    static int max(int[] a)
    {
        int mmax = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] > mmax)
                mmax = a[i];
        }
        return mmax;
    }
}
