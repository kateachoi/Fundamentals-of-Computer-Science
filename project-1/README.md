# Main Topics
- Array, ArrayList, class, objects, command line input, input validation with Exceptions, and formatted output.
- Program development and management with IntelliJ IDEA and Git

# Task
We want to simulate a shopping experience, where all the input comes exclusively from the command line. For each legal request, you will update the amount due subtotal associated with the shopping basket. Once all command line requests have been dispatched, then the sales tax and total due will be computed and displayed. This program is not interactive; the input comes from the command line. Design, implement, and test a well written Java program whose algorithmic flow is:

1. Review the class called **Item** which has a private ItemName (String), and a private ItemPrice (double). All the code for the constructors, getters, and setters has been provided and cannot be modified in any way. Your programming will be written in Lab1 class.

2. Create a method called **setupStore** that returns an array of Items that can be found in the store.

3. Create a method called **createCart**. This method will use ArrayList to create a cart based on the items available in the store. Within this function you should also:
   
    (a) **Read** a token n from the command line\
    (b) **Check** for exceptions and bad input\
    (c) **Return** an ArrayList constaining the items in the cart

4. Create a method called **printReceptInOrder** that prints out:

    (a) The List of items with their prices in order\
    (b) Subtotal\
    (c) Sales Tax (5%)\
    (d) Total

5. Create a final method called **emptyCartReverseOrder** that:
   
    (a) Prints the last item on the list\
    (b) Removes the item from the list\
    (c) Repeat steps (a) and (b) until the cart is empty.

6. Out of all the Big-Oh running times you have seen so far, what do you
think are the running times for:

    (a) **printReceiptInOrder**\
    (b) **emptyCartReverseOrder**
