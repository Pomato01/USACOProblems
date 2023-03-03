import java.util.*;
import java.io.*;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("measurement.in"));
        PrintWriter out = new PrintWriter(new File("measurement.out"));

        int[] BSim = new int[101];
        int[] ESim = new int[101];
        int[] MSim = new int[101];
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int day = in.nextInt();
            String cow = in.next();
            String difference = in.next();
            int diff = 0;
            if (difference.substring(0, 1).equals("+"))
                diff = Integer.parseInt(difference.substring(1, 2));
            else
                diff = -1 * Integer.parseInt(difference.substring(1, 2));
            if (cow.equals("Bessie"))
                BSim[day] = diff;
            else if (cow.equals("Elsie"))
                ESim[day] = diff;
            else
                MSim[day] = diff;
            
        }
        BSim[0] = 7;
        ESim[0] = 7;
        MSim[0] = 7;
        for (int i = 1; i < 101; i++)
        {
            BSim[i] += BSim[i - 1];
            ESim[i] += ESim[i - 1];
            MSim[i] += MSim[i - 1];
        }
        String[] display = new String[100];
        for (int i = 0; i < 100; i++)
        {
            if (BSim[i] == ESim[i] && ESim[i] == MSim[i])
                display[i] = "BEM";
            else if (BSim[i] == ESim[i] && ESim[i] > MSim[i])
                display[i] = "BE";
            else if (ESim[i] == MSim[i] && ESim[i] > BSim[i])
                display[i] = "EM";
            else if (MSim[i] == BSim[i] && BSim[i] > ESim[i])
                display[i] = "BM";
            else if (MSim[i] > BSim[i] && MSim[i] > ESim[i])
                display[i] = "M";
            else if (ESim[i] > BSim[i] && ESim[i] > MSim[i])
                display[i] = "E";
            else if (BSim[i] > ESim[i] && BSim[i] > MSim[i])
                display[i] = "B";
        }
        int counter = 0;
        for (int i = 1; i < display.length; i++)
        {
            if (!display[i].equals(display[i - 1]))
            {
                counter++;
            }
        }
        out.println(counter);
        out.close();
    }
}
