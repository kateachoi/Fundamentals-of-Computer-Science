import java.util.ArrayList; //import ArrayList
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

    private static final double SALES_TAX_RATE = 0.05;

    public static void main(String[] args) {

        // take in command-line arguments from user input
        Scanner in = new Scanner(System.in);

        if (args == null || args.length == 0) {
            System.out.println("Please provide input.");
            return;
        }

        String combineArgs = String.join(" ", args);
        ArrayList<Character> tokens = new ArrayList<>();

        // make each input from the command-line its own token
        for (String arg : args) {
            for (char c : arg.toCharArray()) {
                tokens.add(c);
            }
        }

        // run methods
        try {
            ArrayList<Item> cart = createCart(tokens);
            printReceiptInOrder(cart);
            emptyCartReverseOrder(cart);
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            // catch InputMismatchException and IndexOutOfBoundsException from command-line args
            System.out.println("Exception: " + e.getMessage());
        }


    }

    public static Item[] setUpStore() {
        // create an array of type Item to hold item names and price.
        Item[] store = new Item[5];

        store[0] = new Item("Bananas", 1.5);
        store[1] = new Item("Apple", 0.5);
        store[2] = new Item("Bread", 2.0);
        store[3] = new Item("Milk", 3.0);
        store[4] = new Item("Eggs", 2.5);

        return store;
    }

    public static ArrayList<Item> createCart(ArrayList<Character> tokens) {

        // call setUpStore()
        Item[] store = setUpStore();
        // create an ArrayList of type Item to create the user's cart for only valid arguments
        ArrayList<Item> cart = new ArrayList<>();

        for (Character token : tokens) {
            try {
                if (Character.isDigit(token)) {
                    int index = Character.getNumericValue(token);

                    if (index < 0 || index >= store.length) {
                        // if the argument is an integer but is not an item indexed in the store, throw new IndexOutOfBoundsException
                        throw new IndexOutOfBoundsException("The store does not have an item of index " + index);
                    } else {
                        // valid command-line argument
                        cart.add(store[index]);
                    }

                } else {
                    // if the argument is not an integer, throw new InputMismatchException
                    throw new InputMismatchException("\"" + token.toString() + "\" is not a valid integer.");
                }
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                // catch exceptions
                System.out.println(e.getMessage());
            }
        }


        return cart;

    }

    public static void printReceiptInOrder(ArrayList<Item> cart) {

        double subtotal = 0.0;

        System.out.println("Receipt");
        System.out.println("==========================");
        System.out.printf("%-20s %-30s%n", "Item", "Price");

        for (Item item : cart) {
            System.out.printf("%-20s %-30.2f%n", item.getItemName(), item.getItemPrice());
            subtotal += item.getItemPrice();
        }

        double salesTax = SALES_TAX_RATE * subtotal;
        double total = subtotal + salesTax;

        System.out.println("==========================");
        System.out.printf("(a) Subtotal: $%-30.2f%n", subtotal);
        System.out.println("(b) Sales Tax: 5%%");
        System.out.printf("(c) Total: %-30.2f%n", total);

    }

    public static void emptyCartReverseOrder(ArrayList<Item> cart) {

        System.out.println("Removing all items from the cart in \"Last in First Out\" order...");
        for (int i = cart.size() - 1; i >= 0; i--) {
            Item item = cart.get(i);
            System.out.println("Removing: " + item.getItemName());
            cart.remove(i);
        }
        System.out.println("Cart has been emptied.");

    }
}
