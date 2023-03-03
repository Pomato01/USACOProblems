import java.util.*;
import java.io.*;

public class ClockwiseFence {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int c = 0; c < n; c++)
        {
            char[] path = in.next().toCharArray();
            int direction = 0;
            for (int i = 0; i < path.length; i++)
            {
                int next = (i + 1) % path.length;
                if (path[i] == 'N')
                {
                    if (path[next] == 'N')
                    {

                    }
                    else if (path[next] == 'S')
                    {

                    }
                    else if (path[next] == 'E')
                    {
                        direction++;
                    }
                    else if (path[next] == 'W')
                    {
                        direction--;
                    }
                }
                else if (path[i] == 'S')
                {
                    if (path[next] == 'N')
                    {

                    }
                    else if (path[next] == 'S')
                    {

                    }
                    else if (path[next] == 'E')
                    {
                        direction--;
                    }
                    else if (path[next] == 'W')
                    {
                        direction++;
                    }
                }
                else if (path[i] == 'E')
                {
                    if (path[next] == 'N')
                    {
                        direction--;
                    }
                    else if (path[next] == 'S')
                    {
                        direction++;
                    }
                    else if (path[next] == 'E')
                    {
                        
                    }
                    else if (path[next] == 'W')
                    {
                        
                    }
                }
                else if (path[i] == 'W')
                {
                    if (path[next] == 'N')
                    {
                        direction++;
                    }
                    else if (path[next] == 'S')
                    {
                        direction--;
                    }
                    else if (path[next] == 'E')
                    {
                        
                    }
                    else if (path[next] == 'W')
                    {
                        
                    }
                }
            }
            if (direction > 0)
            {
                System.out.println("CW");
            }
            else
            {
                System.out.println("CCW");
            }
        }
    }
}
