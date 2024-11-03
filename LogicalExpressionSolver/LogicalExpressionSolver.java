import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class LogicalExpressionSolver implements ILogicalExpressionSolver{
    @Override
    public boolean evaluateExpression(Expression expression) {
        String Operands = Arrays.toString(expression.getOperands()).replaceAll("\\[|\\]|, ", "");
        String Representation = expression.getPostfixRepresentation();
        checkExpressionValidity(Representation);
        Representation = scanOperandsValues(Representation,Operands);
        return evaluate(Representation);
    }

    private void checkExpressionValidity(String Representation){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<Representation.length(); i++) {
            switch (Representation.charAt(i)) {
                case '^':
                    stack.pop();
                    break;
                case 'v':
                    stack.pop();
                    break;
                case '~':
                    break;
                case '>':
                    stack.pop();
                    break;
                default:
                    stack.push(Representation.charAt(i));
            }
        }
        stack.pop();
        if(!stack.isEmpty()){
            System.out.println("Wrong Expression: Less Operators");
            System.exit(0);
        }
    }

    private void printStack(Stack<Character> stack){
        Iterator<Character> iterator = stack.iterator();
        System.out.println("Stack elements:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private boolean evaluate(String Representation) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<Representation.length(); i++) {
            printStack(stack);
            System.out.println(Representation.charAt(i));
            switch(Representation.charAt(i)){
                case '^':
                    System.out.println(Representation.charAt(i));
                    stack.push(toChar(toBoolean(stack.pop()) && toBoolean(stack.pop())));
                    printStack(stack);
                    break;
                case 'v':
                    stack.push(toChar(toBoolean(stack.pop()) || toBoolean(stack.pop())));
                    break;
                case '~':
                    stack.push(toChar(!(toBoolean(stack.pop()))));
                    break;
                case '>':
                    stack.push(implication(stack.pop(), stack.pop()));
                    break;
                default:
                    stack.push(Representation.charAt(i));
            }
        }
        return toBoolean(stack.pop());
    }

    private boolean toBoolean(char value) {
        boolean booleanValue;
        if(value == '1') {
            booleanValue = true;
        }
        else {
            booleanValue = false;
        }
        return booleanValue;
    }

    private char toChar(boolean booleanValue) {
        char Value;
        if(booleanValue) {
            Value = '1';
        }
        else {
            Value = '0';
        }
        return Value;
    }

    private char implication(char operand2, char operand1) {
        if(operand1 == '1' && operand2 == '0')
            return '0';
        else
            return '1';
    }

    private String scanOperandsValues(String Representation,String Operands) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter T or F");
        //loop to scan the operands values
        for(int i=0; i<Operands.length(); i++) {
            System.out.print(Operands.charAt(i)+" = ");
            char operandValue = Character.toUpperCase(sc.next().charAt(0));
            //loop if input is not valid
            while(operandValue != 'T' && operandValue != 'F') {
                System.out.println("Please Enter Valid Input");
                System.out.print(Operands.charAt(i)+" = ");
                operandValue = Character.toUpperCase(sc.next().charAt(0));
            }
            Representation = replaceOperandByValue(Representation, Operands, operandValue, i);
        }

        return Representation;
    }

    private String replaceOperandByValue(String Representation,String Operands, char operandValue, int i) {
        //returns the Representation with values and operators
        if(operandValue == 'T') {
            Representation = Representation.replaceAll(Character.toString(Operands.charAt(i)), "1");
        }
        else{
            Representation = Representation.replaceAll(Character.toString(Operands.charAt(i)), "0");
        }
        return Representation;
    }
}
