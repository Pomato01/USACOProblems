import java.util.*;
import java.io.*;

public class MilkMeasurementSilver {
    static class Entry implements Comparable<Entry>
    {
        int day;
        int cow;
        int change;

        public Entry(int day, int cow, int change)
        {
            this.day = day;
            this.cow = cow;
            this.change = change;
        }

        public int compareTo(Entry other)
        {
            return day - other.day;
        }
    }
    static class Cow implements Comparable<Cow>
    {
        int cow;
        int milk;
        
        public Cow(int cow, int milk)
        {
            this.cow = cow;
            this.milk = milk;
        }

        public int compareTo(Cow other)
        {
            return milk - other.milk;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("measurement.in"));
        PrintWriter out = new PrintWriter(new File("measurement.out"));

        int n = in.nextInt(), g = in.nextInt();
        TreeSet<Cow> cows = new TreeSet<Cow>();
        Entry[] entries = new Entry[n];
        for (int i = 0; i < n; i++)
        {
            int day = in.nextInt(), cow = in.nextInt(), change = Integer.parseInt(in.next());
            entries[i] = new Entry(day, cow, change);
        }
        Arrays.sort(entries);
        int currCow = -1; // -1 means various at g
        for (int i = 0; i < n; i++)
        {

        }
    }
}
