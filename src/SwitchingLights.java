import java.util.*;
import java.io.*;

// public class SwitchingLights { //bfs

//     static class Pair
//     {
//         int x, y;
//         public Pair(int x, int y)
//         {
//             this.x = x;
//             this.y = y;
//         }
//     }

//     static class Room 
//     {
//         int Rx, Ry;
//         ArrayList<Pair> s;
//         boolean light;
//         public Room(int Rx, int Ry)
//         {
//             this.Rx = Rx;
//             this.Ry = Ry;
//             light = false;
//             s = new ArrayList<>();
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         Scanner in = new Scanner(new File("lightson.in"));
//         PrintWriter out = new PrintWriter(new File("lightson.out"));
//         int n = in.nextInt(), m = in.nextInt(), a = 1;
//         boolean[][] visited = new boolean[n][n];
//         Room[][] barn = new Room[n][n];

//         for (int i = 0; i < n; i++)
//         {
//             for (int j = 0; j < n; j++)
//             {
//                 barn[i][j] = new Room(i, j);
//             }
//         }
//         for (int i = 0; i < m; i++)
//         {
//             barn[in.nextInt() - 1][in.nextInt() - 1].s.add(new Pair(in.nextInt() - 1, in.nextInt() - 1));
//         }
//         barn[0][0].light = true;

//         Queue<Room> bfs = new LinkedList();
//         bfs.offer(barn[0][0]);
//         while (!bfs.isEmpty())
//         {
//             Room temp = bfs.poll();
//             if (!temp.light)
//             {
//                 continue;
//             }
                
//             visited[temp.Rx][temp.Ry] = true;
//             for (Pair x : temp.s)
//             {
//                 if (!barn[x.x][x.y].light)
//                 {
//                     System.out.println(x.x + " " + x.y);
//                     a++;
//                 }
//                 barn[x.x][x.y].light = true;
//             }
//             if (temp.Rx != 0 && !visited[temp.Rx - 1][temp.Ry])
//                 bfs.offer(barn[temp.Rx - 1][temp.Ry]);
//             if (temp.Rx != n - 1 && !visited[temp.Rx + 1][temp.Ry])
//                 bfs.offer(barn[temp.Rx + 1][temp.Ry]);
//             if (temp.Ry != 0 && !visited[temp.Rx][temp.Ry - 1])
//                 bfs.offer(barn[temp.Rx][temp.Ry - 1]);
//             if (temp.Ry != n - 1 && !visited[temp.Rx][temp.Ry + 1])
//                 bfs.offer(barn[temp.Rx][temp.Ry + 1]);
//         }
//         out.print(a);
//         out.close();
//     }
// }

public class SwitchingLights
{
    static class Pair
    {
        int x, y;
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Room 
    {
        ArrayList<Pair> s;
        public Room()
        {
            s = new ArrayList<>();
        }
    }
    
    static boolean[][] on;
    static boolean[][] visited;
    static boolean[][] tvisited;
    static Room[][] barn;
    static int n;
    static int a;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("lightson.in"));
        PrintWriter out = new PrintWriter(new File("lightson.out"));
        n = in.nextInt(); int m = in.nextInt();
        on = new boolean[n][n]; visited = new boolean[n][n]; barn = new Room[n][n];
        a = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                barn[i][j] = new Room();
            }
        }
        for (int i = 0; i < m; i++)
        {
            barn[in.nextInt() - 1][in.nextInt() - 1].s.add(new Pair(in.nextInt() - 1, in.nextInt() - 1));
        }

        visited[0][0] = true;
        on[0][0] = true;
        dfs(0, 0);
        out.println(a);
        out.close();
    }

    static void dfs(int x, int y)
    {
        tvisited = new boolean[n][n];
        update(0, 0);
        if (visited[x][y])
        {
            for (Pair p : barn[x][y].s)
            {
                if (!on[p.x][p.y])
                {
                    a++;
                    on[p.x][p.y] = true;
                }
            }
            for (Pair p : barn[x][y].s)
            {
                dfs(p.x, p.y);
            }
        }
    }

    static void update(int x, int y)
    {
        tvisited[x][y] = true;
        visited[x][y] = true;
        if (x != n - 1 && !tvisited[x + 1][y] && on[x + 1][y])
            update(x + 1, y);
        if (x != 0 && !tvisited[x - 1][y] && on[x - 1][y])
            update(x - 1, y);
        if (y != n - 1 && !tvisited[x][y + 1] && on[x][y + 1])
            update(x, y + 1);
        if (y != 0 && !tvisited[x][y - 1] && on[x][y - 1])
            update(x, y - 1);
    }

}
