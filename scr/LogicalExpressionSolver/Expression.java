package LogicalExpressionSolver;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Expression implements IExpression {
    private String postfixRepresentation;
    private Set<Character> operands;
    String Representation;

    public Expression() {
        postfixRepresentation = "";
        operands = new HashSet<>();
    }

    public Expression(String expression) {
        this.Representation = expression;
        operands = new HashSet<>();
        postfixRepresentation = "";
        try {
            setRepresentation(expression);
            new LogicalExpressionSolver().checkExpressionValidity(Representation);
        }
        catch (Exception e) {
            System.out.println("Wrong Expression: " + e.getMessage());
        }
    }

    @Override
    public String getRepresentation() { return Representation; }

    public String getPostfixRepresentation(){ return postfixRepresentation; }

    public Object[] getOperands() {
        return operands.toArray();
    }

    @Override
    public void setRepresentation(String representation) throws Exception {
        Representation = representation;
        representation= representation.replaceAll("~~","");
        Stack<Character> stack = new Stack<>();
        boolean isPrevOperator = false;

        for (int i = 0; i < representation.length(); i++) {
            char character = representation.charAt(i);
            if (character == ' ') continue;  // Skip spaces

            if (isOperand(character)) {
                handleOperand(character);
                isPrevOperator = false;
            } else if (isOperator(character)) {
                handleOperator(character, stack, i, representation, isPrevOperator);
                isPrevOperator = true;
            } else if (character == '(') {
                handleOpenParenthesis(i, representation, stack);
            } else if (character == ')') {
                handleCloseParenthesis(stack);
            } else {
                throw new Exception("Invalid character in expression: " + character);
            }
        }

        // Pop remaining operators in the stack
        popRemainingOperators(stack);
    }

    private void handleOperand(char character) {
        operands.add(character);
        postfixRepresentation += character;
    }

    private void handleOperator(char character, Stack<Character> stack, int index, String representation, boolean isPrevOperator) throws Exception {
        // Ensure operators are not consecutive except for '~'
        if (isPrevOperator && character != '~') {
            throw new Exception("Invalid consecutive operators in expression");
        }
        if (index == 0 && character != '~') {
            throw new Exception("Expression cannot start with an operator");
        }

        // Process the stack based on precedence
        while (!stack.isEmpty() && stack.peek() != '(' && getOperatorWeight(character) < getOperatorWeight(stack.peek())) {
            postfixRepresentation += stack.pop();
        }
        stack.push(character);
    }

    private void handleOpenParenthesis(int index, String representation, Stack<Character> stack) throws Exception {
        // Check for an invalid sequence of open parenthesis followed by an operator (except '~')
        if (index + 1 < representation.length() && isOperator(representation.charAt(index + 1)) && representation.charAt(index + 1) != '~') {
            throw new Exception("Invalid expression: operator immediately after '('");
        }
        stack.push('(');
    }

    private void handleCloseParenthesis(Stack<Character> stack) throws Exception {
        // Pop operators until '(' is found
        while (!stack.isEmpty() && stack.peek() != '(') {
            postfixRepresentation += stack.pop();
        }
        if (stack.isEmpty()) {
            throw new Exception("Mismatched parentheses");
        }
        stack.pop();  // Remove '('
    }

    private void popRemainingOperators(Stack<Character> stack) throws Exception {
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new Exception("Mismatched parentheses");
            }
            postfixRepresentation += stack.pop();
        }
    }

    private boolean isOperator(Character c) {
        return switch (c) {
            case '^', '>', 'v', '~' -> true;
            default -> false;
        };
    }

    private boolean isOperand(Character c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && c != 'v';
    }

    private int getOperatorWeight(char operator) {
        return switch (operator) {
            case '~' -> 4;   // NEGATION (highest precedence)
            case '^' -> 3;   // AND
            case 'v' -> 2;   // OR
            case '>' -> 1;   // IMPLICATION (lowest precedence)
            default -> -1;
        };
    }
}
