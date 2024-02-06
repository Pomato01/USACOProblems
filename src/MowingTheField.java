import java.util.*;
import java.io.*;

public class MowingTheField {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("mowing.in"));
        PrintWriter out = new PrintWriter(new File("mowing.out"));
        int n = in.nextInt();
        int[][] farm = new int[2001][2001];
        int cX = 1000, cY = 1000, a, t = 0, dx = 0, dy = 0, ans = -1;
        char d;
        for (int i = 0; i < n; i++)
        {
            d = in.next().charAt(0);
            a = in.nextInt();
            if (d == 'N')
            {
                dx = 0;
                dy = 1;
            }
            if (d == 'S')
            {
                dx = 0;
                dy = -1;
            }
            if (d == 'E')
            {
                dx = 1;
                dy = 0;
            }
            if (d == 'W')
            {
                dx = -1;
                dy = 0;
            }
            for (int j = 0; j < a; j++)
            {
                t++;
                cX += dx;
                cY += dy;
                if (farm[cX][cY] != 0)
                {
                    if (ans == -1)
                        ans = t - farm[cX][cY];
                    else 
                        ans = Math.min(ans, t - farm[cX][cY]);
                }
                farm[cX][cY] = t;
            }
            
        }
        out.println(ans);
        out.close();
    }
}
