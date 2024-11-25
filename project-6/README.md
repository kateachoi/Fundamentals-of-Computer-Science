# Main Topics
- Doubly linked lists and managing elements pertaining to them.
- Implement a simple card game using a standard French style deck of cards.
- Reading the lab manual thoroughly as there are a lot of details.
- Program development and management with Intellij and Git.

# Game

The card game Blind Man’s Bluff usually works as follows: two players are each dealt a card. Without looking at the card, each player places their card on their forehead face out so that they can see their opponent’s card value, but they cannot see their own card’s value. Then one player guesses whether whether or not their card is higher or lower than their opponent’s. The game is played with a standard French-style 52-card deck, which consists of cards each with one of 13 ranks (2, 3, . . . , 9, 10, Jack, King, Queen, Ace) and one of 4 suits (Clubs, Diamonds, Hearts, Spades). Of course, it is also possible to play this game using other style of cards.

In this project, we will simulate Blind Man’s Bluff as a one player game, where the user is dealt a card, shown their opponent’s card, and then asked to guess if their card is higher or lower. The lowest rank for the card is 2, 3, ... and it ends with King, Queen and Ace on the upper end. If the rank is the same, the suit is used as a tie-breaker. In a single deck, there are no duplicates so no games end in a tie.

# Task
You will be given a lot of starter code and a driver. Within class main the play_blind_mans_bluff is the only method that you need to edit. You will also have to create a new method called rage_quit(). The driver does not need to be changed but I would recommend you test every method that you construct.

When implementing this in code you should remove cards from the com- puter and player1 deck and compare the ranks of the cards. Enums have some numeric value based on the order that they are defined. I would recommend adding the cards back to the main deck if we are done playing around (helpful if you are planning on rage quitting)

We want to play the game with 5 cards. If player1 loses 3 times in a row then the method rage_quit() will be called. This adds all the cards back into the deck until there are 52 cards and shuffles and redeals 5 cards to both player1 and the computer for blind man’s bluff to be played again. At the end of your project you should display win/loss statistics.

**class *Card***:/
This contains 2 enumerations (enum) for all valid suites and ranks of the card. The data members of this class are suit and rank of types enum suites and enum ranks. For both enumerations there is a null type which signifies an invalid card. Other than the constructors you will also need to use the print_card() method which will print out the suite and rank of the calling card object.

**class *Node***:/
This contains 3 variables, the Card data, Node next, and Node prev. The next and prev part of the node class will need to be correctly updated to maintain the sanctity of the doubly linked list.

**class *LinkedList***:/
There are 3 data members of this class, the head, the tail, and int size. The head and tail are Node references which reference the beginning and end of the LinkedList, respectively. You should be deliberate and careful when you are adding/removing items from the LinkedList and make sure to update the size appropriately. The methods: 

sanity_check(): checks to see if the LinkedList makes logical sense by iterating from the head and tail, counting each node and cross checking it with the size variable of the LinkedList. This method checks:

  - if a node is accidentally still attached (incorrectly removed)
  - size is updated correctly
  - the head and tail have been correctly updated
  - each node’s prev and next elements are correctly updated

I would strongly recommend utilizing this method for testing any LinkedList methods that you need to create.

  print(): prints the LinkedList\
  shuffle(): takes in an integer argument and randomly swaps nodes within the LinkedList that       many times.

*swap(int index1, int index2)*:\
This method utilizes the remove_from_index and insert_at_index methods to effectively swap 2 cards in the deck.

Hint: Removing and adding cards will impact the size of the LinkedList and might also impact the index number you might be adding to after you remove a card. Think through this carefully.

*remove_from_index(int index)* and *insert-at_index(Card x, int index)* fo as the name suggests. For the swap to work perfectly you will need to thoroughly test these methods and account for all the edge cases.

The other 2 methods that you will need to write and test are *add_at_tail(Card data)* which will be used to populate your deck and *remove_from_head()* which will be used to deal cards to the player and computer.

You can also write up other helper methods like isEmpty or any other
method as needed.
