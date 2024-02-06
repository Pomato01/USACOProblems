import java.util.*;
import java.io.*;

public class LivestockLineup {
    public static String[][] constraints;
    public static ArrayList<String[]> perms = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("lineup.in"));
        PrintWriter out = new PrintWriter(new File("lineup.out"));
        int n = in.nextInt();
        String[] cows = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
        constraints = new String[n][2];
        for (int i = 0; i < n; i++)
        {
            constraints[i][0] = in.next();
            for (int j = 0; j < 4; j++)
            {
                in.next();
            }
            constraints[i][1] = in.next();
        }
        Arrays.sort(cows);
        generatePermutations(cows, 0);
        int min = 0;
        for (int i = 0; i < perms.size(); i++)
        {
            if (lowerA(perms.get(i), perms.get(min)))
            {
                min = i;
            }
        }
        String[] ans = perms.get(min);
        for (String w : ans)
        {
            out.println(w);
        }
        out.close();
    }
    public static boolean lowerA (String[] a, String[] b)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i].compareTo(b[i]) > 0)
            {
                return false;
            }
            else if (a[i].compareTo(b[i]) < 0)
            {
                return true;
            }
        }
        return true;
    }
    public static void generatePermutations(String[] a, int index)
    {
        if (index == a.length)
        {
            boolean w = true;
            for (int i = 0; i < constraints.length; i++)
            {
                if (!isBeside(a, constraints[i][0], constraints[i][1]))
                {
                    w = false;
                }
            }
            if (w)
            {
                perms.add(a);
            }
            return;
        }
        for (int i = index; i < a.length; i++)
        {
            generatePermutations(swap(a, i, index), index + 1);
        }
    }
    public static String[] swap (String[] s, int a, int b)
    {
        String[] x = s.clone();
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
        return x;
    }
    public static boolean isBeside(String[] c, String a, String b)
    {
        int ind = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (c[i].equals(a))
            {
                ind = i;
            }
        }
        boolean before = ind > 0 && c[ind - 1].equals(b);
        boolean after = ind < c.length - 1 && c[ind + 1].equals(b);
        return before || after;
    }
}
