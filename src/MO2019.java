import java.util.*;

public class MO2019 { // types are annoying af
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long s = in.nextLong();
        int len = (int)Math.log10(s);

        long[] p = new long[len + 1];
        int[] rem = new int[len + 1];
        long[] count = new long[2019];
        
        for (int i = 0; i < len + 1; i++)
        {
            p[i] = s % (long)Math.pow(10, i);
            rem[i] = (int)(p[i] % 2019);
            count[rem[i]]++;
        }
        long a = 0;
        for (int i = 0; i < 2019; i++)
        {
            a += c2(count[i]);
        }
        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(rem));
        System.out.println(a);
    }
    static long factorial (long a)
    {
        if (a < 2)
            return 1;
        long n = 1;
        for (int i = 2; i <= a; i++)
            n *= a;
        return n;
    }

    static long c2 (long num)
    {
        if (num == 0)
            return 0;
        if (num == 1)
            return 0;
        if (num == 2)
            return 1;
        long a = factorial(num);
        a /= (2 * factorial(num - 2));
        return a;
    }

    static double fmod(double a, double b) {
        int result = (int) Math.floor(a / b);
        return a - result * b;
    }
}
