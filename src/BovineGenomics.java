import java.util.*;
import java.io.*;

public class BovineGenomics {
    static char[][] spotty;
    static char[][] plain;
    static HashSet<Tuple> sGenome;
    static int n, m;
    
    static class Tuple
    {
        int a, b, c;
        public Tuple(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int hashCode()
        {
            return (a * 256 * 256) + (b * 256) + c;
        }
        public boolean equals(Object other)
        {
            return ((Tuple)other).a == a && ((Tuple)other).b == b && ((Tuple)other).c == c;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cownomics.in"));
        PrintWriter out = new PrintWriter(new File("cownomics.out"));
        n = in.nextInt(); m = in.nextInt(); int a = 0;

        spotty = new char[n][m];
        plain = new char[n][m];
        for (int i = 0; i < n; i++)
            spotty[i] = in.next().toCharArray();
        for (int i = 0; i < n; i++)
            plain[i] = in.next().toCharArray();
        
        for (int i = 0; i < m; i++)
        {
            for (int j = i + 1; j < m; j++)
            {
                for (int k = j + 1; k < m; k++)
                {
                    if (accounts(i, j, k))
                        a++;
                }
            }
        }

        out.println(a);
        out.close();
    }
    static boolean accounts(int a1, int b, int c)
    {
        sGenome = new HashSet<Tuple>();
        for (int i = 0; i < n; i++)
        {
            Tuple temp = new Tuple(spotty[i][a1], spotty[i][b], spotty[i][c]);
            sGenome.add(temp);
        }
        for (int i = 0; i < n; i++)
        {
            Tuple temp = new Tuple(plain[i][a1], plain[i][b], plain[i][c]);
            if (sGenome.contains(temp))
                return false;
        }
        return true;
    }
}
