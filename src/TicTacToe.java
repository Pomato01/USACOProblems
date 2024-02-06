import java.util.*;
import java.io.*;

public class TicTacToe {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("tttt.in"));
        PrintWriter out = new PrintWriter (new File("tttt.out"));

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++)
        {
            board[i] = in.next().toCharArray();
        }
        HashSet<HashSet<Character>> rows = new HashSet<>();
        for (int i = 0; i < 3; i++)
        {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < 3; j++)
            {
                row.add(board[i][j]);
            }
            rows.add(row);
        }
        for (int i = 0; i < 3; i++)
        {
            HashSet<Character> row = new HashSet<>();
            for (int j = 0; j < 3; j++)
            {
                row.add(board[j][i]);
            }
            rows.add(row);
        }
        HashSet<Character> row = new HashSet<>();
        for (int i = 0; i < 3; i++)
        {
            row.add(board[i][i]);
        }
        rows.add(row);
        row = new HashSet<>();
        for (int i = 0; i < 3; i++)
        {
            row.add(board[i][2 - i]);
        }
        rows.add(row);
        int s = 0, d = 0;
        for (HashSet<Character> a : rows)
        {
            if (a.size() == 1)
                s++;
            if (a.size() == 2)
                d++;
        }
        out.println(s);
        out.println(d);
        out.close();
    }
}
