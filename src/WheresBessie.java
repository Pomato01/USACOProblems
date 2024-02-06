import java.util.*;
import java.io.*;

public class WheresBessie { //5/10
    static char[][] grid;
    static boolean[][] visited;
    static int[][] findU;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("where.in"));
        PrintWriter out = new PrintWriter(new File("where.out"));
        n = in.nextInt();
        grid = new char[n][n];
        findU = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            grid[i] = in.next().toCharArray();
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                findUnion(i, j, (i * n) + j, grid[i][j]);
            }
        }
        ArrayList<Coord> PCLs = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int x = i; x < n; x++)
                {
                    outerloop:
                    for (int y = j; y < n; y++)
                    {
                        if (PCL(i, j, x, y))
                        {
                            Coord temp = new Coord(i, j, x, y);
                            for (int w = 0; w < PCLs.size(); w++)
                            {
                                if (PCLs.get(w).contains(temp))
                                {
                                    continue outerloop;
                                }
                                if (temp.contains(PCLs.get(w)))
                                {
                                    PCLs.remove(w);
                                    w--;
                                }
                            }
                            PCLs.add(temp);
                        }
                            
                    }
                }
            }
        }
        int a = 0;
        for (int i = 0; i < PCLs.size(); i++)
        {
            boolean add = true;
            for (int j = 0; j < PCLs.size(); j++)
            {
                if (i != j && PCLs.get(j).contains(PCLs.get(i)))
                    add = false;
            }
            if (add)
                a++;
        }
        out.println(a);
        out.close();
    }
    
    static boolean PCL (int x1, int y1, int x2, int y2)
    {
        char first = grid[x1][y1];
        HashSet<Integer> f = new HashSet();
        char second = '!';
        HashSet<Integer> s = new HashSet();
        for (int i = x1; i <= x2; i++)
        {
            for (int j = y1; j <= y2; j++)
            {
                if (grid[i][j] != first)
                    second = grid[i][j];
            }
        }
        if (second == '!')
            return false;
        // take care of number of regions requirement
        for (int i = x1; i <= x2; i++)
        {
            for (int j = y1; j <= y2; j++)
            {
                if (grid[i][j] == first)
                    f.add(findU[i][j]);
                else if (grid[i][j] == second)
                    s.add(findU[i][j]);
                else 
                    return false;
            }
        }
        if (f.size() != 1 && s.size() != 1)
            return false;
        return f.size() > 1 || s.size() > 1;
    }

    static class Coord
    {
        int x1, y1, x2, y2;
        public Coord(int x1, int y1, int x2, int y2)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        public boolean contains(Coord other)
        {
            return x1 <= other.x1 && y1 <= other.y1 && x2 >= other.x2 && y2 >= other.y2;
        }
        @Override
        public boolean equals(Object other)
        {
            Coord o = (Coord)other;
            return o.x1 == x1 && o.y1 == y1 && o.x2 == x2 && o.y2 == y2;
        }
        public int hashCode()
        {
            return (x1 * n * n * n) + (y1 * n * n) + (x2 * n) + y2;
        }
    }

    static void findUnion(int i, int j, int l, char val)
    {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] != val)
            return;
        visited[i][j] = true;
        findU[i][j] = l;
        findUnion(i - 1, j, l, val);
        findUnion(i + 1, j, l, val);
        findUnion(i, j - 1, l, val);
        findUnion(i, j + 1, l, val);
    }
}
