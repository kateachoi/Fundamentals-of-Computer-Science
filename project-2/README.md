# Main Topics
- File input/output, input validation with Exceptions
- Client engagement, client acceptance testing, client satisfaction
- Program development and management with Intellij and Git

# Task
Dlewor(TM) (prounounced "del-wor") is a word guessing game that tasks the player with correctly selecting a random five-letter word. You only get six tries to guess the word but the game will give you hints with every guess. You start out by guessing a word without any hints, and the game will reveal if you 1) guessed the correct letter in the correct place (green), 2) guessed the correct letter but it is in an incorrect place (yellow), or 3) guess a letter that does not appear in the word at all (grey). For this project, the program will ask the user for a word read in the word, and perform a linear search to check whether the word exists in the dictionary. If so, the program will compare the letters and print out which letters were correct guesses in the correct location, correct guesses in an incorrect location, and incorrect guesses. All letters will be printed to the screen in the color coding described above. The user will be given 6 tries to
get the correct answer, and the program will gracefully terminate if a correct
match is found. If the word does not appear in the dictionary, the user will
be given an error message and allowed a do-over of the try. If the user fails
all 6 tries, the correct word will be printed to the screen.
Note: On the surface, this game appears to have remarkable similarities
to the popular 5-letter, 6-tries word guessing game, Wordle(TM). Even the
name seems to just be an inverse of the syllables of the name. In short, this
seems like a blatant, shallow, and shameless attempt to copy that game for
this project. Of course, all of this is just a coincidence.

1. Your program will read in one command line argument corresponding to
a dictionary file for the program. If there is not exactly one command
line arguments or if the file cannot be opened, an exception will be
thrown and the program will gracefully exit with an appropriate error
message
