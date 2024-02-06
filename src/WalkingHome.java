import java.util.*;

public class WalkingHome
{
    public static int a = 0;
    public static int n = 0;
    public static int k = 0;
    public static char[][] grid = new char[n][n];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();

        a = 0;
        grid = new char[n][n];
        for (int i = 0; i < n; i++)
        {
            grid[i] = in.next().toCharArray();
        }
        
    }

    
    
}