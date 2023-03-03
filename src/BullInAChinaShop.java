import java.util.*;
import java.io.*;

public class BullInAChinaShop { //truly an unhinged problem
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("bcs.in"));
        int n = in.nextInt(), k = in.nextInt();
        char[][] figurine = new char[n][n];
        char[][][] pieces = new char[k][n][n];

        for (int i = 0; i < n; i++)
        {
            figurine[i] = in.next().toCharArray();
        }
        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < n; j++)
            {
                pieces[i][j] = in.next().toCharArray();
            }
        }

        for (int i = 0; i < k - 1; i++)
        {
            for (int j = i + 1; j < k; j++)
            {
                char[][] piece1 = pieces[i];
                char[][] piece2 = pieces[j];
                for (int sx = 1 - n; sx < n; sx++)
                {

                }
            }
        }
    }

    public static boolean equals(char[][] a, char[][] b)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (!(a[i][j] == b[i][j]))
                    return false;
            }
        }
        return true;
    }

}
