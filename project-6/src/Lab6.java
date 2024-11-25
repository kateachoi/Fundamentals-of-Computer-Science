public class Lab6 {
    private static int playerWins = 0;
    private static int computerWins = 0;

    public static LinkedList initialize_deck() {

        LinkedList deck = new LinkedList();

        // populate linked list with a single deck of cards
        for (Card.suites s : Card.suites.values()) {
            for(Card.ranks r : Card.ranks.values()) {
                if (r != Card.ranks.NULL && s != Card.suites.NULL) {
                    Card newCard = new Card(s, r);
                    //newCard.print_card();
                    deck.add_at_tail(newCard);
                }
            }
        }

        return deck;
    }

    private static void play_blind_mans_bluff(LinkedList player1, LinkedList computer, LinkedList deck) {
        System.out.println("\nStarting Blind mans Bluff \n");
        // play the game
        int consecutiveLosses = 0;

        while (consecutiveLosses < 3) {
            // check if the player is out of cards
            if (player1.isEmpty() || computer.isEmpty()) {
                System.out.println("One of the players is out of cards. Game over.");
                return;
            }

            // each player removes a card from their hand
            Card playerCard = player1.remove_from_head();
            Card computerCard = computer.remove_from_head();

            // compare ranks of cards
            System.out.print("Player 1's card: ");
            playerCard.print_card();
            System.out.println();
            System.out.print("Computer's card: ");
            computerCard.print_card();
            System.out.println();
            if (playerCard.rank.ordinal() < computerCard.rank.ordinal()) {
                System.out.println("Player 1 wins this round.");
                playerWins++; // increment player wins
                consecutiveLosses = 0; // reset consecutive losses
            } else if (playerCard.rank.ordinal() > computerCard.rank.ordinal()) {
                System.out.println("Computer wins this round.");
                computerWins++; // increment computer wins
                consecutiveLosses++; // increment consecutive losses
            } else {
                System.out.println("It's a tie!");
            }

            // add the played card back to the deck
            deck.add_at_tail(playerCard);
            deck.add_at_tail(computerCard);
        }

        // if player1 loses 3 times in a row, call rage_quit()
        if (consecutiveLosses == 3) {
            rage_quit(player1, computer, deck);
            return; // exit the method after rage quit
        }
    }

    private static void rage_quit(LinkedList player1, LinkedList computer, LinkedList deck) {
        System.out.println("Player 1 has lost 3 times in a row. Rage quitting...");

        // add all cards back to the deck
        while (!player1.isEmpty()) {
            deck.add_at_tail(player1.remove_from_head());
        }
        while (!computer.isEmpty()) {
            deck.add_at_tail(computer.remove_from_head());
        }

        // shuffle the deck
        deck.shuffle(512);

        // redistribute 5 cards to each player
        for (int i = 0; i < 5; i++) {
            player1.add_at_tail(deck.remove_from_head());
            computer.add_at_tail(deck.remove_from_head());
        }

        // restart the game
        play_blind_mans_bluff(player1, computer, deck);
    }

    public static void main(String[] args) {

        // create a deck (in order)
        LinkedList deck = initialize_deck();
        deck.print();
        deck.sanity_check(); // because we can all use one

        // shuffle the deck (random order)
        deck.shuffle(512);
        deck.print();
        deck.sanity_check(); // because we can all use one

        // cards for player 1 (hand)
        LinkedList player1 = new LinkedList();
        // cards for player 2 (hand)
        LinkedList computer = new LinkedList();

        int num_cards_dealt = 5;
        for (int i = 0; i < num_cards_dealt; i++) {
            // player removes a card from the deck and adds to their hand
            player1.add_at_tail(deck.remove_from_head());
            computer.add_at_tail(deck.remove_from_head());
        }

        // let the games begin!
        play_blind_mans_bluff(player1, computer, deck);

        // display win/loss statistics
        System.out.println("Player wins: " + playerWins);
        System.out.println("Computer wins: " + computerWins);
    }
}
