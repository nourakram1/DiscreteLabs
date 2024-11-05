package InferenceRules.Rules;

import InferenceRules.InferenceRule;
import LogicalExpressionSolver.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resolution implements InferenceRule {
    private final Expression inferringResult = new Expression();

    public String getName() {
        return "Resolution";
    }

    private String negation(String checker){
        if (checker.charAt(0) == '~') {
            checker = checker.substring(1);
        } else {
            checker = "~" + checker;
        }
        return checker;
    }

    private boolean check(Expression exp, Matcher matcher) {
        Pattern checker = Pattern.compile(negation(matcher.group(1).trim())+"v(.*)");
        Matcher checkerMatcher = checker.matcher(exp.getRepresentation());

        if (checkerMatcher.matches()) {
            try {
                inferringResult.setRepresentation(matcher.group(2).trim() + " v " + checkerMatcher.group(1).trim());
            } catch (Exception e) {
                System.out.println("Wrong Expression : " + e.getMessage());
                System.exit(0);
            }
            return true;
        }

        checker = Pattern.compile("(.*)v"+ negation(matcher.group(1).trim()));
        checkerMatcher = checker.matcher(exp.getRepresentation());

        if (checkerMatcher.matches()) {
            try {
                inferringResult.setRepresentation(matcher.group(2).trim() + " v " + checkerMatcher.group(1).trim());
            } catch (Exception e) {
                System.out.println("Wrong Expression : " + e.getMessage());
                System.exit(0);
            }
            return true;
        }

        checker = Pattern.compile(negation(matcher.group(2).trim())+"v(.*)");
        checkerMatcher = checker.matcher(exp.getRepresentation());

        if (checkerMatcher.matches()) {
            try {
                inferringResult.setRepresentation(matcher.group(1).trim() + " v " + checkerMatcher.group(1).trim());
            } catch (Exception e) {
                System.out.println("Wrong Expression : " + e.getMessage());
                System.exit(0);
            }
            return true;
        }

        checker = Pattern.compile("(.*)v"+ negation(matcher.group(2).trim()));
        checkerMatcher = checker.matcher(exp.getRepresentation());

        if (checkerMatcher.matches()) {
            try {
                inferringResult.setRepresentation(matcher.group(1).trim() + " v " + checkerMatcher.group(1).trim());
            } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println("Wrong Expression : " + e.getMessage());
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("(.*)v(.*)");

        Matcher matcher = pattern.matcher(exp1.getRepresentation());
        if (matcher.matches()) {
            return check(exp2, matcher);
        }
        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        return inferringResult;
    }
}