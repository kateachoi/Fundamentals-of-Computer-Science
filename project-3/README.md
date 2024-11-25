# Main Topics
- File input/output, input validation with Exceptions
- Recursive Algorithms
- Program development and management with IntelliJ and Git

# Task
Dlewor(TM) (prounounced "del-wor") is a word guessing game that tasks the player with correctly selecting a random five-letter word. You only get six tries to guess the word but the game will give you hints with every guess. You start out by guessing a word without any hints, and the game will reveal if you 1) guessed the correct letter in the correct place (green), 2) guessed the correct letter but it is in an incorrect place (yellow), or 3) guess a letter that does not appear in the word at all (grey).

For this project, the program will ask the user for a word read in the word, and perform a **recursive binary** or linear search to check whether the word exists in the dictionary. If so, the program will compare the letters and print out which letters were correct guesses in the correct location, correct guesses in an incorrect location, and incorrect guesses. All letters will be printed to the screen in the color coding described above. The user will be given 6 tries to get the correct answer, and the program will gracefully terminate if a correct match is found. If the word does not appear in the dictionary, the user will be given an error message and allowed a do-over of the try. If the user fails all 6 tries, the correct word will be printed to the screen.

Note: On the surface, this game appears to have remarkable similarities
to the popular 5-letter, 6-tries word guessing game, Wordle(TM). Even the
name seems to just be an inverse of the syllables of the name. In short, this
seems like a blatant, shallow, and shameless attempt to copy that game for
this project. Of course, all of this is just a coincidence.

1. Your program will read in one command line argument corresponding to a dictionary file for the program. If there is not exactly one command line arguments or if the file cannot be opened, an exception will be thrown and the program will gracefully exit with an appropriate error message.

2. The program will then read in a dictionary file with one word per line, and you will store only the words that contain exactly 5 characters into an ArrayList.

3. The program will use a random number generator to select one word from the ArrayList.

4. The program will ask the user for 6 words and check whether the word exists in the dictionary, using a **recursive binary search if the list is sorted, or a recursive linear search if it is not. You must verify whether the list is sorted via a method isSorted that opens the file and checks.**

5. Write a method foundMatch that takes a "match" integer array and returns whether or not all of the letters match. This must be written generally so that the program can be easily generalized to a different number of letters in a word.

6. **Write a recursive method binarySearch that takes an ArrayList of Strings, two integers corresponding to the beginning and end indices of the search, and a "target" String. It will return the index of the "target" if it is found in the ArrayList, -1 otherwise.**

7. Write a **recursive** method linearSearch that takes in an ArrayList of Strings, two integers corresponding to the beginning and end indices of the search, and a "target" String. It will return the index of the "target" if it is found in the ArrayList, -1 otherwise. **Hint: Each recursive call can check two elements at a time.**

8. Write a method matchDlewor that compares the "target" String and an "attempt" String and store whether each letter matches in a "match" array of integers.

9. Write a method printDelwor that takes an "attempt" String and "match" integer array and prints the attempted word with Dlewor colored text as described above.

10. Out of all the Big-Oh running times you have seen so far, what you think are the running times for:
  - **linearSearch**
  - **binarySearch**
  - **isSorted**
