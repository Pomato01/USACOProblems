import java.util.*;

public class LonelyPhoto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        char[] line = in.next().toCharArray();
        int a = 0;
        for (int i = 0; i < line.length; i++)
        {
            char current = line[i];
            char iterator = 0;
            int forward = i, backward = i;
            for (int j = i + 1; j < line.length; j++)
            {
                iterator = line[j];
                if (iterator == current)
                {
                    break;
                }
                forward++;
            }
            iterator = 0;
            for (int j = i - 1; j >= 0; j--)
            {
                iterator = line[j];
                if (iterator == current)
                {
                    break;
                }
                backward--;
            }
            int length = forward - backward + 1;
            int s = sumNums(length);


            
            if (length < 3)
                a += 0;
            else
            {
                a += s;
                if (forward - i > 3)
                    a -= sumNums(forward - i);
                if (i - backward > 3)
                    a -= sumNums(i - backward);
            }
        }
        System.out.println(a);
    }

    public static int sumNums (int a)
    {
        return (a * (a + 1))/2 - (2 * a) + 1;
    }
}
