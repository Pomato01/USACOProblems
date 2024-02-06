import java.util.*;
import java.io.*;

public class MultiplayerMoo {
    static class Pair
    {
        int x,y;
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("multimoo.in"));
        PrintWriter out = new PrintWriter(new File("multimoo.out"));
        int n = in.nextInt();
        int[][] board = new int[n][n];
        // two bfs algorithms, one for individuals & one for two cow teams
        // 8/10 cases, 2 TLEs
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = in.nextInt();
        Queue<Pair> bfs;
        boolean[][] visited = new boolean[n][n];
        int m1 = 0, m2 = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int first = board[i][j];
                
                bfs = new LinkedList<Pair>();
                bfs.offer(new Pair(i, j));
                int a = 0;
                while (!bfs.isEmpty())
                {
                    Pair temp = bfs.poll();
                    a++;
                    visited[temp.x][temp.y] = true;
                    if (temp.x > 0 && board[temp.x - 1][temp.y] == first && !visited[temp.x - 1][temp.y])
                    {
                        bfs.offer(new Pair(temp.x - 1, temp.y));
                        visited[temp.x - 1][temp.y] = true;
                    }
                        
                    if (temp.x < n - 1 && board[temp.x + 1][temp.y] == first && !visited[temp.x + 1][temp.y])
                    {
                        bfs.offer(new Pair(temp.x + 1, temp.y));
                        visited[temp.x + 1][temp.y] = true;
                    }
                        
                    if (temp.y > 0 && board[temp.x][temp.y - 1] == first && !visited[temp.x][temp.y - 1])
                    {
                        bfs.offer(new Pair(temp.x, temp.y - 1));
                        visited[temp.x][temp.y - 1] = true;
                    }
                        
                    if (temp.y < n - 1 && board[temp.x][temp.y + 1] == first && !visited[temp.x][temp.y + 1])
                    {
                        bfs.offer(new Pair(temp.x, temp.y + 1));
                        visited[temp.x][temp.y + 1] = true;
                    }
                        
                }
                m1 = Math.max(m1, a);
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int first = board[i][j];
                int second = -1;

                bfs = new LinkedList<Pair>();
                visited = new boolean[n][n];
                bfs.offer(new Pair(i, j));
                int a = 0;
                while(!bfs.isEmpty())
                {
                    Pair temp = bfs.poll();
                    a++;
                    visited[temp.x][temp.y] = true;
                    int[] dx = {0, -1, 1, 0};
                    int[] dy = {1, 0, 0, -1};
                    for (int o = 0; o < 4; o++)
                    {
                        int x = Math.max(0, Math.min(n - 1, temp.x + dx[o]));
                        int y = Math.max(0, Math.min(n - 1, temp.y + dy[o]));
                        if (board[x][y] != first && board[x][y] != second)
                        {
                            if (second == -1)
                                second = board[x][y];
                            else 
                                continue;
                        }
                        if (!visited[x][y])
                        {
                            bfs.offer(new Pair(x, y));
                            visited[x][y] = true;
                        }
                            
                    }
                }
                m2 = Math.max(m2, a);
                //System.out.println(i + " " + j + " " + first + " " + second + "\n" + a);
            }
        }
        out.println(m1);
        out.println(m2);
        out.close();
    }
    
}
