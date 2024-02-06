import java.util.*;
import java.io.*;

public class TrianglesSilver {
    static class PairX implements Comparable<PairX>
    {
        int x, y, i;
        public PairX (int x, int y, int i)
        {
            this.x = x;
            this.y = y;
            this.i = i;
        }

        @Override
        public int compareTo(PairX other)
        {
            if (other.y != y)
                return y - other.y;
            return x - other.x;
        }

        @Override
        public String toString()
        {
            return "{" + x + ", " + y + "}";
        }
    }
    static class PairY implements Comparable<PairY>
    {
        int x, y, i;
        public PairY (int x, int y, int i)
        {
            this.x = x;
            this.y = y;
            this.i = i;
        }

        @Override
        public int compareTo(PairY other)
        {
            if (other.x != x)
                return x - other.x;
            return y - other.y;
        }

        @Override
        public String toString()
        {
            return "{" + x + ", " + y + "}";
        }
    }
    static PairX[] pX;
    static PairY[] pY;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("triangles.in"));
        PrintWriter out = new PrintWriter(new File("triangles.out"));
        n = in.nextInt();

        pX = new PairX[n];
        pY = new PairY[n];
        int[][] M = new int[n][2];

        for (int i = 0; i < n; i++)
        {
            int x = in.nextInt(), y = in.nextInt();
            pX[i] = new PairX(x, y, i);
            pY[i] = new PairY(x, y, i);
        }

        Arrays.sort(pX);
        Arrays.sort(pY);

        int[] iX = new int[n];
        int[] iY = new int[n];

        iX[0] = diff(0, 'x');
        iY[0] = diff(0, 'y');

        // int c = pX[0].y;
        // int pl = iX[0];
        // for (int i = 1; i < n; i++) // iX
        // {
        //     if (pX[i].y != c)
        //     {
        //         c = pX[i].y;
        //         iX[i] = diff(i, 'x');
        //     }
        //     else 
        //     {
        //         iX[i] = iX[i - 1] + ((pX[i].x - pX[i - 1].x) * ((2*i) - n));
        //     }
        //     M[pX[i].i][0] = iX[i];
        // }
        // c = pX[0].x;
        // for (int i = 1; i < n; i++) // iY
        // {
        //     if (pY[i].x != c)
        //     {
        //         c = pY[i].x;
        //         iY[i] = diff(i, 'y');
        //     }
        //     else 
        //     {
        //         iY[i] = iY[i - 1] + ((pY[i].y - pY[i - 1].y) * ((2*i) - n));
        //     }
        //     M[pY[i].i][1] = iY[i];
        // }

        for (int i = 0; i < n; i++)
        {
            M[pX[i].i][0] = diff(i, 'x');
            M[pY[i].i][1] = diff(i, 'y');
        }

        for (int[] w : M)
        {
            System.out.println(Arrays.toString(w));
        }

        long a = 0;
        for (int i = 0; i < n; i++)
        {
            a += (M[i][0] * M[i][1]);
            a %= (Math.pow(10, 9) + 7);
        }
        out.println(a);
        out.close();
    }

    static int diff (int i, char t)
    {
        if (t == 'x')
        {
            int a = 0;
            for (int j = 0; j < n; j++)
            {
                if (pX[j].y == pX[i].y)
                    a += Math.abs(pX[j].x - pX[i].x);
            }
            return a; 
        }
        else 
        {
            int a = 0;
            for (int j = 0; j < n; j++)
            {
                if (pY[j].x == pY[j].x)
                    a += Math.abs(pY[j].y - pY[i].y);
            }
            return a; 
        }
    }
    // static int diff1 (int i, char t)
    // {
    //     if (t == 'x')
    //     {
    //         int a = 0;
    //         for (int j = i; j < n; j++)
    //         {
    //             if (pX[j].y != pX[i].y)
    //                 break;
    //             a += Math.abs(pX[j].x - pX[i].x);
    //         }
    //         return a; 
    //     }
    //     else 
    //     {
    //         int a = 0;
    //         for (int j = i; j < n; j++)
    //         {
    //             if (pY[j].x != pY[i].x)
    //                 break;
    //             a += Math.abs(pY[j].y - pY[i].y);
    //         }
    //         return a; 
    //     }
    // }
}
