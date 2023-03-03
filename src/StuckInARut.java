import java.util.*;

public class StuckInARut { 
    
    // this def doesnt work and will crash probably any normal computer dont run it
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        boolean[][] grid = new boolean[(int)Math.pow(10, 9)][(int)Math.pow(10, 9)];
        String[] direction = new String[n];
        int[] x = new int[n];
        int[] y = new int[n];
        boolean[] cont = new boolean[n];
        for (int i = 0; i < cont.length; i++)
        {
            cont[i] = true;
        }
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = 0;
        }
        while (istrue(cont))
        {
            for (int i = 0; i < n; i++)
            {
                if (direction[i].equals("N"))
                {
                    if (cont[i])
                    {
                        cont[i] = false;
                        for (int j = 0; j < n; j++)
                        {
                            if (y[j] > y[i])
                            {
                                cont[i] = true;
                            }
                        }
                        if (cont[i])
                        {
                            if (grid[x[i]][y[i]] == true)
                            {
                                cont[i] = false;
                                y[i]++;
                                a[i]++;
                            }
                            else
                            {
                                grid[x[i]][y[i]] = true;
                                y[i]++;
                            }
                        }
                        else
                        {
                            cont[i] = false;
                            a[i] = -1;
                            grid[x[i]][y[i + 1]] = true;
                            grid[x[i]][y[i]] = true;
                        }
                    }
                }
                else if (direction[i].equals("S"))
                {
                    if (cont[i])
                    {
                        cont[i] = false;
                        for (int j = 0; j < n; j++)
                        {
                            if (y[j] < y[i])
                            {
                                cont[i] = true;
                            }
                        }
                        if (cont[i])
                        {
                            if (grid[x[i]][y[i]] == true)
                            {
                                cont[i] = false;
                                y[i]--;
                                a[i]++;
                            }
                            else
                            {
                                grid[x[i]][y[i]] = true;
                                y[i]--;
                            }
                        }
                        else
                        {
                            cont[i] = false;
                            a[i] = -1;
                            grid[x[i]][y[i - 1]] = true;
                            grid[x[i]][y[i]] = true;
                        }
                    }
                }
                else if (direction[i].equals("E"))
                {
                    if (cont[i])
                    {
                        cont[i] = false;
                        for (int j = 0; j < n; j++)
                        {
                            if (x[j] > x[i])
                            {
                                cont[i] = true;
                            }
                        }
                        if (cont[i])
                        {
                            if (grid[x[i]][y[i]] == true)
                            {
                                cont[i] = false;
                                x[i]++;
                                a[i]++;
                            }
                            else
                            {
                                grid[x[i]][y[i]] = true;
                                x[i]++;
                            }
                        }
                        else
                        {
                            cont[i] = false;
                            a[i] = -1;
                            grid[x[i + 1]][y[i]] = true;
                            grid[x[i]][y[i]] = true;
                        }
                    }
                }
                else if (direction[i].equals("W"))
                {
                    if (cont[i])
                    {
                        cont[i] = false;
                        for (int j = 0; j < n; j++)
                        {
                            if (x[j] < x[i])
                            {
                                cont[i] = true;
                            }
                        }
                        if (cont[i])
                        {
                            if (grid[x[i]][y[i]] == true)
                            {
                                cont[i] = false;
                                x[i]--;
                                a[i]++;
                            }
                            else
                            {
                                grid[x[i]][y[i]] = true;
                                x[i]--;
                            }
                        }
                        else
                        {
                            cont[i] = false;
                            a[i] = -1;
                            grid[x[i - 1]][y[i]] = true;
                            grid[x[i]][y[i]] = true;
                        }
                    }
                }
            }
        }
        for (int w : a)
        {
            if (w == -1)
                System.out.println("Infinity");
            else
                System.out.println(w);
        }
    }

    public static boolean istrue(boolean[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i])
                return true;
        }
        return false;
    }
}
