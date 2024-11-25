# Main Topics
- Use inheritance to create a Stack class based on a basic doubly linked generic Linked List class
- Read an infix expression and convert it into a postfix expression using a stack
- Evaluate a postfix expression using a stack
- Test both stack implementations on a set of inputs before implementing it in a larger project
- Program development and management with Intellij and Git

# Task
All of you are familiar with an infix notation used in arithmetic formulae and statements that is characterized by an operator between operands (e.g., 1+1). It turns out that infix notation is more difficult to parse by computers so it is often preferred to convert it into a prefix (e.g., +11) or postfix notation (e.g, 11+) where the operator appears before or after the operands. Another major advantage is that prefix and postfix notation makes paren- theses obsolete even when order of operations need to be considered (i.e., multiply and divide operations take precedence over add and subtract).

The postfix notation was originally invented by Polish logician and philosopher Jan Łukasiewicz, and it is sometimes called "reverse Polish notation" or "reverse Łukasiewicz notation", owing to his nationality and name. Many desktop and handheld computers implement a postfix calculator under the hood to this day for the reasons stated above. Popular examples include Mac OS X calculator and iPhone and Android apps.

In this lab, you will implement 1) an infix to postfix converter, and 2) a postfix evaluator. For both algorithms, the stack data structure is an integral part of the algorithms, and you must implement one with the aid of only the Character and Integer library classes.

1. The infixToPostfix method should take in an infix expression string that contains single-digit numbers separated by the mathematical operators +, -, *, and / for addition, subtraction, multiplication, and division, respectively, as well as begin and end parentheses that can occur anywhere in the expression. It will return a postfix expression as a String. You may make the following assumptions:
  - All expressions consists of positive single-digit positive numbers separated by an operator.
  - The first character in an expression is either a digit or a left parenthesis.

In addition, you must check for and issue an appropriate error message for:
  - An expression with no digits or operators.
  - An operator that is not one of those listed above.
  - If there is a parenthesis mismatch.

2. The evalPostfix method should take in a postfix expression string that contains single-digit numbers and mathematical operators +, -, *, and / for addition, subtraction, multiplication, and division, respectively. It will return a numerical result as an Integer. You may make the following assumptions:
  - All expressions consists of positive single-digit positive numbers and operators.
  - The first character in an expression is a digit.

In addition, you must check for and issue an appropriate error message for:
  - An expression with no digits or operators.
  - An operator that is not one of those listed above.

3. You will be given starter code that contains a bare doubly linked generic Linked List class that you will need to create a Stack class via inheritance and use in your infixToPostfix and evalPostfix methods. In addition, there are two files with a main method, PostFixCalc.java and eCalc.java, where you will implement the infixToPostfix and evalPostfix methods, and they should be identical in both. The PostFixCalc.java file is provided for testing and grading, and the eCalc.java file is provided strictly for grading. The eCalc.java file contains code for the "front end" of your program, a graphical user interface (GUI; pronounced "gooey") that only works upon successful completion of your project’s "back end" implementation.

