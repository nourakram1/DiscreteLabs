package LogicalExpressionSolver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Expression: ");
        String input = sc.nextLine();

        Expression expression = new Expression();
        try{
            expression.setRepresentation(input);
        }
        catch (Exception e){
            System.out.println("Wrong Expression: " + e.getMessage());
            return;
        }
        System.out.println("The Expression is "+new LogicalExpressionSolver().evaluateExpression(expression));
    }
}
