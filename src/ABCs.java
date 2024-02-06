import java.util.*;

public class ABCs { //ez
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] n = new int[7];
        for (int i = 0; i < 7; i++)
        {
            n[i] = in.nextInt();
        }
        
        for (int a = 0; a < 5; a++)
        {
            for (int b = a + 1; b < 6; b++)
            {
                for (int c = b + 1; c < 7; c++)
                {
                    boolean w = true;
                    int A = n[a], B = n[b], C = n[c];
                    int[] check = {A + B, B + C, A + C, A + B + C};
                    for (int i = 0; i < check.length; i++)
                    {
                        if (!contains(n, check[i]))
                            w = false;
                    }
                    if (w)
                    {
                        int[] ans = {A, B, C};
                        Arrays.sort(ans);
                        System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);
                    }
                }
            }
        }
    }
    static boolean contains(int[] n, int a)
    {
        for (int i = 0; i < n.length; i++)
        {
            if (n[i] == a)
                return true;
        }
        return false;
    }
    
}
