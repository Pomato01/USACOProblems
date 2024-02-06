import java.util.*;
import java.io.*;

public class ContaminatedMilk {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("badmilk.in"));
        PrintWriter out = new PrintWriter(new File("badmilk.out"));

        int N = in.nextInt(), 
        M = in.nextInt(), 
        D = in.nextInt(), 
        S = in.nextInt();
        int[][] drinks = new int[D][3];
        int[][] sick = new int[S][2];
        ArrayList<Integer> badmilks = new ArrayList<>();

        for (int i = 0; i < D; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                drinks[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < S; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                sick[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i <= M; i++)
        {
            int c = 0;
            boolean b = true;
            for (int j = 0; j < S; j++)
            {
                int person = sick[j][0];
                int time = sick[j][1];
                c = 0;
                for (int k = 0; k < D; k++)
                {
                    if (drinks[k][0] == person && drinks[k][1] == i && drinks[k][2] < time)
                    {
                        c++;
                    }
                }
                if (c == 0)
                    b = false;
            }
            if (b)
            {
                badmilks.add(i);
            }
        }
        boolean[] counter;
        int temp;
        int max = 0;
        for (int p : badmilks)
        {
            counter = new boolean[N + 1];
            for (int i = 0; i < D; i++)
            {
                if (drinks[i][1] == p)
                {
                    counter[drinks[i][0]] = true;
                }
            }
            temp = 0;
            for (boolean w : counter)
            {
                if (w)
                    temp++;
            }
            max = Math.max(max, temp);
        }
        out.println(max);
        out.close();
    }
}
