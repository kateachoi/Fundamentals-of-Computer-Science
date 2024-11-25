import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {

    private static ArrayList<String> dict = new ArrayList<>();
    private static Random rand = new Random();
    private static final int WORD_LENGTH = 5;
    private static final int MAX_TRIES = 6;


    public static void main(String[] args) {

        // if there is not exactly 1 command-line argument, error
        if (args.length != 1) {
            System.out.println("Usage: java Lab2 <dictionary.txt>");
            System.exit(1);
        }

        String fileName = args[0];

        // if the file cannot be opened, throw an exception
        try {
            dict = readDict(fileName);
        } catch (IOException e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
            return;
        }

        // generate random word from the ArrayList dict
        String target = getRandomWord(dict);

        Scanner scan = new Scanner(System.in);

        // prompt user for words and check whether the word exists in the dictionary (linear search)
        for (int i = 0; i < MAX_TRIES; i++) {
            System.out.print("Enter word (" + (i + 1) + "): ");
            String guess = scan.nextLine().trim().toLowerCase();

            if (!isValidWord(guess)) {
                System.out.println("Invalid word.");
                continue;
            }

            int index = linearSearch(dict, 0 ,dict.size() - 1, guess);

            if (index != -1) {
                int[] match = matchDlewor(guess, target);
                printDlewor(guess, match);

                if (foundMatch(match)) {
                    System.out.println("Congratulations! You guessed the word: " + guess);
                    return;
                }

            } else {
                System.out.println("Word not found in dictionary.");
            }

        }

        System.out.println("Sorry, you couldn't guess the word. The correct word was: " + target);


    }

    // read dictionary file and determine validity
    public static ArrayList<String> readDict(String filename) throws IOException {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == WORD_LENGTH) {
                    words.add(line);
                }
            }
        }

        return words;
    }

    // generate random word
    public static String getRandomWord(ArrayList<String> words) {
        return words.get(rand.nextInt(words.size()));
    }

    public static boolean isValidWord(String word) {
        return word.matches("[a-z]{" + WORD_LENGTH + "}");
    }

    public static int[] matchDlewor(String guess, String target) {
        int[] match = new int[5];

        for (int i = 0; i < 5; i++) {
            char guessChar = guess.charAt(i);
            char targetChar = target.charAt(i);

            if (guessChar == targetChar) {
                match[i] = 1; // correct letter, correct index
            } else if (target.indexOf(guessChar) != -1) {
                match[i] = 2; // correct letter, incorrect index
            } else {
                match[i] = 3; // letter is not in the word
            }
        }

        return match;
    }

    public static void printDlewor(String guess, int[] match) {
        for (int i = 0; i < 5; i++) {
            char c = guess.charAt(i);

            switch (match[i]) {
                case 1:
                    // green background
                    System.out.print(Dlewor.ANSI_GREEN_BACKGROUND + Dlewor.ANSI_BLACK + c);
                    break;
                case 2:
                    // yellow background
                    System.out.print(Dlewor.ANSI_YELLOW_BACKGROUND + Dlewor.ANSI_BLACK + c);
                    break;
                case 3:
                    // black background
                    System.out.print(Dlewor.ANSI_WHITE_BACKGROUND + Dlewor.ANSI_BLACK + c);
                    break;
            }
        }

        System.out.println(Dlewor.ANSI_RESET); // reset colors
    }

    // check if the attempted word matches the target word
    public static boolean foundMatch(int[] match) {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (match[i] != 1) {
                return false;
            }
        }
        return true;
    }

    // perform linear search
    public static int linearSearch(ArrayList<String> words, int start, int end, String target) {
        for (int i = start; i <= end; i++) {
            if (words.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

}
