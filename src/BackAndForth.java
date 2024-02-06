import java.util.*;
import java.io.*;

public class BackAndForth // never again
{
    private static HashSet<Integer> tanks = new HashSet<Integer>();
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("backforth.in"));
        PrintWriter out = new PrintWriter(new File("backforth.out"));

        int[] first = new int[11];
        int[] second = new int[11];
        first[10] = -1;
        second[10] = -1;
        for (int i = 0; i < 10; i++)
        {
            first[i] = in.nextInt();
        }
        for (int i = 0; i < 10; i++)
        {
            second[i] = in.nextInt();
        }
        baf(first, second, true, 0, 1000);
        out.println(tanks.size());
        out.println(Arrays.toString(tanks.toArray()));
        out.close();
    }

    public static void baf(int[] first, int[] second, boolean fts, int day, int tank1)
    {
        if (day == 4)
        {
            tanks.add(tank1);
            return;
        }
        if (fts)
        {
            int bucket = 0;
            for (int i = 0; i < first.length; i++)
            {
                if (first[i] != -1)
                {
                    bucket = first[i];
                    tank1 -= bucket;
                    first[i] = -1;
                    for (int j = 0; j < second.length; j++)
                    {
                        if (second[j] == -1)
                        {
                            second[j] = bucket;
                            break;
                        }
                    }
                    baf(first.clone(), second.clone(), false, day + 1, tank1);
                }
            }
        }
        else
        {
            int bucket = 0;
            for (int i = 0; i < second.length; i++)
            {
                if (second[i] != -1)
                {
                    bucket = second[i];
                    tank1 += bucket;
                    second[i] = -1;
                    for (int j = 0; j < first.length; j++)
                    {
                        if (first[j] == -1)
                        {
                            first[j] = bucket;
                            break;
                        }
                    }
                    baf(first.clone(), second.clone(), true, day + 1, tank1);
                }
            }
        }
    }
}