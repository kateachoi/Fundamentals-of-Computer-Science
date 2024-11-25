import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab3 {

    private static final Random rand = new Random();
    private static final int WORD_LENGTH = 5;
    private static final int MAX_TRIES = 6;


    public static void main(String[] args) {

        // if there is not exactly 1 command-line argument, error
        if (args.length != 1) {
            System.out.println("Error: java Lab2 <dictionary.txt>");
            System.exit(1);
        }

        String fileName = args[0];

        ArrayList<String> dict;

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

        // modify algorithm so that the count doesn't decrease if the word is not in the dictionary

        int attempts = 0; // track valid attempts
        int start = 0;
        int end = dict.size() - 1;

        while (attempts < MAX_TRIES) {
            System.out.print("Enter word (" + (attempts + 1) + "): ");
            String guess = scan.nextLine().trim().toLowerCase();

            if (!isValidWord(guess)) {
                System.out.println("Invalid word.");
                continue; // skip counting attempts for invalid words
            }

            int index;
            if (isSorted(dict)) {
                index = binarySearch(dict, start, end, guess);
            } else {
                index = linearSearch(dict, start, end, guess);
            }

            if (index != -1) {
                int[] match = matchDlewor(guess, target);
                printDlewor(guess, match);

                if (foundMatch(match)) {
                    System.out.println("Congratulations! You guessed the word: " + guess);
                    return;
                }

                attempts++;

            } else {
                System.out.println("Word not found in dictionary.");
            }

        }

        System.out.println("Sorry, you couldn't guess the word. The correct word was: " + target);

    }

    // check if the ArrayList is sorted
    public static boolean isSorted(ArrayList<String> list) {
        boolean sorted = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    // perform recursive binary search if the dictionary is sorted
    public static int binarySearch(ArrayList<String> words, int start, int end, String target) {

        if (end >= start && start <= words.size() - 1) {
            int mid = start + (end - start) / 2;

            // if the element is present at mid
            if (target.compareTo(words.get(mid)) == 0) {
                return mid;
            }

            // if the element is smaller than mid, then search left side of the ArrayList
            if (words.get(mid).compareTo(target) > 0) {
                return binarySearch(words, start, mid - 1, target);
            } else {
                // else, search the right side of the ArrayList
                return binarySearch(words, mid + 1, end, target);
            }
        }

        // element is not in the array
        return -1;
    }

    // perform recursive linear search if the dictionary is unsorted
    public static int linearSearch(ArrayList<String> words, int start, int end, String target) {

        if (start > end) {
            return -1; // base case; element not found
        }

        if (words.get(start).equals(target)) {
            return start; // base case; element found at the first index
        }

        // recursive case; search in the list start + 1 to end
        return linearSearch(words, start + 1, end, target);
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


}
