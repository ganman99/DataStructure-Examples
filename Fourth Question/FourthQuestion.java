
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class FourthQuestion{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a mathematical expression: ");
        String expression = scanner.nextLine();

        try {
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        
    }

    private static double evaluateExpression(String expression) {
        Deque<Double> operandStack = new LinkedList<>();
        Deque<Character> operatorStack = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar) || currentChar == '.') {
                
                StringBuilder operand = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand.append(expression.charAt(i));
                    i++;
                }
                i--; 
                operandStack.push(Double.parseDouble(operand.toString()));
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop '('
            } else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= getPrecedence(currentChar)) {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.push(currentChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            performOperation(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

    private static void performOperation(Deque<Double> operandStack, Deque<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        operandStack.push(performOperation(operator, operand1, operand2));
    }

    private static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
