import java.util.*;
import java.io.*;

public class ModernArt { //ez
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("art.in"));
        PrintWriter out = new PrintWriter (new File("art.out"));

        int n = in.nextInt();
        ArrayList<Integer> visible = new ArrayList<>();
        int[][] canvas = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            String temp = in.next();
            for (int j = 0; j < n; j++)
            {
                canvas[i][j] = Integer.parseInt(temp.substring(j, j + 1));
                if (!visible.contains(canvas[i][j]) && canvas[i][j] != 0)
                {
                    visible.add(canvas[i][j]);
                }
            }
        }
        boolean[] first = new boolean[10];
        for (int i = 0; i < visible.size(); i++)
        {
            first[visible.get(i)] = true;
        }
        for (int i = 0; i < visible.size(); i++)
        {
            int tl_x = 0, tl_y = 0, br_x = 0, br_y = 0;
            int current = visible.get(i);
            // find tlx, tly, brx, and bry
            outerloop:
            for (int j = 0; j < canvas.length; j++)
            {
                for (int k = 0; k < canvas[j].length; k++)
                {
                    if (canvas[j][k] == current)
                    {
                        tl_x = j;
                        break outerloop;
                    }
                }
            }
            outerloop1:
            for (int j = canvas.length - 1; j >= 0; j--)
            {
                for (int k = 0; k < canvas[j].length; k++)
                {
                    if (canvas[j][k] == current)
                    {
                        br_x = j;
                        break outerloop1;
                    }
                }
            }
            outerloop2:
            for (int k = 0; k < canvas.length; k++)
            {
                for (int j = 0; j < canvas.length; j++)
                {
                    if (canvas[j][k] == current)
                    {
                        tl_y = k;
                        break outerloop2;
                    }
                }
            }
            outerloop3:
            for (int k = canvas.length - 1; k >= 0; k--)
            {
                for (int j = 0; j < canvas.length; j++)
                {
                    if (canvas[j][k] == current)
                    {
                        br_y = k;
                        break outerloop3;
                    }
                }
            }
            for (int j = tl_x; j <= br_x; j++)
            {
                for (int k = tl_y; k <= br_y; k++)
                {
                    if (canvas[j][k] != current)
                    {
                        first[canvas[j][k]] = false;
                    }
                }
            }
            //System.out.println("" + tl_x + ", " + tl_y + " " + br_x + ", " + br_y);
        }
        int count = 0;
        for (boolean w : first)
        {
            if (w)
                count++;
        }
        out.println(count);
        out.close();
    }
}
