import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Lab7 {

    public static Integer EvaluatePostFix(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op2 - op1);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op2 / op1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // A utility function to return the precedence of a given operator
    static int precedence(Character ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

        }
        return -1;
    }

    public static String InfixToPostfix(String exp) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // discard '('
            } else { // operator
                while (!stack.empty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.empty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Infix Expression: ");
        String InFixExpression = input.nextLine();

        String PostFixExpression = InfixToPostfix((InFixExpression));
        System.out.println(PostFixExpression);

        Integer result = EvaluatePostFix(PostFixExpression);
        System.out.println(result);

    }
}
