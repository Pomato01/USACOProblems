import java.util.*;

public class MooOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int x = 0; x < q; x++)
        {
            String s = in.next();
            int a = -1;
            if (s.length() < 3)
                System.out.println(-1);
            else
            {
                if (s.contains("OOM"))
                    a = 2;
                if (s.contains("MOM") || s.contains("OOO"))
                    a = 1;
                if (s.contains("MOO"))
                    a = 0;
            
                if (a == -1)
                    System.out.println(-1);
                else
                {
                    System.out.println(s.length() - 3 + a);
                }
            }
        }
    }
        
}
