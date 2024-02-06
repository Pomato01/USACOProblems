import java.util.*;
import java.io.*;

public class FieldReduction { //algorithm: find the 4 most extreme points from each side then iterate through them
    static class CowX implements Comparable<CowX>
    {
        int ID;
        int x, y;
        public CowX(int ID, int x, int y)
        {
            this.ID = ID;
            this.x = x;
            this.y = y;
        }
        public int compareTo(CowX other)
        {
            return x - other.x;
        }
        Cow toCow()
        {
            return new Cow(ID, x, y);
        }
    }
    static class CowY implements Comparable<CowY>
    {
        int ID;
        int x, y;
        public CowY(int ID, int x, int y)
        {
            this.ID = ID;
            this.x = x;
            this.y = y;
        }
        public int compareTo(CowY other)
        {
            return y - other.y;
        }
        Cow toCow()
        {
            return new Cow(ID, x, y);
        }
    }

    static class Cow
    {
        int ID;
        int x, y;
        public Cow(int ID, int x, int y)
        {
            this.ID = ID;
            this.x = x;
            this.y = y;
        }
        public String toString()
        {
            return "[" + x + ", " + y + "]";
        }
        @Override
        public boolean equals(Object other)
        {
            return ((Cow)other).ID == ID;
        }
        public int hashCode()
        {
            return x * 40000 + y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("reduce.in"));
        PrintWriter out = new PrintWriter(new File("reduce.out"));
        int n = in.nextInt(), a = Integer.MAX_VALUE;

        CowX[] cowsX = new CowX[n];
        CowY[] cowsY = new CowY[n];
        for (int i = 0; i < n; i++)
        {
            int x = in.nextInt(), y = in.nextInt();
            cowsX[i] = new CowX(i, x, y);
            cowsY[i] = new CowY(i, x, y);
        }
        Arrays.sort(cowsX); Arrays.sort(cowsY);
        Cow[][] p = new Cow[4][4]; // up down left right decreasing extremity
        for (int i = 0; i < 4; i++)
        {
            p[0][i] = cowsY[i].toCow();
            p[1][i] = cowsY[n - 1 - i].toCow();
            p[2][i] = cowsX[i].toCow();
            p[3][i] = cowsX[n - 1 - i].toCow();
        }
        int[] d;
        Cow[] c = new Cow[4];
        HashSet<Cow> sold;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 4; k++)
                {
                    d = new int[4];
                    d[i]++; d[j]++; d[k]++;
                    sold = new HashSet<Cow>();
                    for (int x = 0; x < 4; x++)
                    {
                        int allowed = d[x], z = 0;
                        while (z < 4)
                        {
                            if (sold.contains(p[x][z]))
                            {
                                z++;
                                continue;
                            }
                            if (allowed == 0)
                                break;
                            sold.add(p[x][z]);
                            allowed--;
                            z++;
                        }
                        c[x] = p[x][z];
                    }
                    //System.out.println(Arrays.toString(d) + "\n" + sold + "\n" + (c[1].y - c[0].y) * (c[3].x - c[2].x) + "\n" + Arrays.toString(c));
                    a = Math.min(a, (c[1].y - c[0].y) * (c[3].x - c[2].x));
                }
            }
        }
        out.println(a);
        out.close();
    }
}
