import java.util.*;
import java.io.*;

public class YearOfTheCow {
    public static int n;
    public static int[] years;
    public static String[] names;
    public static int[] zodiacs;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("yotc.in"));
        n = in.nextInt();
        years = new int[n + 1];
        names = new String[n + 1];
        zodiacs = new int[n + 1];
        names[0] = "Bessie";
        zodiacs[0] = 1;
        years[0] = 0;

        for (int i = 1; i < n + 1; i++)
        {
            String[] temp = {in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next(), in.next()};
            String newCow = temp[0];
            String oldCow = temp[7];
            int oldZ = zodiacOf(oldCow);
            int newZ = orderOf(temp[4]);
            int diff = newZ - oldZ;
            boolean next = temp[3].equals("next");
            names[i] = newCow;
            years[i] = yearOf(oldCow) + diff;
            if (next && diff <= 0)
            {
                years[i] += 12;
            }
            if (!next && diff >= 0)
            {
                years[i] -= 12;
            }
            zodiacs[i] = newZ;
        }
        System.out.println(Math.abs(yearOf("Elsie")));
    }

    public static int yearOf (String c)
    {
        for (int i = 0; i < n + 1; i++)
        {
            if (names[i].equals(c))
            {
                return years[i];
            }
        }
        return -1;
    }

    public static int orderOf (String zodiac)
    {
        String[] order = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
        for (int i = 0; i < order.length; i++)
        {
            if (zodiac.equals(order[i]))
                return i + 1;
        }
        return -1;
    }

    public static int zodiacOf(String s)
    {
        for (int i = 0; i < n + 1; i++)
        {
            if (names[i].equals(s))
            {
                return zodiacs[i];
            }
        }
        return -1;
    }
}
