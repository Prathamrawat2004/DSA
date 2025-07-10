package Stackque;
// revisions = 1
import java.util.*;

public class EvaluateExpression {
    // both brute-force & optimized approach
    public int evalRPN(ArrayList<String> A) {
        // stack to store elements
        Stack<Integer> stack = new Stack<>();

        for (String str : A) {
            // as A contains expression in reverse polish expression
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                // getting the operands out of stack
                int a = stack.pop();
                int b = stack.pop();

                switch (str) {
                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;

                    default:
                        break;
                }

            } else {
                // if the string is a number
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
