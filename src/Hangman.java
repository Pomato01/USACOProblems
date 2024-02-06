import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] wordbank = {"snow", "ornaments", "stockings", "carols", 
        "mistletoe", "jingle", "bells", "gingerbread", "reindeer", 
        "sleigh", "presents", "tinsel", "lights", "wreat", };
        int chances = 7;
        String answer = wordbank[(int)(Math.random() * (wordbank.length + 1))];
        char[] cAnswer = answer.toCharArray();
        boolean[] guessed = new boolean[answer.length()];
        boolean correct = false;

        System.out.println("[put instructions here]");

        while (chances > 0)
        {
            // display current progress of word
            for (int i = 0; i < answer.length(); i++)
            {
                if (guessed[i])
                    System.out.print(cAnswer[i]);
                else 
                    System.out.print("_");
            }
            System.out.println();
            // input user guess
            System.out.println("Enter your guess. You have " + chances + " guesses left.");
            char guess = in.next().charAt(0);
            boolean validGuess = false;
            for (int i = 0; i < cAnswer.length; i++)
            {
                if (guess == cAnswer[i])
                {
                    guessed[i] = true;
                    validGuess = true;
                }
            }
            if (!validGuess)
                chances--;
            boolean finished = true;
            for (int i = 0; i < cAnswer.length; i++)
            {
                if (!guessed[i])
                    finished = false;
            }
            if (finished)
            {
                correct = true;
                break;
            }
            System.out.println("\n\n\n");
        }
        if (correct)
            System.out.print("You Won!");
        else 
            System.out.print("You Lost!");
        System.out.println(" The answer was: " + answer);
    }
}
