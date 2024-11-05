import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        InferenceEngine Engine = new InferenceEngine();
        Engine.addRule(new ModusPonens());
        Engine.addRule(new ModusTollens());
        Engine.addRule(new HypotheticalSyllogism());
        Engine.addRule(new DisjunctiveSyllogism());
        Engine.addRule(new Resolution());

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Expression: ");
        Engine.addExpression(new Expression(sc.nextLine()));
        System.out.print("Enter Second Expression: ");
        Engine.addExpression(new Expression(sc.nextLine()));

        Expression Inference = Engine.applyRules();

        if(Inference != null)
            System.out.println(Inference.getRepresentation());
        else
            System.out.println("Expressions cannot be inferred");
    }
}