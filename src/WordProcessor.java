import java.util.*;
import java.io.*;

public class WordProcessor
{
    public static void main (String[] args) throws IOException
    {
        Scanner in = new Scanner(new File("word.in"));
        PrintWriter out = new PrintWriter(new File("word.out"));
        int n = in.nextInt();
        int k = in.nextInt(); 
        String e = in.next() + in.nextLine();
        String[] es = e.split(" ");
        String temp;
        ArrayList<ArrayList<String>> essay = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < n; i++)
        {
            temp = es[i];
            if (size + temp.length() > k)
            {
                essay.add(current);
                current = new ArrayList<>();
                current.add(temp);
                size = temp.length();
            }
            else
            {
                current.add(temp);
                size += temp.length();
            }
            if (i == n - 1 && !current.isEmpty())
            {
                essay.add(current);
            }
        }
        for (int i = 0; i < essay.size(); i++)
        {
            for (int j = 0; j < essay.get(i).size(); j++)
            {
                out.print(essay.get(i).get(j));
                if (!(j == essay.get(i).size() - 1))
                    out.print(" ");
            }
            out.println();
        }
        out.close();
    }
}