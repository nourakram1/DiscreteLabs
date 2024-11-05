package InferenceRules.Rules;

import InferenceRules.InferenceRule;
import LogicalExpressionSolver.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModusPonens implements InferenceRule {
    private final Expression inferringResult = new Expression();
    public String getName(){
        return "Modus Ponens";
    }

    private boolean check(Expression exp, Matcher matcher){
        String checker = matcher.group(1).trim();

        if(exp.getRepresentation().equals(checker)){
            try {
                inferringResult.setRepresentation(matcher.group(2).trim());
            }
            catch (Exception e){
                System.out.println("Wrong Expression : " + e.getMessage());
                System.exit(0);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        try {
            exp1.setRepresentation(exp1.getRepresentation().replaceAll(" ", ""));
            exp2.setRepresentation(exp2.getRepresentation().replaceAll(" ", ""));
        }
        catch (Exception e){
            System.out.println("Wrong Expression : " + e.getMessage());
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("(.*)>(.*)");

        Matcher matcher = pattern.matcher(exp1.getRepresentation());
        if (matcher.matches()) {
            return check(exp2, matcher);
        }

        matcher = pattern.matcher(exp2.getRepresentation());
        if (matcher.matches()) {
            return check(exp1, matcher);
        }

        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        return  inferringResult;
    }
}