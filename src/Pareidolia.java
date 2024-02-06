import java.util.*;

public class Pareidolia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int current = 0;
        int a = 0;
        int start = 0;
        for (int i = 0; i < s.length; i++)
        {
            if (current == 0)
            {
                if (s[i] == 'b')
                {
                    current++;
                    start = i;
                    continue;
                }
            }
            else if (current == 1)
            {
                if (s[i] == 'e')
                {
                    current++;
                    continue;
                }
            }
            else if (current == 2)
            {
                if (s[i] == 's')
                {
                    current++;
                    continue;
                }
            }
            else if (current == 3)
            {
                if (s[i] == 's')
                {
                    current++;
                    continue;
                }
            }
            else if (current == 4)
            {
                if (s[i] == 'i')
                {
                    current++;
                    continue;
                }
            }
            else if (current == 5)
            {
                if (s[i] == 'e')
                {
                    current = 0;
                    a += (start + 1) * (s.length - i);
                }
            }
        }
        System.out.println(a);
    }
}
