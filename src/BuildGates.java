import java.util.*;
import java.io.*;

public class BuildGates {
    static class Pair
    {
        int x, y;
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] p;
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("gates.in"));
        PrintWriter out = new PrintWriter(new File("gates.out"));
        n = in.nextInt();
        char[] d = in.next().toCharArray();
        p = new boolean[n*4][n*4];
        visited = new boolean[n*4][n*4];
        int cX;
        if (d[0] == 'N' || d[0] == 'S')
            cX = n*2;
        else 
            cX = n*2 + 1;
        int cY = cX - 1, a = -1;
        p[cX][cY] = true;

        char current = d[0];
        for (int i = 0; i < n; i++)
        {
            if (current == 'N')
            {
                if (d[i] == 'N')
                    cY += 2;
                else if (d[i] == 'S')
                    cY -= 2;
                else if (d[i] == 'E')
                {
                    cX++;
                    cY++;
                }
                else if (d[i] == 'W')
                {
                    cX--;
                    cY++;
                }
            }
            else if (current == 'S')
            {
                if (d[i] == 'N')
                    cY += 2;
                else if (d[i] == 'S')
                    cY -= 2;
                else if (d[i] == 'E')
                {
                    cX++;
                    cY--;
                }
                else if (d[i] == 'W')
                {
                    cX--;
                    cY--;
                }
            }
            else if (current == 'E')
            {
                if (d[i] == 'N')
                {
                    cX++;
                    cY++;
                }
                else if (d[i] == 'S')
                {
                    cX++;
                    cY--;
                }
                else if (d[i] == 'E')
                    cX += 2;
                else if (d[i] == 'W')
                    cY -= 2;
            }
            else if (current == 'W')
            {
                if (d[i] == 'N')
                {
                    cX--;
                    cY++;
                }
                else if (d[i] == 'S')
                {
                    cX--;
                    cY--;
                }
                else if (d[i] == 'E')
                    cX += 2;
                else if (d[i] == 'W')
                    cY -= 2;
            }
            current = d[i];
            p[cX][cY] = true;
        }
        // for (int i = 0; i < n*4; i += 2)
        // {
        //     for (int j = 0; j < n*4; j += 2)
        //     {
        //         if (fill(i, j))
        //             a++;
        //     }
        // }
        fill(0, 0);
        for (boolean[] w : p)
        {
            for (boolean x : w)
            {
                if (x)
                    System.out.print(1);
                else 
                    System.out.print(0);
            }
            System.out.println();
        }
        System.out.println();
        for (boolean[] w : visited)
        {
            for (boolean x : w)
            {
                if (x)
                    System.out.print(1);
                else 
                    System.out.print(0);
            }
            System.out.println();
        }
        for (int i = 1; i < p.length - 1; i++)
        {
            for (int j = 1; j < p[i].length - 1; j++)
            {
                if (p[i + 1][j] && p[i - 1][j] && p[i][j + 1] && p[i][j - 1])
                    System.out.println(i + " " + j);
            }
        }
        out.println(a);
        out.close();
    }
    static Queue<Pair> bfs;

    static boolean fill(int x, int y)
    {
        if (visited[x][y])
            return false;
        bfs = new LinkedList<Pair>();
        bfs.add(new Pair(x, y));
        int size = 0;
        while(!bfs.isEmpty())
        {
            Pair temp = bfs.poll();
            visited[temp.x][temp.y] = true;
            x = temp.x; y = temp.y;

            if (x < n*4 - 2 && !visited[x + 2][y] && !p[x + 1][y])
            {
                bfs.offer(new Pair(x + 2, y));
                visited[x + 2][y] = true;
            }
                
            if (x > 1 && !visited[x - 2][y] && !p[x - 1][y])
            {
                bfs.offer(new Pair(x - 2, y));
                visited[x - 2][y] = true;
            }
                
            if (y < n*4 - 2 && !visited[x][y + 2] && !p[x][y + 1])
            {
                bfs.offer(new Pair(x, y + 2));
                visited[x][y + 2] = true;
            }
                
            if (y > 1 && !visited[x][y - 2] && !p[x][y - 1])
            {
                bfs.offer(new Pair(x, y - 2));
                visited[x][y - 2] = true;
            }
        }
        return true;
    }

    
    // static int fill(int x, int y)
    // {
    //     if (visited[x][y])
    //         return 0;
    //     visited[x][y] = true;
    //     int temp = 1;
        // if (x < 4000 && !visited[x + 2][y] && !p[x + 1][y])
        //     temp += fill(x + 2, y);
        // if (x > 1 && !visited[x - 2][y] && !p[x - 1][y])
        //     temp += fill(x - 2, y);
        // if (y < 4000 && !visited[x][y + 2] && !p[x][y + 1])
        //     temp += fill(x, y + 2);
        // if (y > 1 && !visited[x][y - 2] && !p[x][y - 1])
        //     temp += fill(x, y - 2);
    //     return temp;
    // }
}
